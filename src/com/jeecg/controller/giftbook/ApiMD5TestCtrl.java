package com.jeecg.controller.giftbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jeecgframework.core.util.base64.Base64Utils;
import org.jeecgframework.core.util.base64.HandlerRSAUtils;
import org.jeecgframework.core.util.base64.RSAEncrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping("/apiMD5TestCtrl")
public class ApiMD5TestCtrl {
	public static  String priKey;
	public static  String publicKey;
	static{
		try {
			Properties pro = new Properties();
			InputStream is= ApiMD5TestCtrl.class.getClassLoader().getResourceAsStream("key.properties");
			//FileInputStream in = new FileInputStream("key.properties");
			pro.load(is);
			priKey=pro.get("privateKey").toString();
			publicKey=pro.get("publicKey").toString();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(params = "encode")
	@ResponseBody
	public String encode(String str) throws Exception
	{
		return HandlerRSAUtils.encode(str);
	}
	
	@RequestMapping(params = "decryption")
	@ResponseBody
	public String decryption(String str) throws Exception
	{
		String str2="RxZ697JahUYff2UhI7KM6qgMKDqwFnkYEJWV27Kh5ZynHH0mgxnH7Bx+hPeIV/r20SVZ4A13tJJv\r\n5dG3VGwmeYDkYEgSxpJ/L1HBXT/GuaRXeBFRXqiwwEWReNVdr1J3vcpek43MFxb7yj3D6Xwxjbdc\r\nJWeKIZ1Y08iHvlstQAY=";
		if(str2.length()==str.length())
		{
			str2="1";
		}
		String str3=HandlerRSAUtils.decryption(str);
		
		return str3;
	}
	
	@RequestMapping(params = "encodeLogin")
	@ResponseBody
	public String encodeLogin(String str) throws Exception
	{
		return HandlerRSAUtils.encodeLogin(str);
	}
	
	
	@RequestMapping(params = "decryptionLogin")
	@ResponseBody
	public String decryptionLogin(String str) throws Exception
	{
		return HandlerRSAUtils.decryptionLogin(str);
	}
	
	
	
	public static void main(String[] args) {
		try {
			String strsss="{\"loginname\":\"a111\",\"loginpassword\":\"MTEx\",\"timestamp\":\"1486878409265\",\"decvices\":\"3EAF6F88E5CBC7C0E92848337263EF1E\"}";
		String str=	HandlerRSAUtils.encode(strsss);
			   str=	HandlerRSAUtils.decryption(
"PD9pOlV3LkY2tr9N3f0v5Q/3HRv4gIHAoDZ3EFrIXoxHXVGZ/GYq/pzegVElPRhE4/k+/YUsS1di\nnC4pRGdI2cPlmTUWn8QonMLfBGq1v1C2piKpvbU8rDnYmcqvJWwMryRoR9vkvJPDh3DaoxZzVBby\nOx+SkXkEw2Z+FFkkfiw="
					   );
	        System.out.println(str);  
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
