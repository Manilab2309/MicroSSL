/**
 * CUSTOM AUTHENTICATION API MICROSERVICE
 */
package com.msc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.msc.config.MicroCoreSecurityConfiguration;
import com.msc.exceptions.MicroCoreSecurityException;
import com.msc.util.MicroCoreConstants;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(com.msc.security.CustomAuthenticationProvider.class);

	@Autowired
	MicroCoreSecurityConfiguration microcoreSecurityConfiguration;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		try {
			logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "Checking credentials for Springboot Security...");

			/** Web User Credentials to Login */
			String name = authentication.getName();
			String pass = authentication.getCredentials().toString();

			/** Valid Credentials for Springboot Security */
			String userAPIAllowed = microcoreSecurityConfiguration.getUserAPIAllowed();
			String passAPIAllowed = microcoreSecurityConfiguration.getPassAPIAllowed();

			com.msc.security.DataEncrypter dataCipher = new com.msc.security.DataEncrypter(microcoreSecurityConfiguration);
			String passClientDecrypted = dataCipher.extractSalt(dataCipher.decrypt(pass));
			String passAPIServerDecrypted = dataCipher.extractSalt(dataCipher.decrypt(passAPIAllowed));

			if (name.equalsIgnoreCase(userAPIAllowed) && passClientDecrypted.equalsIgnoreCase(passAPIServerDecrypted)) {
				logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
						+ "Login successfully, retrieving API services...");

				Authentication authResult = new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
				SecurityContextHolder.getContext().setAuthentication(authResult);
				return authResult;
			} else {
				throw new BadCredentialsException(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
						+ MicroCoreConstants.MsgExceptions.MSG_ERROR_BAD_CREDENTIALS);
			}
		} catch (MicroCoreSecurityException e) {
			logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "Error in encrypting module");			
				throw new MicroCoreSecurityException(MicroCoreConstants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
