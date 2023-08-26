package top.chengyunlai.springbootmiddleutils.common;

import lombok.Data;

/**
 * @author Chengyunlai
 * @description: TODO
 * @date 2023/8/2
 */
public class BaseException extends Exception{
    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public BaseException(GlobalEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMsg();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}