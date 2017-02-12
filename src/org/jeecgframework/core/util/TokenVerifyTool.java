package org.jeecgframework.core.util;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.util.base64.HandlerRSAUtils;

import com.google.common.reflect.TypeToken;
import com.jeecg.entity.giftbook.LoginlogEntity;
import com.jeecg.entity.giftbook.SysUserEntity;
import com.jeecg.service.giftbook.LoginlogServiceI;
/**
 * 
 * @ClassName: TokenVerifyTool 
 * @Description: token验证
 * @author 张相伟 
 * @date 2016年11月4日 上午9:53:26
 */
public class TokenVerifyTool {
	public static  Boolean verify(HttpServletRequest request)
	{
		if(request==null||
				//request.getAttribute("token")==null||
				request.getParameter("token")==null)
		{
			
			return true;
		}
		String token=request.getParameter("token");
		if(token==null||token.trim().length()==0)
		{
			return true;
		}
		LoginlogServiceI loginlogServiceI=(LoginlogServiceI)
				ApplicationContextUtil.getContext().getBean("loginlogService");
		try {
			
			String entityJson =HandlerRSAUtils.decryption(token);
			@SuppressWarnings("serial")
			Type type=new TypeToken<SysUserEntity>(){}.getType();
			//Gson gson=new Gson(); 
			SysUserEntity user=//gson.fromJson(entityJson, type); 
			JSONHelper.fromJsonToObject(entityJson, SysUserEntity.class);
			if(user!=null&&user.getLoginname()!=null)
			{ 
				LoginlogEntity loginlogEntity=
						loginlogServiceI.findUniqueByProperty(
								LoginlogEntity.class, "userid",user.getId());
				if(loginlogEntity==null||
						loginlogEntity.getLogintoken()==null)
				{
					return true;
				}
				String token2=loginlogEntity.getLogintoken().trim().substring(0,30);
				token=token.trim().substring(0,30);
				if(token2.equals(token))
				{
					return false;
				}else
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace(); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static  SysUserEntity verifyLoginInfo(String info)
	{
		SysUserEntity sysUserEntity=null;
		if(info==null||info.length()<10)
		{
			return sysUserEntity;
		}
		try {
			String entity=HandlerRSAUtils.decryptionLogin(info);
			SysUserEntity user=	JSONHelper.fromJsonToObject(entity, SysUserEntity.class);
			if(user!=null&&user.getLoginname()!=null)
			{
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysUserEntity;
	}
	public static void main(String[] args) {
		String str="3GapWQXinMjm+dTQ1LHaxTp9LT0+zmDwDZrW+V0oA+I0edpRedlGAvcJomv2hwB/1Iapu+O5kVKZ2MUUbLxz/2xAJG/3GCaimMAPkJDcsNNsQCRv9xgmonYTJoQATmS0zFBbSnISJ9NTQ55ZUtnmn8KNCqg95E+KIXhMWjHoKr3pSDTZMdlyRHd9DnEObV/VeJtJ86ZcjvloT0zNeHuZI51muEFbDzbDWgDcC1193HMWbK9KuzeTxg==";
		String str2="3GapWQXinMjm+dTQ1LHaxTp9LT0+zmDwDZrW+V0oA+I0edpRedlGAvcJomv2hwB/1Iapu+O5kVKZ2MUUbLxz/2xAJG/3GCaimMAPkJDcsNNsQCRv9xgmonYTJoQATmS0zFBbSnISJ9NTQ55ZUtnmn8KNCqg95E+KIXhMWjHoKr3pSDTZMdlyRHd9DnEObV/VeJtJ86ZcjvloT0zNeHuZI51muEFbDzbDWgDcC1193HMWbK9KuzeTxg==";
		if(!str.equals(str2))
		{
			System.out.println("1");
		}else
		System.out.println("2");
	}
}

