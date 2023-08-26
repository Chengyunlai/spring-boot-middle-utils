package top.chengyunlai.springbootmiddleutils.annotation;

import java.lang.annotation.*;


/**
 * @author Chengyunlai
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserAuth {

    /**
     * 白名单用户
     */
    String permission() default "";
}
