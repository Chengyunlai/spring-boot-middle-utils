package top.chengyunlai.springbootmiddleutils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import top.chengyunlai.springbootmiddleutils.annotation.DoHystrix;
import top.chengyunlai.springbootmiddleutils.service.IValveService;
import top.chengyunlai.springbootmiddleutils.service.impl.HystrixValveImpl;

import java.lang.reflect.Method;

/**
 * @author Chengyunlai
 * @description: TODO
 * @date 2023/8/26
 */
@Aspect
@Component
public class DoHystrixPointAOP {

    @Pointcut("@annotation(top.chengyunlai.springbootmiddleutils.annotation.DoHystrix)")
    public void aopPoint() {
    }

    @Around("aopPoint() && @annotation(doGovern)")
    public Object doRouter(ProceedingJoinPoint jp, DoHystrix doGovern) throws Throwable {
        IValveService valveService = new HystrixValveImpl();
        return valveService.access(jp, getMethod(jp), doGovern, jp.getArgs());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

}