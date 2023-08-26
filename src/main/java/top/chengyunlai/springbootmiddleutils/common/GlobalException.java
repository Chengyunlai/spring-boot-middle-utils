package top.chengyunlai.springbootmiddleutils.common;

/**
 * @author Chengyunlai
 * @description: 全局异常
 * @date 2023/8/2
 */
public class GlobalException extends BaseException{
    public GlobalException(GlobalEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
