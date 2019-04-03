/**
 * SECURITY EXCEPTION
 */
package com.msc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramón Cigüenza
 *
 */

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Security Error")  // 500
public class MicroCoreSecurityException extends RuntimeException{

	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "Encrypt Module Error";

	public MicroCoreSecurityException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public MicroCoreSecurityException(String message) {
        super(message);
        
    }

    public MicroCoreSecurityException(Throwable cause) {
        super(cause);
        
    }

    public MicroCoreSecurityException(String message, Throwable cause) {
        super(message, cause);
        
    }
	
}
