package com.abdul.studentcoursemanagement.utils;

/*
Author Name: Abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.utils

Class Name: AESencryption

Date and Time:3/13/2023 2:41 PM

Version:1.0
*/
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AESencryption {

	private SecretKeySpec secretKey;

	private byte[] key;

	private void setKey() {
		MessageDigest sha = null;
		try {
			String myKey = Constants.key;
			key = myKey.getBytes(Constants.charsetName);
			sha = MessageDigest.getInstance(Constants.sha);
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, Constants.algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	public String decrypt(String strToDecrypt) {
		try {
			setKey();
			Cipher cipher = Cipher.getInstance(Constants.padding);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {

		}
		return Constants.unhandleException;
	}
}
