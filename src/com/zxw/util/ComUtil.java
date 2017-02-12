package com.zxw.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class ComUtil {
	public static String getParam(HttpServletRequest request,String paramName)
	{
		Object obj=null;
		obj=request.getAttribute(paramName);
		if(obj==null)
			obj=request.getParameter(paramName);
		if(obj==null)
			return "";
		return obj.toString();
	}
	
	public static String getUUID32()
	{
		
		 String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象  
	        uuid = uuid.replace("-", "");     
	        return uuid;
	}
}
