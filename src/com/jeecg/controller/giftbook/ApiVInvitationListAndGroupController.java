package com.jeecg.controller.giftbook;
import com.jeecg.entity.giftbook.VInvitationListAndGroupEntity;
import com.jeecg.service.giftbook.VInvitationListAndGroupServiceI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.http.MediaType;

/**   
 * @Title: 请帖邀请人 加分组 视图
 * @Description: v_invitation_list_and_group
 * @author onlineGenerator
 * @date 2017-06-09 11:34:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiVInvitationListAndGroupController")
public class ApiVInvitationListAndGroupController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiVInvitationListAndGroupController.class);

	@Autowired
	private VInvitationListAndGroupServiceI vInvitationListAndGroupService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * v_invitation_list_and_group列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/vInvitationListAndGroupList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(VInvitationListAndGroupEntity vInvitationListAndGroup,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField(
				"id,inviteeid,inviteename,inviteephone,groupname,gourpid,invitationid");
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(VInvitationListAndGroupEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vInvitationListAndGroup, request.getParameterMap());
		try{
			cq.addOrder("inviteephone", SortDirection.desc);
			//自定义追加查询条件
			cq.add();
			this.vInvitationListAndGroupService.getDataGridReturn(cq, true);
			j.setVarList(dataGrid.getResults());
			j.setSumCount(dataGrid.getTotal());
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}
	/**
	 * 批量删除v_invitation_list_and_group
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_invitation_list_and_group删除成功";
		try{
			for(String id:ids.split(",")){
				VInvitationListAndGroupEntity vInvitationListAndGroup = systemService.getEntity(VInvitationListAndGroupEntity.class, 
				id
				);
				vInvitationListAndGroupService.delete(vInvitationListAndGroup);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "v_invitation_list_and_group删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加v_invitation_list_and_group
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VInvitationListAndGroupEntity vInvitationListAndGroup, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_invitation_list_and_group添加成功";
		try{
			vInvitationListAndGroupService.save(vInvitationListAndGroup);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_invitation_list_and_group添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<VInvitationListAndGroupEntity> list() {
		List<VInvitationListAndGroupEntity> listVInvitationListAndGroups=vInvitationListAndGroupService.getList(VInvitationListAndGroupEntity.class);
		return listVInvitationListAndGroups;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		VInvitationListAndGroupEntity task = vInvitationListAndGroupService.get(VInvitationListAndGroupEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody VInvitationListAndGroupEntity vInvitationListAndGroup) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VInvitationListAndGroupEntity>> failures = validator.validate(vInvitationListAndGroup);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			vInvitationListAndGroupService.saveOrUpdate(vInvitationListAndGroup);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		vInvitationListAndGroupService.deleteEntityById(VInvitationListAndGroupEntity.class, id);
	}
}
