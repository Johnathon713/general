package org.john.general.auth.user.exception;

import org.john.general.base.exception.GeneralRuntimeException;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class UserException extends GeneralRuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
