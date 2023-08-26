package top.chengyunlai.springbootmiddleutils.common;

/**
 * @author Chengyunlai
 * @description: TODO
 * @date 2023/8/2
 */
public class GlobalException extends BaseException{
    public GlobalException(GlobalEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
