package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.InvitationEntity;
import com.jeecg.entity.giftbook.ViewInvitationEntity;
import com.jeecg.service.giftbook.ViewInvitationServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.*;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

/**   
 * @Title: Controller  
 * @Description: 请帖
 * @author onlineGenerator
 * @date 2017-02-21 15:56:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiViewInvitationController")
public class ApiV_InvitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiV_InvitationController.class);

	@Autowired
	private ViewInvitationServiceI vInvitationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 请帖列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/api_invitationList");
	}
	/**
	 * 请帖详情 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "invitationDetail")
	public ModelAndView invitationDetail(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/api_invitationDetail");
	}
	/**
	 * easyui AJAX请帖详情
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "byid")
	@ResponseBody
	public Object byid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,invitationid,invitationName,inviteeid");
		//dataGrid.setField("id,inviterid,inviterphone,feastaddress,feastdate,feasttype,invitername,coverimg,photoalbum,state,createDate");
		CriteriaQuery cq = new CriteriaQuery(InvitationEntity.class, dataGrid);
		//查询条件组装器
		AjaxJson json= null;
		try {
			//cq.add();
			//this.invitationlistService.getDataGridReturn(cq, true);
			ViewInvitationEntity	invitation=	vInvitationService.findUniqueByProperty(ViewInvitationEntity.class,
					"id",request.getParameter("invitationid"));
			json = new AjaxJson();
			json.setObj(invitation);
			json.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			json = new AjaxJson();
			json.setResult(0);
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(InvitationEntity invitation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,inviterid,inviterphone,feastaddress,feastdate,feasttype,invitername,coverimg,photoalbum,state,createDate");
		CriteriaQuery cq = new CriteriaQuery(InvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, invitation, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vInvitationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}



}











