/**
 * DATA CYPHER SERVICE
 */
package com.msc.security;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.msc.config.MicroCoreSecurityConfiguration;
import com.msc.exceptions.MicroCoreSecurityException;
import com.msc.util.MicroCoreConstants;

/**
 * @author Ramón Cigüenza Fuster
 *
 */

public class DataEncrypter {

	@Autowired
	MicroCoreSecurityConfiguration microcoreSecurityConfiguration;

	public DataEncrypter(MicroCoreSecurityConfiguration microcoreSecurityConfiguration) {
		this.microcoreSecurityConfiguration = microcoreSecurityConfiguration;
	}

	public String encrypt(String value) throws MicroCoreSecurityException {

		try {

			MicroCoreSecurityConfiguration config = new MicroCoreSecurityConfiguration();
			System.out.println(config.getKey());

			IvParameterSpec iv = new IvParameterSpec(microcoreSecurityConfiguration.getInitVector().getBytes("UTF-8"));

			SecretKeySpec skeySpec = new SecretKeySpec(microcoreSecurityConfiguration.getKey().getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));

			return Base64.encodeBase64String(encrypted);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new MicroCoreSecurityException(MicroCoreConstants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}

	}

	public String decrypt(String encrypted) throws MicroCoreSecurityException {
		try {

			IvParameterSpec iv = new IvParameterSpec(microcoreSecurityConfiguration.getInitVector().getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(microcoreSecurityConfiguration.getKey().getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new MicroCoreSecurityException(MicroCoreConstants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}

	}
	
	public String extractSalt(String brutePass) {
		
		brutePass = brutePass.substring(microcoreSecurityConfiguration.getSaltpre().length(), brutePass.length() - microcoreSecurityConfiguration.getSaltpost().length());
		
		return brutePass;
	}

}
