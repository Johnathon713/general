package org.john.general.auth.device.exception;

import org.john.general.base.exception.GeneralRuntimeException;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class DeviceException extends GeneralRuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public DeviceException() {
        super();
    }

    public DeviceException(String message) {
        super(message);
    }

    public DeviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceException(Throwable cause) {
        super(cause);
    }

    protected DeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
