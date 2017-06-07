package com.jeecg.controller.giftbook;
import com.jeecg.entity.giftbook.VSendInvitationEntity;
import com.jeecg.service.giftbook.VSendInvitationServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: 我发送的请帖信息
 * @Description: v_send_invitation
 * @author onlineGenerator
 * @date 2017-06-07 15:34:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiVSendInvitationController")
public class ApiVSendInvitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiVSendInvitationController.class);

	@Autowired
	private VSendInvitationServiceI vSendInvitationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * v_send_invitation列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/vSendInvitationList");
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
	public Object datagrid(VSendInvitationEntity vSendInvitation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,manname,womanname,state,create_date,create_by,create_name,inviterid,inviterphone,feastaddress,feastdate,coverimg,photoalbum,feasttype,num");
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(VSendInvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vSendInvitation, request.getParameterMap());
		try{
			cq.addOrder("create_date", SortDirection.desc);
			//自定义追加查询条件
			cq.add();
			this.vSendInvitationService.getDataGridReturn(cq, true);
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
	 * 删除v_send_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VSendInvitationEntity vSendInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vSendInvitation = systemService.getEntity(VSendInvitationEntity.class, vSendInvitation.getId());
		message = "v_send_invitation删除成功";
		try{
			vSendInvitationService.delete(vSendInvitation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_send_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除v_send_invitation
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_send_invitation删除成功";
		try{
			for(String id:ids.split(",")){
				VSendInvitationEntity vSendInvitation = systemService.getEntity(VSendInvitationEntity.class, 
				id
				);
				vSendInvitationService.delete(vSendInvitation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "v_send_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加v_send_invitation
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VSendInvitationEntity vSendInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_send_invitation添加成功";
		try{
			vSendInvitationService.save(vSendInvitation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_send_invitation添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新v_send_invitation
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VSendInvitationEntity vSendInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_send_invitation更新成功";
		VSendInvitationEntity t = vSendInvitationService.get(VSendInvitationEntity.class, vSendInvitation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vSendInvitation, t);
			vSendInvitationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "v_send_invitation更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * v_send_invitation新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VSendInvitationEntity vSendInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vSendInvitation.getId())) {
			vSendInvitation = vSendInvitationService.getEntity(VSendInvitationEntity.class, vSendInvitation.getId());
			req.setAttribute("vSendInvitationPage", vSendInvitation);
		}
		return new ModelAndView("com/jeecg/giftbook/vSendInvitation-add");
	}
	/**
	 * v_send_invitation编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VSendInvitationEntity vSendInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vSendInvitation.getId())) {
			vSendInvitation = vSendInvitationService.getEntity(VSendInvitationEntity.class, vSendInvitation.getId());
			req.setAttribute("vSendInvitationPage", vSendInvitation);
		}
		return new ModelAndView("com/jeecg/giftbook/vSendInvitation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vSendInvitationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VSendInvitationEntity vSendInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VSendInvitationEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vSendInvitation, request.getParameterMap());
		List<VSendInvitationEntity> vSendInvitations = this.vSendInvitationService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"v_send_invitation");
		modelMap.put(NormalExcelConstants.CLASS,VSendInvitationEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("v_send_invitation列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vSendInvitations);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VSendInvitationEntity vSendInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"v_send_invitation");
    	modelMap.put(NormalExcelConstants.CLASS,VSendInvitationEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("v_send_invitation列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
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
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<VSendInvitationEntity> listVSendInvitationEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VSendInvitationEntity.class,params);
				for (VSendInvitationEntity vSendInvitation : listVSendInvitationEntitys) {
					vSendInvitationService.save(vSendInvitation);
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
	public List<VSendInvitationEntity> list() {
		List<VSendInvitationEntity> listVSendInvitations=vSendInvitationService.getList(VSendInvitationEntity.class);
		return listVSendInvitations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		VSendInvitationEntity task = vSendInvitationService.get(VSendInvitationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody VSendInvitationEntity vSendInvitation, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VSendInvitationEntity>> failures = validator.validate(vSendInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			vSendInvitationService.save(vSendInvitation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = vSendInvitation.getId();
		URI uri = uriBuilder.path("/rest/vSendInvitationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody VSendInvitationEntity vSendInvitation) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VSendInvitationEntity>> failures = validator.validate(vSendInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			vSendInvitationService.saveOrUpdate(vSendInvitation);
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
		vSendInvitationService.deleteEntityById(VSendInvitationEntity.class, id);
	}
}
