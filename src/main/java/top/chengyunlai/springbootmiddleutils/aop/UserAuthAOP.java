package top.chengyunlai.springbootmiddleutils.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import top.chengyunlai.springbootmiddleutils.annotation.UserAuth;
import top.chengyunlai.springbootmiddleutils.common.GlobalEnum;
import top.chengyunlai.springbootmiddleutils.common.GlobalException;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author Chengyunlai
 * @description: TODO
 * @date 2023/8/2
 */
@Aspect
@Slf4j
@Component
public class UserAuthAOP {

    @Resource
    private String groupList;

    /**
     * @description: 对 UserAuth 注解的切面
     * @param: []
     * @return: void
     * @author Chengyunlai
     * @date: 2023/8/2
     */
    @Pointcut("@annotation(top.chengyunlai.springbootmiddleutils.annotation.UserAuth)")
    public void userAuth() {
    }


    @Around("userAuth()")
    public Object aroundUserAuth(ProceedingJoinPoint point) throws GlobalException {
        log.info("用户认证");
        try {
            if(StringUtils.isEmpty(groupList)){
                log.info("配置用户认证是:{}",groupList);
                return point.proceed();
            }
            // 获得方法签名
            Signature sig = point.getSignature();
            MethodSignature methodSignature = (MethodSignature) sig;
            Method method = methodSignature.getMethod();
            // 获得注解
             UserAuth userAuth = method.getAnnotation(UserAuth.class);
             if (!ObjectUtils.isEmpty(userAuth)) {
                 // 获得方法参数
                 String keyValue = point.getArgs()[0].toString();
                 log.info("用户认证，拦截的方法是：{} 拦截到用户组是：{}", method.getName(), keyValue);
                 if (ObjectUtils.isEmpty(keyValue)) {
                     throw new GlobalException(GlobalEnum.UNAUTHORIZED);
                 }
                 // 用户认证
                 String[] split = groupList.split(",");
                 // 白名单
                 for (String str : split) {
                     if (keyValue.equals(str)) {
                         return point.proceed();
                     }
                 }
             }else {
                 return point.proceed();
             }
             // 黑名单
            throw new GlobalException(GlobalEnum.UNAUTHORIZED);
        }catch (Throwable e){
            throw new GlobalException(GlobalEnum.UNAUTHORIZED);
        }
    }
}
