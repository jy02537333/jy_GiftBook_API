package com.jeecg.controller.giftbook;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.common.Zone;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zxw.util.Config;
import com.zxw.util.QiNiuAuthUtil;

@Controller
@RequestMapping("/apiQiNiuUptokenCtrl")
public class ApiQiNiuUptokenCtrl  extends BaseController {
	
	
	@RequestMapping(params = "uptoken",method= RequestMethod.GET)
	@ResponseBody
	public String makeToken(HttpServletRequest request,HttpServletResponse response) {  
		response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错 
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1. 
		response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0"); 
		
		QiNiuAuthUtil auth=QiNiuAuthUtil.create(Config.QINIU_ACCESS_KEY, Config.QINIU_SECRET_KEY);
		String token=auth.uploadToken("libubucket");
		//String token = auth.uploadToken("libudata", null, 7200, new StringMap()
        //.putNotEmpty("saveKey", "nimei.jpg"), true);
		
		if(token!=null)
		{
			return token;
		}else 
		return null;
	}
	@RequestMapping(params = "uptokenMobile",method= RequestMethod.GET)
	@ResponseBody
	public Object makeMobileToken(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");

		QiNiuAuthUtil auth=QiNiuAuthUtil.create(Config.QINIU_ACCESS_KEY, Config.QINIU_SECRET_KEY);
		String token=auth.uploadToken("libubucket");
		//String token = auth.uploadToken("libudata", null, 7200, new StringMap()
		//.putNotEmpty("saveKey", "nimei.jpg"), true);
		AjaxJson j = new AjaxJson();

		if(token!=null)
		{
			j.setResult(1);
			j.setObj(token);
			j.setMsg("获取token成功！");
		}else
		{
			j.setResult(3);
			j.setObj("");
			j.setMsg("获取token失败！");
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}
}
