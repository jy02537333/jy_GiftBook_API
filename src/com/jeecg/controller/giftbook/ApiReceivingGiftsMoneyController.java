package com.jeecg.controller.giftbook;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.entity.giftbook.ReceivingGiftsMoneyEntity;
import com.jeecg.entity.giftbook.SysUserEntity;
import com.jeecg.service.giftbook.ReceivingGiftsMoneyServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.entity.AjaxJson;
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
 * @Title: 收礼事件项详细信息
 * @Description: receiving_gifts_money
 * @author onlineGenerator
 * @date 2017-06-03 15:11:20
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiReceivingGiftsMoneyController")
public class ApiReceivingGiftsMoneyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiReceivingGiftsMoneyController.class);

	@Autowired
	private ReceivingGiftsMoneyServiceI receivingGiftsMoneyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * receiving_gifts_money列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/receivingGiftsMoneyList");
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
	public Object datagrid(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField(
				"id,gourpmemberid,groupmember,isexpenditure,money,expendituretype,expendituretypename,correlativeinvitation,expendituredate,remark,state,createDate,createBy,createName");
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(ReceivingGiftsMoneyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, receivingGiftsMoney, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.addOrder("createDate", SortDirection.desc);
			cq.add();
			this.receivingGiftsMoneyService.getDataGridReturn(cq, true);
			j.setVarList(dataGrid.getResults());
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 删除receiving_gifts_money
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		receivingGiftsMoney = systemService.getEntity(ReceivingGiftsMoneyEntity.class, receivingGiftsMoney.getId());
		message = "删除收礼成功";
		try{
			receivingGiftsMoneyService.delete(receivingGiftsMoney);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除收礼失败";
			j.setResult(0);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除receiving_gifts_money
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "receiving_gifts_money删除成功";
		try{
			for(String id:ids.split(",")){
				ReceivingGiftsMoneyEntity receivingGiftsMoney = systemService.getEntity(ReceivingGiftsMoneyEntity.class, 
				id
				);
				receivingGiftsMoneyService.delete(receivingGiftsMoney);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "receiving_gifts_money删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加receiving_gifts_money
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest request) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();
		try{
			message="记账成功！";
			SysUserEntity user=TokenVerifyTool.getUser(request);
			receivingGiftsMoney.setCreateDate(new Date());
			receivingGiftsMoney.setCreateBy(user.getId());
			receivingGiftsMoney.setCreateName(user.getUsername());
			receivingGiftsMoney.setExpendituredate(new Date());
			receivingGiftsMoney.setState(1);
			receivingGiftsMoneyService.save(receivingGiftsMoney);
			j.setResult(1);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新receiving_gifts_money
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "receiving_gifts_money更新成功";
		ReceivingGiftsMoneyEntity t = receivingGiftsMoneyService.get(ReceivingGiftsMoneyEntity.class, receivingGiftsMoney.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(receivingGiftsMoney, t);
			receivingGiftsMoneyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "receiving_gifts_money更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * receiving_gifts_money新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receivingGiftsMoney.getId())) {
			receivingGiftsMoney = receivingGiftsMoneyService.getEntity(ReceivingGiftsMoneyEntity.class, receivingGiftsMoney.getId());
			req.setAttribute("receivingGiftsMoneyPage", receivingGiftsMoney);
		}
		return new ModelAndView("com/jeecg/giftbook/receivingGiftsMoney-add");
	}
	/**
	 * receiving_gifts_money编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ReceivingGiftsMoneyEntity receivingGiftsMoney, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receivingGiftsMoney.getId())) {
			receivingGiftsMoney = receivingGiftsMoneyService.getEntity(ReceivingGiftsMoneyEntity.class, receivingGiftsMoney.getId());
			req.setAttribute("receivingGiftsMoneyPage", receivingGiftsMoney);
		}
		return new ModelAndView("com/jeecg/giftbook/receivingGiftsMoney-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","receivingGiftsMoneyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ReceivingGiftsMoneyEntity receivingGiftsMoney,HttpServletRequest request,HttpServletResponse response
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
	public String exportXlsByT(ReceivingGiftsMoneyEntity receivingGiftsMoney,HttpServletRequest request,HttpServletResponse response
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
				List<ReceivingGiftsMoneyEntity> listReceivingGiftsMoneyEntitys =(List<ReceivingGiftsMoneyEntity>)
				ExcelImportUtil.importExcelByIs(file.getInputStream(),ReceivingGiftsMoneyEntity.class,params);
				for (ReceivingGiftsMoneyEntity receivingGiftsMoney : listReceivingGiftsMoneyEntitys) {
					receivingGiftsMoneyService.save(receivingGiftsMoney);
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
	public List<ReceivingGiftsMoneyEntity> list() {
		List<ReceivingGiftsMoneyEntity> listReceivingGiftsMoneys=receivingGiftsMoneyService.getList(ReceivingGiftsMoneyEntity.class);
		return listReceivingGiftsMoneys;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		ReceivingGiftsMoneyEntity task = receivingGiftsMoneyService.get(ReceivingGiftsMoneyEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody ReceivingGiftsMoneyEntity receivingGiftsMoney, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivingGiftsMoneyEntity>> failures = validator.validate(receivingGiftsMoney);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			receivingGiftsMoneyService.save(receivingGiftsMoney);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = receivingGiftsMoney.getId();
		URI uri = uriBuilder.path("/rest/receivingGiftsMoneyController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ReceivingGiftsMoneyEntity receivingGiftsMoney) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivingGiftsMoneyEntity>> failures = validator.validate(receivingGiftsMoney);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			receivingGiftsMoneyService.saveOrUpdate(receivingGiftsMoney);
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
		receivingGiftsMoneyService.deleteEntityById(ReceivingGiftsMoneyEntity.class, id);
	}
}
