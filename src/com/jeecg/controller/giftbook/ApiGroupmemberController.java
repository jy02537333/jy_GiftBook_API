
package com.jeecg.controller.giftbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.giftbook.SysUserEntity;
import com.jeecg.entity.giftbook.VGroupAndMemberEntity;
import com.jeecg.service.giftbook.VGroupAndMemberServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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










import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jeecg.entity.giftbook.GroupmemberEntity;
import com.jeecg.service.giftbook.GroupmemberServiceI;







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
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;


/**   
 * @Title: Controller
 * @Description: 组成员
 * @author zhangdaihao
 * @date 2016/11/4 14:09:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiGroupmemberCtrl")
public class ApiGroupmemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiGroupmemberController.class);

	@Autowired
	private GroupmemberServiceI groupmemberService;
	@Autowired
	private VGroupAndMemberServiceI vGroupAndMemberServiceI;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	
	/**
	 * AJAX请求数据
	 * @param groupmember
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(GroupmemberEntity groupmember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,gourpid,groupmember,totalmoney,state,createDate,affiliatedperson,memberphone");
		CriteriaQuery cq = new CriteriaQuery(GroupmemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, groupmember, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("gourpid", groupmember.getGourpid());
			cq.eq("createBy", groupmember.getCreateBy());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.groupmemberService.getDataGridReturn(cq, true);
		List<GroupmemberEntity> list=dataGrid.getResults();
		for (GroupmemberEntity item : list) {
			List<GroupmemberEntity> child=this.groupmemberService.findByProperty(
					GroupmemberEntity.class, "affiliatedpersonid", item.getAffiliatedperson());
			item.setAffiliatedpersonList(child);
		}
		
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 *  获取用户亲友组与亲友成员信息
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "getFullMember")
	@ResponseBody
	public Object getFullMember(VGroupAndMemberEntity vGroupAndMemberEntity, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("userid,groupid,isdefault,groupmembersnum,groupname,createdate,id,groupmember,totalmoney,memberphone,affiliatedperson,affiliatedpersonid");
		CriteriaQuery cq = new CriteriaQuery(VGroupAndMemberEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vGroupAndMemberEntity, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.addOrder("groupid", SortDirection.asc);
			cq.addOrder("createdate",SortDirection.desc);
			cq.add();
			this.vGroupAndMemberServiceI.getDataGridReturn(cq, true);
			List<GroupmemberEntity> list=dataGrid.getResults();
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}





	/**
	 * 删除组成员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(GroupmemberEntity groupmember, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
		{
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		groupmember = systemService.getEntity(GroupmemberEntity.class, groupmember.getId());
		message = "组成员删除成功";
		try{
			groupmemberService.delete(groupmember);
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
	 * 批量删除组成员
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
		message = "组成员删除成功";
		try{
			for(String id:ids.split(",")){
				GroupmemberEntity groupmember = systemService.getEntity(GroupmemberEntity.class, 
						id
						);
				groupmemberService.delete(groupmember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "组成员删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	/**
	 * 添加组成员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(GroupmemberEntity groupmember, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		groupmember.setCreateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型添加成功";
		try{
		Serializable  obj=	groupmemberService.save(groupmember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			if(obj==null)
				j.setResult(0);
			else
				{
				j.setResult(1);
				groupmember.setId((String)obj);
				j.setObj(groupmember);
				}
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
	 * 导入成员
	 * 
	 * @return
	 */
	@RequestMapping(params = "importMember")
	@ResponseBody
	public Object importMember(String importJson,String groupId, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "成员添加成功";
		try{
			java.lang.reflect.Type type	=new TypeToken<List<GroupmemberEntity>>() { }.getType();
			SysUserEntity user=TokenVerifyTool.getUser(request);
			Gson gson=new Gson();
			List<GroupmemberEntity> list=gson.fromJson(importJson, type);
			for (GroupmemberEntity groupmemberEntity : list) {
				groupmemberEntity.setCreateDate(new Date());
				groupmemberEntity.setCreateBy(user.getId());
				groupmemberEntity.setCreateName(user.getUsername());
				groupmemberEntity.setTotalmoney("0");
				groupmemberEntity.setState(1);
//				groupmemberEntity.setGourpid(groupId);
				groupmemberService.save(groupmemberEntity);
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
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
	 * 更新组成员
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(GroupmemberEntity groupmember, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型更新成功";
		GroupmemberEntity t = groupmemberService.get(GroupmemberEntity.class, groupmember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(groupmember, t);
			groupmemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			j.setResult(1);
			j.setObj(t);
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
		GroupmemberEntity task = groupmemberService.get(GroupmemberEntity.class, id);
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
	public Object create(@RequestBody GroupmemberEntity groupmember, UriComponentsBuilder uriBuilder
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<GroupmemberEntity>> failures = validator.validate(groupmember);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		//保存
		try{
			groupmemberService.save(groupmember);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = groupmember.getId();

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody GroupmemberEntity groupmember) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<GroupmemberEntity>> failures = validator.validate(groupmember);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			groupmemberService.saveOrUpdate(groupmember);
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
			groupmemberService.deleteEntityById(GroupmemberEntity.class, id);
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




     





































