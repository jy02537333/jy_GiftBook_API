package org.jeecgframework.core.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * api请求后返回的格式
 * 
 * @author
 * 
 */
public class AjaxJson {
	public static final String VARLIST="varList";
	/**返回值状态说明
	 * 相关参数协议：result: 0	请求失败 ; 1	请求成功; 2	返回空值; 3	请求协议参数不完整  ; 4  用户名或密码错误; 5  FKEY验证失败
	*/
	private int result=2;
	private String apiname;
	private Object data;
	private String msg = "操作成功";// 提示信息
	/**api调用，页面返回调用方法*/
	private String callback="";
	
	/**
	 * /相关参数协议：result: 0	请求失败 ; 1	请求成功; 2	返回空值; 3	请求协议参数不完整  ; 4  用户名或密码错误; 5  FKEY验证失败
	 * @return
	 */
	public int getResult() {
		return result;
	}
	/**
	 * /相关参数协议：result: 0	请求失败 ; 1	请求成功; 2	返回空值; 3	请求协议参数不完整  ; 4  用户名或密码错误; 5  TOken验证失败
	 * @return
	 */
	public void setResult(int result) {
		this.result = result;
	}
	public String getApiname() {
		return apiname;
	}
	public void setApiname(String apiname) {
		this.apiname = apiname;
	}
	public void setVarList(List varList) {
		data= varList;
	}
	public Object getData() {
		return data;
	}
	public void setMap(Map map) {
		this.data = map;
	}
	
	public void setObj(Object object) {
		this.data = object;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
//	public String getJsonStr(){
//		JSONObject obj = new JSONObject();
//		obj.put("result", result);
//		obj.put("apiname", apiname);
//		obj.put("msg", msg);
//		obj.put("varList", varList);
//		obj.put("callback", callback);
//		return obj.toJSONString();
//	}
}
