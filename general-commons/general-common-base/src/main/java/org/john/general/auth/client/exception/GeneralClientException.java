package org.john.general.auth.client.exception;

import org.john.general.base.exception.GeneralRuntimeException;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class GeneralClientException extends GeneralRuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public GeneralClientException() {
        super();
    }

    public GeneralClientException(String message) {
        super(message);
    }

    public GeneralClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralClientException(Throwable cause) {
        super(cause);
    }

    protected GeneralClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
