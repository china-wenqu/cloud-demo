package com.wenqu.exception;

import com.wenqu.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handlerException(HttpServletRequest request, Exception ex) {
        Result error = new Result();

        // 业务异常
        if (ex instanceof CustomException) {
            error.setCode(((CustomException) ex).getCode());
            error.setMessage(ex.getMessage());
            log.warn("[全局业务异常]\r\n业务编码：{}\r\n异常记录：{}", error.getCode(), error.getMessage());
        }

        // 未知错误
        else {
            error.setCode(CustomStatus.UNKNOWN.getCode());
            error.setMessage(CustomStatus.UNKNOWN.getMessage());
        }

        return new ResponseEntity<>(error, HttpStatus.OK);
    }

}
