/**
 * MESSAGE CLASS UTILITY
 */
package com.msc.util;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class MicroCoreConstants {
	
	/**  MicroCoreConstants utilities	*/
	
	/** Empty string	*/
	public static final String EMPTY = "";
	
	/** Space string	*/
	public static final String SPACE = " ";
	
	public class MsgExceptions {
		
		/** Not Allowed User	*/
		public static final String MSG_ERROR_USER_NOT_AUTHORIZED = "User not authorized";
		
		/** Encrypt Module Error	*/
		public static final String MSG_ERROR_ENCRYPT_MODULE = "Encrypt module error";
		
		/** Bad Credentials	*/
		public static final String MSG_ERROR_BAD_CREDENTIALS = "Credentials error";
		
	}
	
	public class MsgDebugOperations {
		
		/** Debug Message User Not Authorized	*/
		public static final String DEBUG_PREFIX_MSG_DEBUG = "[MicroCore] - ";
		
		/** Debug Message User Not Authorized	*/
		public static final String DEBUG_MSG_ERROR_USER_NOT_AUTHORIZED = "User not authorized";
		
		/** No Data Contents Found	*/
		public static final String DEBUG_MSG_ERROR_NOT_DATA_FOUND = "Not data found in registry";
		
	}
	
	public class ModelFields {
		
		/** Field identification from citizen collection	*/
		public static final String FIELD_DTO_IDENTIFICATION = "ident";
		
		/** Field name from citizen collection	*/
		public static final String FIELD_DTO_NAME = "name";

	}

}
