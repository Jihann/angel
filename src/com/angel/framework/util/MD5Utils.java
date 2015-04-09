package com.angel.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class MD5Utils {

	
	public static String encrypt(String org)
	{
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
	        md.update(org.getBytes());//update处理  
	        byte [] encrypted = md.digest();//调用该方法完成计算 
	        return ByteUtils.Byte2Hex(encrypted);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return null;
	}
	
	/**
	 * MD5加密
	 * @param source
	 * @return
	 */
	public static String MD5(byte[] source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result.toLowerCase();
   }
	
	/**
	 * MD5加密方法
	 * 
	 * @param original
	 *            输入明文
	 * @return 输出密文
	 */
	public static String toMd5(String original) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = original.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * MD5加密方法
	 * 
	 * @param original
	 *            输入明文
	 * @return 输出Hash密文
	 */
	public static String toMd5Hash(String original) {
		if (original == null) {
			return null;
		}
		try {
			byte[] strTemp = original.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			return "{MD5}" + new sun.misc.BASE64Encoder().encode(mdTemp.digest(strTemp));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * base64解密
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Base64DecodingException
	 */
	public static String base64Decode(String key) throws UnsupportedEncodingException, Base64DecodingException{
		return new String(Base64.decode(key), "UTF-8");
	}
	
	/**
	 * base64加密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Encode(String str) throws UnsupportedEncodingException{
		String a = Base64.encode(str.getBytes("UTF-8"));
		return a;
	}
}
