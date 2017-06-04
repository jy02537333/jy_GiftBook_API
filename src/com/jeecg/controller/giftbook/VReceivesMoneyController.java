package com.jeecg.controller.giftbook;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.giftbook.VReceivesMoneyEntity;
import com.jeecg.service.giftbook.VReceivesMoneyServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
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
import org.jeecgframework.web.system.service.SystemService;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.validation.Validator;

/**   
 * @Title: 收礼事件标题视图
 * @Description: v_receives_money
 * @author onlineGenerator
 * @date 2017-06-03 15:20:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiVReceivesMoneyController")
public class VReceivesMoneyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(VReceivesMoneyController.class);

	@Autowired
	private VReceivesMoneyServiceI vReceivesMoneyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * v_receives_money列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/vReceivesMoneyList");
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
	public Object datagrid(VReceivesMoneyEntity vReceivesMoney,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(VReceivesMoneyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vReceivesMoney, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.add();
			this.vReceivesMoneyService.getDataGridReturn(cq, true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 删除v_receives_money
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VReceivesMoneyEntity vReceivesMoney, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vReceivesMoney = systemService.getEntity(VReceivesMoneyEntity.class, vReceivesMoney.getId());
		message = "v_receives_money删除成功";
		try{
			vReceivesMoneyService.delete(vReceivesMoney);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_receives_money删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除v_receives_money
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_receives_money删除成功";
		try{
			for(String id:ids.split(",")){
				VReceivesMoneyEntity vReceivesMoney = systemService.getEntity(VReceivesMoneyEntity.class, 
				id
				);
				vReceivesMoneyService.delete(vReceivesMoney);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "v_receives_money删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加v_receives_money
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VReceivesMoneyEntity vReceivesMoney, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_receives_money添加成功";
		try{
			vReceivesMoneyService.save(vReceivesMoney);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_receives_money添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<VReceivesMoneyEntity> list() {
		List<VReceivesMoneyEntity> listVReceivesMoneys=vReceivesMoneyService.getList(VReceivesMoneyEntity.class);
		return listVReceivesMoneys;
	}
	


}
