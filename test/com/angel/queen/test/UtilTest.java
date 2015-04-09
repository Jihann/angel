package com.angel.queen.test;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.angel.framework.util.DateUtil;
import com.angel.framework.util.JsonUtils;
import com.angel.framework.util.MD5Utils;
import com.angel.framework.util.ResourceConfigUtils;
import com.angel.queen.model.ConUsers;
import com.google.gson.Gson;

/**
 * 工具方法测试类
 * @author JBH
 * @version 2015-01-30
 * @since JDK1.6
 */
public class UtilTest {

	private static Logger logger = Logger.getLogger(UtilTest.class);
	
	@Test
	public void testProperties(){
		
		logger.info("------------------test----------------");
		
		String url = ResourceConfigUtils.getProConfig("test.url");
		
		Assert.assertEquals("welcom", url);
	}
	
	@Test
	public void testJson(){
		
		ConUsers user = new ConUsers();
		user.setUserName("admin");
		user.setPassword("123456");
		
		String json1 = JsonUtils.object2json(user);
		String json2 = JsonUtils.bean2json(user);
		
		System.out.println(json1);
		System.out.println(json2);
		
		System.out.println(json1.equals(json2));
	}
	
	@Test
	public void testDate(){
		
		String date = DateUtil.date2String(new Date(), "yyyy-MM-dd");
		System.out.println(date);
	}
	
	@Test
	public void testMD5(){
		
		try {
			String md5 = MD5Utils.base64Encode("123456");
			String mdd = MD5Utils.MD5("123456".getBytes("UTF-8"));
			System.out.println(mdd);
			String md = MD5Utils.toMd5Hash("123456");
			System.out.println(md);
			String str = MD5Utils.base64Decode(md5);
			System.out.println(md5);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGson(){
		
		ConUsers user = new ConUsers();
		user.setUserName("admin");
		user.setPassword("123456");
		
		Gson gson = new Gson();
		//简单bean转JSON
		String json1 = gson.toJson(user);
		System.out.println(json1);
		
		//将JSON转换为bean
		ConUsers conUsers = gson.fromJson(json1, ConUsers.class);
		System.out.println(conUsers.getUserName());
	}
	
	@Test
	public void testISNull(){
		
		logger.info("----------------------------------------------------");
		String str = "\"null\"";
		if(str != null && !"".equals(str) && !"\"null\"".equals(str)){
			System.out.println("-------------");
		}else{
			System.out.println("aaaaaaaaaaaaaaaa");
		}
	}
}
