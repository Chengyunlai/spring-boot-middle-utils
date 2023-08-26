package top.chengyunlai.springbootmiddleutils.service;




import org.aspectj.lang.ProceedingJoinPoint;
import top.chengyunlai.springbootmiddleutils.annotation.DoHystrix;

import java.lang.reflect.Method;

/**
 * @author Chengyunlai
 * @description: TODO
 * @date 2023/8/26
 */
public interface IValveService {

    Object access(ProceedingJoinPoint jp, Method method, DoHystrix doHystrix, Object[] args) throws Throwable;
}
