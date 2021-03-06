
package com.jeecg.controller.giftbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;




import com.jeecg.entity.giftbook.LoginlogEntity;
import com.jeecg.service.giftbook.LoginlogServiceI;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.Serializable;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;


/**   
 * @Title: Controller
 * @Description: 登录记录
 * @author zhangdaihao
 * @date 2016/11/4 14:07:04
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiLoginlogCtrl")
public class ApiLoginlogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiLoginlogController.class);

	@Autowired
	private LoginlogServiceI loginlogService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(LoginlogEntity loginlog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,dtid,typename,parentid,createDate,createBy,createName,updateDate,updateBy,updateName,");
		CriteriaQuery cq = new CriteriaQuery(LoginlogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, loginlog, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.setCurPage(dataGrid.getPage());
			cq.setPageSize(10);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.loginlogService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 * 删除礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(LoginlogEntity loginlog, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
		{
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		loginlog = systemService.getEntity(LoginlogEntity.class, loginlog.getId());
		message = "礼金类型删除成功";
		try{
			loginlogService.delete(loginlog);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
	    return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 批量删除礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public Object doBatchDel(String ids,HttpServletRequest request,HttpServletResponse response){
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型删除成功";
		try{
			for(String id:ids.split(",")){
				LoginlogEntity loginlog = systemService.getEntity(LoginlogEntity.class, 
						id
						);
				loginlogService.delete(loginlog);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	/**
	 * 添加礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(LoginlogEntity loginlog, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型添加成功";
		try{
		Serializable  obj=	loginlogService.save(loginlog);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			if(obj==null)
				j.setResult(0);
			else
				j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型添加失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 更新礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(LoginlogEntity loginlog, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型更新成功";
		LoginlogEntity t = loginlogService.get(LoginlogEntity.class, loginlog.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(loginlog, t);
			loginlogService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "礼金类型更新失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	


	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object get(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		LoginlogEntity task = loginlogService.get(LoginlogEntity.class, id);
		if (task == null) {
			j.setResult(2);
		}
		else {
			j.setObj(task);
			j.setResult(1);
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object create(@RequestBody LoginlogEntity loginlog, UriComponentsBuilder uriBuilder
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<LoginlogEntity>> failures = validator.validate(loginlog);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		//保存
		try{
			loginlogService.save(loginlog);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = loginlog.getId();

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody LoginlogEntity loginlog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<LoginlogEntity>> failures = validator.validate(loginlog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			loginlogService.saveOrUpdate(loginlog);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(params = "delete",value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") String id
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson json=new AjaxJson();
		try {
			loginlogService.deleteEntityById(LoginlogEntity.class, id);
			json.setResult(1);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(3);
			json.setMsg("删除发生异常！");
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}
}




     





































