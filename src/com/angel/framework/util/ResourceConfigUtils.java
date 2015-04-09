package com.angel.framework.util;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 系统初始化功能
 * 
 * @author wangzy
 * @date 2014-9-24
 */
public class ResourceConfigUtils extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2111784427183023847L;
	/**
	 * 系统properties配置文件
	 */
	private static Properties properties = new Properties();

	static {
		
		try {
			properties.load(ResourceConfigUtils.class.getResourceAsStream("/resource.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		System.out.println("配置文件加载");
			for(Entry<Object, Object>entry:properties.entrySet()){
				getServletContext().setAttribute(entry.getKey().toString(), entry.getValue().toString());
		
		}
		
	}

	@Override
	public void destroy() {
	}

	/**
	 * 获取properties配置信息
	 * 
	 * @param key
	 * @return
	 */
	public static String getProConfig(String key) {
		
		return properties.getProperty(key);
	}

}
