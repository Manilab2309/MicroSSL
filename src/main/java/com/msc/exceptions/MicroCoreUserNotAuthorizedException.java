/**
 * AUTHENTICATION USER EXCEPTION
 */
package com.msc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramón Cigüenza
 *
 */

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="User Not Authorized")  // 404
public class MicroCoreUserNotAuthorizedException extends RuntimeException{
	
	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "User Not Authorized";

	public MicroCoreUserNotAuthorizedException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public MicroCoreUserNotAuthorizedException(String message) {
        super(message);
        
    }

    public MicroCoreUserNotAuthorizedException(Throwable cause) {
        super(cause);
        
    }

    public MicroCoreUserNotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
        
    }
	
	
}
