package com.wenqu.exception;


public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 3034121940056795549L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomException() {

    }

    public CustomException(CustomStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }
}
