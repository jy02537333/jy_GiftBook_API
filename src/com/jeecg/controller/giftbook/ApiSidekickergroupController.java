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

import com.jeecg.entity.giftbook.SidekickergroupEntity;
import com.jeecg.service.giftbook.SidekickergroupServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.Serializable;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Title: Controller
 * @Description: 亲友团
 * @author zhangdaihao
 * @date 2016/11/4 14:21:24
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/apiSidekickergroupCtrl")
public class ApiSidekickergroupController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ApiSidekickergroupController.class);

	@Autowired
	private SidekickergroupServiceI sidekickergroupService;
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
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(SidekickergroupEntity sidekickergroup,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,userid,groupmembersnum,groupname,state,createDate,createBy,createName,updateDate,updateBy,updateName");
		CriteriaQuery cq = new CriteriaQuery(SidekickergroupEntity.class,
				dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				sidekickergroup, request.getParameterMap());
		try {
			// 自定义追加查询条件
			cq.eq("userid", request.getParameter("userid"));
			cq.eq("isDefault", request.getParameter("1"));
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sidekickergroupService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(AjaxReturnTool.hanlderPage(dataGrid),
				request);
	}

	/**
	 * 删除亲友团
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(SidekickergroupEntity sidekickergroup,
			HttpServletRequest request) {
		if (TokenVerifyTool.verify(request)) {
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		sidekickergroup = systemService.getEntity(SidekickergroupEntity.class,
				sidekickergroup.getId());
		message = "亲友团删除成功";
		try {
			sidekickergroupService.delete(sidekickergroup);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "亲友团删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request);
	}

	/**
	 * 批量删除亲友团
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public Object doBatchDel(String ids, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团删除成功";
		try {
			for (String id : ids.split(",")) {
				SidekickergroupEntity sidekickergroup = systemService
						.getEntity(SidekickergroupEntity.class, id);
				sidekickergroupService.delete(sidekickergroup);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "亲友团删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request);
	}

	/**
	 * 添加亲友团
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(SidekickergroupEntity sidekickergroup,
			HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		sidekickergroup.setCreateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团添加成功";
		try {
			Serializable obj = sidekickergroupService.save(sidekickergroup);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
			if (obj == null)
				j.setResult(0);
			else {
				j.setResult(1);
				j.setObj(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "亲友团添加失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request);
	}

	/**
	 * 更新亲友团
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(SidekickergroupEntity sidekickergroup,
			HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		sidekickergroup.setCreateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团更新成功";
		SidekickergroupEntity t = sidekickergroupService.get(
				SidekickergroupEntity.class, sidekickergroup.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sidekickergroup, t);
			sidekickergroupService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "亲友团更新失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object get(@PathVariable("id") String id, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();
		SidekickergroupEntity task = sidekickergroupService.get(
				SidekickergroupEntity.class, id);
		if (task == null) {
			j.setResult(2);
		} else {
			j.setObj(task);
			j.setResult(1);
		}
		return AjaxReturnTool.retJsonp(j, request);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object create(@RequestBody SidekickergroupEntity sidekickergroup,
			UriComponentsBuilder uriBuilder, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SidekickergroupEntity>> failures = validator
				.validate(sidekickergroup);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		// 保存
		try {
			sidekickergroupService.save(sidekickergroup);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = sidekickergroup.getId();

		return AjaxReturnTool.retJsonp(j, request);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(
			@RequestBody SidekickergroupEntity sidekickergroup) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SidekickergroupEntity>> failures = validator
				.validate(sidekickergroup);
		if (!failures.isEmpty()) {
			return new ResponseEntity(
					BeanValidators.extractPropertyAndMessage(failures),
					HttpStatus.BAD_REQUEST);
		}

		// 保存
		try {
			sidekickergroupService.saveOrUpdate(sidekickergroup);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(params = "delete", value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") String id,
			HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson json = new AjaxJson();
		try {
			sidekickergroupService.deleteEntityById(
					SidekickergroupEntity.class, id);
			json.setResult(1);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(3);
			json.setMsg("删除发生异常！");
		}
		return AjaxReturnTool.retJsonp(json, request);
	}
}
