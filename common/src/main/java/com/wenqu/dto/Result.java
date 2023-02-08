package com.wenqu.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用数据传输对象
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

    /**
     * 构造方法
     */
    public Result() {
        super();
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("success");
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setMessage("error");
        return result;
    }

    public Result data(T data) {
        this.setData(data);
        return this;
    }

    public Result(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 通用状态码
     */
    public interface ResultCode {
        //通用成功
        public static Integer SUCCESS = 200;
        //通用失败
        public static Integer ERROR = 400;
        // 未认证（签名错误）
        public static Integer UNAUTHORIZED = 401;
        //没有权限访问
        public static Integer FORBIDDEN = 403;
        // 接口不存在
        public static Integer NOT_FOUND = 404;
        // 服务器内部错误
        public static Integer INTERNAL_SERVER_ERROR = 500;
    }


}
