package org.john.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnathon
 */
@Data
public class Result<T> implements Serializable {
    private Date timestamp;
    private String path;
    private Long status;
    private String message;
    private String error;
    private Long requestId;
    private T data;

    public static <T> Result<T> error(long httpStatus, String error) {
        Result<T> result = new Result<>();
        result.setTimestamp(new Date());
        result.setStatus(httpStatus);
        result.setError(error);
        result.setRequestId(2L);
        return result;
    }

}
