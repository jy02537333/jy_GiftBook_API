package com.jeecg.controller.giftbook;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.giftbook.ReceivesInvitationEntity;
import com.jeecg.entity.giftbook.SysUserEntity;
import com.jeecg.service.giftbook.ReceivesInvitationServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: 添加收礼事件
 * @Description: receives_invitation
 * @author onlineGenerator
 * @date 2017-06-04 14:22:05
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiReceivesInvitationController")
public class ApiReceivesInvitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiReceivesInvitationController.class);

	@Autowired
	private ReceivesInvitationServiceI receivesInvitationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * receives_invitation列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/receivesInvitationList");
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
	public Object datagrid(ReceivesInvitationEntity receivesInvitationEntity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(ReceivesInvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, receivesInvitationEntity, request.getParameterMap());
		try{
			//自定义追加查询条件
			receivesInvitationEntity.setCreateBy(request.getParameter("userid").toString());
			cq.add();
			this.receivesInvitationService.getDataGridReturn(cq, true);
			j.setVarList(dataGrid.getResults());
			j.setResult(1);
			j.setSumCount(dataGrid.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 删除receives_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public org.jeecgframework.core.entity.AjaxJson doDel(ReceivesInvitationEntity receivesInvitation, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		receivesInvitation = systemService.getEntity(ReceivesInvitationEntity.class, receivesInvitation.getId());
		message = "receives_invitation删除成功";
		try{
			receivesInvitationService.delete(receivesInvitation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "receives_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除receives_invitation
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "receives_invitation删除成功";
		try{
			for(String id:ids.split(",")){
				ReceivesInvitationEntity receivesInvitation = systemService.getEntity(ReceivesInvitationEntity.class, 
				id
				);
				receivesInvitationService.delete(receivesInvitation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "receives_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加receives_invitation
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(ReceivesInvitationEntity receivesInvitation, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		message = "添加成功";
		try{
			SysUserEntity user=TokenVerifyTool.getUser(request);
			receivesInvitation.setCreateDate(new Date());
			receivesInvitation.setCreateBy(user.getId());
			receivesInvitation.setCreateName(user.getUsername());
			receivesInvitation.setState(1);
			receivesInvitationService.save(receivesInvitation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setObj(receivesInvitation);
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			j.setResult(0);
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新receives_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ReceivesInvitationEntity receivesInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "receives_invitation更新成功";
		ReceivesInvitationEntity t = receivesInvitationService.get(ReceivesInvitationEntity.class, receivesInvitation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(receivesInvitation, t);
			receivesInvitationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "receives_invitation更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * receives_invitation新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ReceivesInvitationEntity receivesInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receivesInvitation.getId())) {
			receivesInvitation = receivesInvitationService.getEntity(ReceivesInvitationEntity.class, receivesInvitation.getId());
			req.setAttribute("receivesInvitationPage", receivesInvitation);
		}
		return new ModelAndView("com/jeecg/giftbook/receivesInvitation-add");
	}
	/**
	 * receives_invitation编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ReceivesInvitationEntity receivesInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receivesInvitation.getId())) {
			receivesInvitation = receivesInvitationService.getEntity(ReceivesInvitationEntity.class, receivesInvitation.getId());
			req.setAttribute("receivesInvitationPage", receivesInvitation);
		}
		return new ModelAndView("com/jeecg/giftbook/receivesInvitation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","receivesInvitationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ReceivesInvitationEntity receivesInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		return "";
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ReceivesInvitationEntity receivesInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		return "";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setNeedSave(true);
			try {
				List<ReceivesInvitationEntity> listReceivesInvitationEntitys =(List<ReceivesInvitationEntity> )
				ExcelImportUtil.importExcelByIs(file.getInputStream(),ReceivesInvitationEntity.class,params);
				for (ReceivesInvitationEntity receivesInvitation : listReceivesInvitationEntitys) {
					receivesInvitationService.save(receivesInvitation);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ReceivesInvitationEntity> list() {
		List<ReceivesInvitationEntity> listReceivesInvitations=receivesInvitationService.getList(ReceivesInvitationEntity.class);
		return listReceivesInvitations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ReceivesInvitationEntity task = receivesInvitationService.get(ReceivesInvitationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ReceivesInvitationEntity receivesInvitation, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivesInvitationEntity>> failures = validator.validate(receivesInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			receivesInvitationService.save(receivesInvitation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = receivesInvitation.getId();
		URI uri = uriBuilder.path("/rest/receivesInvitationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ReceivesInvitationEntity receivesInvitation) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivesInvitationEntity>> failures = validator.validate(receivesInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			receivesInvitationService.saveOrUpdate(receivesInvitation);
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
		receivesInvitationService.deleteEntityById(ReceivesInvitationEntity.class, id);
	}
}
