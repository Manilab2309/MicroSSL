/**
 * NO DATA EXCEPTION
 */
package com.msc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramón Cigüenza
 *
 */

@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="Not Available Data")  // 204
public class MicroCoreNoDataException extends RuntimeException {

	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "Not Found Data Content";

	public MicroCoreNoDataException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public MicroCoreNoDataException(String message) {
        super(message);
        
    }

    public MicroCoreNoDataException(Throwable cause) {
        super(cause);
        
    }

    public MicroCoreNoDataException(String message, Throwable cause) {
        super(message, cause);
        
    }
}
