package org.john.general.web.handle;

import lombok.extern.slf4j.Slf4j;
import org.john.general.base.Result;
import org.john.general.base.exception.GeneralRuntimeException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author llxx
 */
@Slf4j
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Order(10000)
    @ExceptionHandler(GeneralRuntimeException.class)
    public ResponseEntity<Result<String>> handleGeneralRuntimeException(GeneralRuntimeException e) {
        log.error("generalRuntimeException", e);
        return new ResponseEntity<>(Result.error(400, "请求有误: " + e.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Result<String>> handleThrowable(Throwable throwable) {
        log.error("throwable", throwable);
        return new ResponseEntity<>(Result.error(500, "系统错误，请稍后再试！\n错误详情: " + throwable.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}