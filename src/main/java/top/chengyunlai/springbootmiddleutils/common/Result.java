package top.chengyunlai.springbootmiddleutils.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName
 * @Description 统一返回结果
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static Result succ(int code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(int code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static Result succ(String msg,Object data){
        return succ(200,msg,data);
    }

    public static Result succ(String msg){
        return succ(200,msg,null);
    }

    public static Result fail(String msg,Object data){
        return fail(400,msg,data);
    }

    public static Result fail(String msg){
        return fail(400,msg,null);
    }
}
