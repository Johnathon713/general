package org.john.general.base.exception;

import java.io.Serial;

/**
 * @author llxx
 */
public class GeneralRuntimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public GeneralRuntimeException() {
        super();
    }

    public GeneralRuntimeException(String message) {
        super(message);
    }

    public GeneralRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralRuntimeException(Throwable cause) {
        super(cause);
    }

    protected GeneralRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
