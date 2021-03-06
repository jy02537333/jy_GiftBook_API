package com.jeecg.controller.giftbook;
import com.jeecg.entity.giftbook.SidekickergroupEntity;
import com.jeecg.service.giftbook.SidekickergroupServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;

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
 * @Title: Controller  
 * @Description: 亲友团
 * @author onlineGenerator
 * @date 2016-11-04 13:54:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sidekickergroupController")
public class SidekickergroupController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SidekickergroupController.class);

	@Autowired
	private SidekickergroupServiceI sidekickergroupService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 亲友团列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/sidekickergroupList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SidekickergroupEntity sidekickergroup,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SidekickergroupEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sidekickergroup, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sidekickergroupService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除亲友团
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SidekickergroupEntity sidekickergroup, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		sidekickergroup = systemService.getEntity(SidekickergroupEntity.class, sidekickergroup.getId());
		message = "亲友团删除成功";
		try{
			sidekickergroupService.delete(sidekickergroup);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "亲友团删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除亲友团
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团删除成功";
		try{
			for(String id:ids.split(",")){
				SidekickergroupEntity sidekickergroup = systemService.getEntity(SidekickergroupEntity.class, 
				id
				);
				sidekickergroupService.delete(sidekickergroup);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "亲友团删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加亲友团
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SidekickergroupEntity sidekickergroup, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团添加成功";
		try{
			sidekickergroupService.save(sidekickergroup);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "亲友团添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新亲友团
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SidekickergroupEntity sidekickergroup, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "亲友团更新成功";
		SidekickergroupEntity t = sidekickergroupService.get(SidekickergroupEntity.class, sidekickergroup.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sidekickergroup, t);
			sidekickergroupService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "亲友团更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 亲友团新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SidekickergroupEntity sidekickergroup, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sidekickergroup.getId())) {
			sidekickergroup = sidekickergroupService.getEntity(SidekickergroupEntity.class, sidekickergroup.getId());
			req.setAttribute("sidekickergroupPage", sidekickergroup);
		}
		return new ModelAndView("com/jeecg/giftbook/sidekickergroup-add");
	}
	/**
	 * 亲友团编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SidekickergroupEntity sidekickergroup, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sidekickergroup.getId())) {
			sidekickergroup = sidekickergroupService.getEntity(SidekickergroupEntity.class, sidekickergroup.getId());
			req.setAttribute("sidekickergroupPage", sidekickergroup);
		}
		return new ModelAndView("com/jeecg/giftbook/sidekickergroup-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","sidekickergroupController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SidekickergroupEntity sidekickergroup,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
//		CriteriaQuery cq = new CriteriaQuery(SidekickergroupEntity.class, dataGrid);
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sidekickergroup, request.getParameterMap());
//		List<SidekickergroupEntity> sidekickergroups = this.sidekickergroupService.getListByCriteriaQuery(cq,false);
//		modelMap.put(NormalExcelConstants.FILE_NAME,"亲友团");
//		modelMap.put(NormalExcelConstants.CLASS,SidekickergroupEntity.class);
//		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("亲友团列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//			"导出信息"));
//		modelMap.put(NormalExcelConstants.DATA_LIST,sidekickergroups);
//		return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return  null;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SidekickergroupEntity sidekickergroup,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
//    	modelMap.put(NormalExcelConstants.FILE_NAME,"亲友团");
//    	modelMap.put(NormalExcelConstants.CLASS,SidekickergroupEntity.class);
//    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("亲友团列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//    	"导出信息"));
//    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
//    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return  null;
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
//			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<SidekickergroupEntity> listSidekickergroupEntitys =(List<SidekickergroupEntity>)
				ExcelImportUtil.importExcelByIs(file.getInputStream(),SidekickergroupEntity.class,params);
				for (SidekickergroupEntity sidekickergroup : listSidekickergroupEntitys) {
					sidekickergroupService.save(sidekickergroup);
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
	public List<SidekickergroupEntity> list() {
		List<SidekickergroupEntity> listSidekickergroups=sidekickergroupService.getList(SidekickergroupEntity.class);
		return listSidekickergroups;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		SidekickergroupEntity task = sidekickergroupService.get(SidekickergroupEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody SidekickergroupEntity sidekickergroup, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SidekickergroupEntity>> failures = validator.validate(sidekickergroup);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			sidekickergroupService.save(sidekickergroup);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = sidekickergroup.getId();
		URI uri = uriBuilder.path("/rest/sidekickergroupController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody SidekickergroupEntity sidekickergroup) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SidekickergroupEntity>> failures = validator.validate(sidekickergroup);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			sidekickergroupService.saveOrUpdate(sidekickergroup);
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
		sidekickergroupService.deleteEntityById(SidekickergroupEntity.class, id);
	}
}
