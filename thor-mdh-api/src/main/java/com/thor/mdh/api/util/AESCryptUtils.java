package com.thor.mdh.api.util;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Base64;

public class AESCryptUtils {

	// 算法名
	public static final String KEY_ALGORITHM = "AES";
	// 加解密算法/模式/填充方式
	// 可以任意选择，为了方便后面与iOS端的加密解密，采用与其相同的模式与填充方式
	// ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个参数iv
	public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

	// 生成密钥
	public static byte[] generateKey() throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		keyGenerator.init(128);
		SecretKey key = keyGenerator.generateKey();
		return key.getEncoded();
	}

	// 生成iv
	public static AlgorithmParameters generateIV() throws Exception {
		// iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
		byte[] iv = new byte[16];
		Arrays.fill(iv, (byte) 0x00);
		AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_ALGORITHM);
		params.init(new IvParameterSpec(iv));
		return params;
	}

	// 转化成JAVA的密钥格式
	public static Key convertToKey(byte[] keyBytes) throws Exception {
		SecretKey secretKey = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
		return secretKey;
	}

	// 加密
	public static byte[] encrypt(byte[] data, byte[] keyBytes) throws Exception {
		// 转化为密钥
		Key key = convertToKey(keyBytes);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, key, generateIV());
		return cipher.doFinal(data);
	}

	// 解密
	public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Key key = convertToKey(keyBytes);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, key, generateIV());
		return cipher.doFinal(encryptedData);
	}
	
	public static void main(String[] args) {
		/** 加密键 */
		byte[] AESKey = {0xA, 0xB, 0xC, 0, 1, 2, 3, 0xD, 0xE, 0xF, 4, 5, 6, 7, 8, 9};
		System.out.println("加密开始时间:" + new Date().getTime());
		String data = "10000";
		System.out.println("加密前:" + data);
		try {
			// 进行加密
			byte[] encryptedData = AESCryptUtils.encrypt(data.getBytes(), AESKey);
			String encry = Base64.toBase64String(encryptedData);
			System.out.println("加密后:" + encry);
			
			// 进行解密
			byte[] decodedData = Base64.decode(encry);
			String decode = new String(AESCryptUtils.decrypt(decodedData, AESKey));
			System.out.println("解密后:" + decode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("解密结束时间:" + new Date().getTime());
	}
}
