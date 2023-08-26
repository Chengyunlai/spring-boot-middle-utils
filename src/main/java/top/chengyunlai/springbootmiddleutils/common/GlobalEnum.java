package top.chengyunlai.springbootmiddleutils.common;

import java.io.Serializable;

public enum GlobalEnum implements Serializable {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    UNAUTHORIZED(401, "未认证（签名错误）"),
    NOT_FOUND(404, "接口不存在"),
    FORBIDDEN(403, "无权限"),
    BAD_REQUEST(400, "参数错误"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求方法"),
    REQUEST_TIME_OUT(406, "请求超时"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private Integer code;
    private String msg;

    GlobalEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static GlobalEnum getEnumByCode(Integer code) {
        for (GlobalEnum globalEnum : GlobalEnum.values()) {
            if (globalEnum.getCode().equals(code)) {
                return globalEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
