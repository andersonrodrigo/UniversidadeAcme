package com.puc.acme.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Helper para criptografia usando MessageDigester. Digere o objeto e retorna o
 * resultado em string hexadecimal.
 * 
 * @author Roberto Badar�
 * @version $Id: DigesterHelper.java 3493 2007-04-20 20:41:59Z roberto $
 */
public class DigesterHelper {

	/**
	 * 
	 * @param algoritimo
	 * @param objeto
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String digest(String algoritimo, String objeto) throws NoSuchAlgorithmException {

		return digest(algoritimo, objeto.getBytes());
	}

	/**
	 * 
	 * @param algoritimo
	 * @param objeto
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String digest(String algoritimo, byte[] objeto) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance(algoritimo);
		byte[] b = md.digest(objeto);

		return HexUtils.convert(b);
	}

}
