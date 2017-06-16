package com.jeecg.controller.giftbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.zxw.util.ComUtil;

@Controller
@RequestMapping("/apiSmsSendCtrl")
public class SmsSendCtrl extends BaseController {
	public static Map<String ,String > codeMap=new HashMap<>();
   public static String appKey="23526742";
   public static String secret="1753883b8ed9ac1f8403b1e854e61010";
   public static String signStr="礼薄";
   /**
    * 验证码
    */
   public static String registerMode="SMS_35765027";
   /**
    * 发送邀请
    */
   public static String sendInvitationId="SMS_49255107";
   /**
    *  发送验证码
    * @param request
    * @param response
    * @return
    */
	@RequestMapping(params = "sendSmsCode")
	@ResponseBody
	public Object sendSmsCode(HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		try {
			
			int code= sendCode(ComUtil.getParam(request, "phone"));
			if(code>0)
			{
				String uuid=	ComUtil.getUUID32();
				request.getSession().setAttribute("code_s", uuid);
				j.setObj(uuid);
				j.setResult(1);
			}else
			{
				j.setResult(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}
	/**
	 * 发送邀请
	 * @param phone
	 * @param invitationName
	 * @return
	 */
	public int sendInvitationInfo(String phone,String invitationName,String invitationId)
	{
		
		try {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appKey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("register");
		req.setSmsType("normal");
		req.setSmsFreeSignName(signStr);
		int code=getCode();
		req.setSmsParamString("{\"send_name\":\""+invitationName+"\",\"invitation_id\":\""+invitationId+"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode(sendInvitationId);
		AlibabaAliqinFcSmsNumSendResponse rsp;
			rsp = client.execute(req);
			if(rsp.getErrorCode()==null||rsp.getErrorCode().equals("0"))
			{
				return code ;
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	public int sendCode(String phone)
	{
		try {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appKey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("register");
		req.setSmsType("normal");
		req.setSmsFreeSignName(signStr);
		int code=getCode();
		req.setSmsParamString("{\"gift_code\":\""+code+"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode(registerMode);
		AlibabaAliqinFcSmsNumSendResponse rsp;
			rsp = client.execute(req);
			if(rsp.getErrorCode()==null||rsp.getErrorCode().equals("0"))
			{
				codeMap.put(phone,code+"");
				return code ;
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	public int getCode()
	{
		int max=999999;
		int min=101011;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
		return s;
	}

	@RequestMapping(params = "sendInvitation")
	@ResponseBody
	public Object sendInvitation(HttpServletRequest request,
			HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();

		try {
			int code= sendCode(ComUtil.getParam(request, "phone"));
			if(code>0)
			{
				String uuid=	ComUtil.getUUID32();
				request.getSession().setAttribute("code_s", uuid);
				j.setObj(uuid);
				j.setResult(1);
			}else
			{
				j.setResult(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}
	public static void main(String[] args) {
		SmsSendCtrl s=new SmsSendCtrl();
		s.sendCode("18985121575");
		System.out.println(s.getCode());
	}
}
