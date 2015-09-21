package com.thor.mdh.api.util;

import java.security.MessageDigest;

public class MD5Util {

	private static final String ALGORITHM = "MD5";
	 
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
 
	/**
	 * encode string
	 * @param algorithm 加密方式  SHA1 MD5
	 * @param str 需要加密字符
	 * @return String
	 */
	public static String encode(String algorithm, String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return toHexString(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
 
	}
 
	/**
	 * MD5加密
	 * @param str 需要加密字符
	 * @return String
	 */
	public static String encodeByMD5(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			messageDigest.update(str.getBytes());
			return toHexString(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
 
	}
	
	/**
	 * 转换成16进制
	 * @param b
	 * @return
	 */
	public static String toHexString(byte[] b) {    
        StringBuilder sb = new StringBuilder(b.length * 2);    
        for (int i = 0; i < b.length; i++) {    
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);    
            sb.append(HEX_DIGITS[b[i] & 0x0f]);    
        }    
        return sb.toString();    
    }    
 
}
