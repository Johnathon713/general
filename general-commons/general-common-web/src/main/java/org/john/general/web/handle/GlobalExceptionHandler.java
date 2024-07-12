package org.john.general.web.handle;

import lombok.extern.slf4j.Slf4j;
import org.john.general.exception.BaseException;
import org.john.general.web.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Johnathon
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public Result<String> handleBaseException(BaseException e) {
        log.error("baseException", e);
        return Result.error(400, "请求有误: " + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Result<String> handleThrowable(Throwable throwable) {
        log.error("baseException", throwable);
        return Result.error(400, "系统错误，请稍后再试！\n错误详情: " + throwable.getMessage());
    }
}