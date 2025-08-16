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

    private String error;
    private String path;
    private String requestId;
    private Long status;
    private Date timestamp;
    private Throwable throwable;

    private T data;
    private String message;


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
        result.setThrowable(error);
        result.setTimestamp(new Date());
        return result;
    }
}
