package com.jeecg.controller.giftbook;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.giftbook.VReceivesInvitationEntity;
import com.jeecg.service.giftbook.VReceivesInvitationServiceI;
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
import org.jeecgframework.web.system.service.SystemService;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @Title: 收礼记录信息
 * @Description: v_receives_invitation
 * @author onlineGenerator
 * @date 2017-06-02 23:18:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiVReceivesInvitationController")
public class ApiVReceivesInvitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiVReceivesInvitationController.class);

	@Autowired
	private VReceivesInvitationServiceI vReceivesInvitationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * v_receives_invitation列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/gift/vReceivesInvitationList");
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
	public Object datagrid(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();

		CriteriaQuery cq = new CriteriaQuery(VReceivesInvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vReceivesInvitation, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("inviteeid",request.getParameter("userid"));
			cq.addOrder("feastdate", SortDirection.desc);
			//
			cq.add();
			this.vReceivesInvitationService.getDataGridReturn(cq, true);
			j.setVarList(cq.getResults());
			j.setResult(1);
			j.setMsg("成功！");
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 删除v_receives_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vReceivesInvitation = systemService.getEntity(VReceivesInvitationEntity.class, vReceivesInvitation.getId());
		message = "v_receives_invitation删除成功";
		try{
			vReceivesInvitationService.delete(vReceivesInvitation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "v_receives_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除v_receives_invitation
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_receives_invitation删除成功";
		try{
			for(String id:ids.split(",")){
				VReceivesInvitationEntity vReceivesInvitation = systemService.getEntity(VReceivesInvitationEntity.class, 
				id
				);
				vReceivesInvitationService.delete(vReceivesInvitation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "v_receives_invitation删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加v_receives_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		String message = null;
		message = "添加收礼信息成功";
		try{
			vReceivesInvitationService.save(vReceivesInvitation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加收礼信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新v_receives_invitation
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "v_receives_invitation更新成功";
		VReceivesInvitationEntity t = vReceivesInvitationService.get(VReceivesInvitationEntity.class, vReceivesInvitation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vReceivesInvitation, t);
			vReceivesInvitationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "v_receives_invitation更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * v_receives_invitation新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vReceivesInvitation.getId())) {
			vReceivesInvitation = vReceivesInvitationService.getEntity(VReceivesInvitationEntity.class, vReceivesInvitation.getId());
			req.setAttribute("vReceivesInvitationPage", vReceivesInvitation);
		}
		return new ModelAndView("com/jeecg/gift/vReceivesInvitation-add");
	}
	/**
	 * v_receives_invitation编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VReceivesInvitationEntity vReceivesInvitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vReceivesInvitation.getId())) {
			vReceivesInvitation = vReceivesInvitationService.getEntity(VReceivesInvitationEntity.class, vReceivesInvitation.getId());
			req.setAttribute("vReceivesInvitationPage", vReceivesInvitation);
		}
		return new ModelAndView("com/jeecg/gift/vReceivesInvitation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vReceivesInvitationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VReceivesInvitationEntity vReceivesInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VReceivesInvitationEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vReceivesInvitation, request.getParameterMap());
		List<VReceivesInvitationEntity> vReceivesInvitations = this.vReceivesInvitationService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"v_receives_invitation");
		modelMap.put(NormalExcelConstants.CLASS,VReceivesInvitationEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("v_receives_invitation列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vReceivesInvitations);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VReceivesInvitationEntity vReceivesInvitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"v_receives_invitation");
    	modelMap.put(NormalExcelConstants.CLASS,VReceivesInvitationEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("v_receives_invitation列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<VReceivesInvitationEntity> listVReceivesInvitationEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VReceivesInvitationEntity.class,params);
				for (VReceivesInvitationEntity vReceivesInvitation : listVReceivesInvitationEntitys) {
					vReceivesInvitationService.save(vReceivesInvitation);
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
	public List<VReceivesInvitationEntity> list() {
		List<VReceivesInvitationEntity> listVReceivesInvitations=vReceivesInvitationService.getList(VReceivesInvitationEntity.class);
		return listVReceivesInvitations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		VReceivesInvitationEntity task = vReceivesInvitationService.get(VReceivesInvitationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody VReceivesInvitationEntity vReceivesInvitation, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VReceivesInvitationEntity>> failures = validator.validate(vReceivesInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			vReceivesInvitationService.save(vReceivesInvitation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = vReceivesInvitation.getId();
		URI uri = uriBuilder.path("/rest/vReceivesInvitationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody VReceivesInvitationEntity vReceivesInvitation) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VReceivesInvitationEntity>> failures = validator.validate(vReceivesInvitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			vReceivesInvitationService.saveOrUpdate(vReceivesInvitation);
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
		vReceivesInvitationService.deleteEntityById(VReceivesInvitationEntity.class, id);
	}
}
