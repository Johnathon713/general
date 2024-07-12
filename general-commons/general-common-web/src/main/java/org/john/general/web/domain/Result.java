package org.john.general.web.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnathon
 */
@Data
public class Result<T> implements Serializable {
    private Long status;
    private T data;
    private String message;
    private String error;
    private Long requestId;
    private Date timestamp;
    private Long consume;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setStatus(200L);
        result.setData(data);
        result.setMessage("OK");
        result.setTimestamp(new Date());
        return result;
    }

    public static <T> Result<T> error(long httpStatus, String error) {
        Result<T> result = new Result<>();
        result.setStatus(httpStatus);
        result.setError(error);
        result.setTimestamp(new Date());
        return result;
    }
}
