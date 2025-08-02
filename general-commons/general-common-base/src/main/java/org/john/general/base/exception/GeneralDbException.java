package org.john.general.base.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class GeneralDbException extends GeneralRuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public GeneralDbException() {
        super();
    }

    public GeneralDbException(String message) {
        super(message);
    }

    public GeneralDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralDbException(Throwable cause) {
        super(cause);
    }

    protected GeneralDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
