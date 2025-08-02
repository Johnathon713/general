package org.john.general.base;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author llxx
 */
@Data
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private T data;
    private String message;
    private Long consume;

    private String error;
    private String path;
    private String requestId;
    private Long status;
    private Date timestamp;

    private String localizedMessage;
    private Throwable cause;
    private Throwable[] suppressed;
    private StackTraceElement[] stackTrace;
    private Throwable throwable;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setStatus(200L);
        result.setData(data);
        result.setMessage("OK");
        result.setTimestamp(new Date());
        return result;
    }

    public static <T> Result<T> error(long httpStatus, Throwable error) {
        Result<T> result = new Result<>();
        result.setStatus(httpStatus);
        result.setError(error.getMessage());
        result.setLocalizedMessage(error.getLocalizedMessage());
        result.setCause(error.getCause());
        result.setStackTrace(error.getStackTrace());
        result.setSuppressed(error.getSuppressed());
        result.setThrowable(error);
        result.setTimestamp(new Date());
        return result;
    }
}
