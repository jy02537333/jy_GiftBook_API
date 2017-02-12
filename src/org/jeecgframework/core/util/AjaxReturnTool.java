package org.jeecgframework.core.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.entity.AjaxJson;

import com.alibaba.fastjson.JSONObject;

public class AjaxReturnTool {

	public static AjaxJson hanlderPage(DataGrid dataGrid)
	{
		AjaxJson ajaxJson=new AjaxJson();
		int result = 0;
		String msg="";
		@SuppressWarnings("rawtypes")
		List varList=null;
		try{
			if(dataGrid.getTotal()>0)
			{
				varList=dataGrid.getResults();
				result=1;
			}else {
				result=2;   
			}
			msg="请求成功！";
		}catch (Exception e){
			result =3;
			msg="请求异常！";
		}finally{
			ajaxJson.setResult(result);
			ajaxJson.setObj(varList);
			ajaxJson.setMsg(msg);
		}
		return ajaxJson;
	}
	
	public static AjaxJson emptyKey()
	{
		AjaxJson ajaxJson=new AjaxJson();
		ajaxJson.setResult(5);
		ajaxJson.setMsg("未获取到key");
		return ajaxJson;
	}
	
	/**
	 * 处理jsonp请求，如果没有jsonp请求正常返回
	 * @param pd
	 * @param ajaxJson
	 * @return
	 */
	public static Object retJsonp(AjaxJson ajaxJson,HttpServletRequest request)
	{
	 Object callback=	request.getParameter("callback");
	 if(ajaxJson.getData()==null)
	 {
		 ajaxJson.setObj("");
	 }
		if(callback==null)	
		{
			
			return ajaxJson;
		}else {
			 JSONObject obj = new JSONObject();
				obj.put("result", ajaxJson.getResult());
				obj.put("msg", ajaxJson.getMsg());
				obj.put("data", ajaxJson.getData());
			return callback+"("+obj.toJSONString()+")";
		}
	}
}
