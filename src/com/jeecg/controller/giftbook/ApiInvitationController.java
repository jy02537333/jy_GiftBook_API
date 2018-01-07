package com.jeecg.controller.giftbook;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jeecg.entity.giftbook.InvitationEntity;
import com.jeecg.entity.giftbook.InvitationlistEntity;
import com.jeecg.service.giftbook.InvitationServiceI;
import com.jeecg.service.giftbook.InvitationlistServiceI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;

import java.io.Serializable;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
 * @Title: Controller  
 * @Description: 请帖
 * @author onlineGenerator
 * @date 2017-02-21 15:56:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiInvitationController")
public class ApiInvitationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiInvitationController.class);

	@Autowired
	private InvitationServiceI invitationService;
	@Autowired
	private InvitationlistServiceI invitationlistService;
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
	public Object byid(InvitationEntity invitation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,invitationid,invitationName,inviteeid");
		//dataGrid.setField("id,inviterid,inviterphone,feastaddress,feastdate,feasttype,invitername,coverimg,photoalbum,state,createDate");
		CriteriaQuery cq = new CriteriaQuery(InvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, invitation, request.getParameterMap());
		AjaxJson json= null;
		try {
			//cq.add();
			//this.invitationlistService.getDataGridReturn(cq, true);
			invitation=	invitationService.get(InvitationEntity.class,request.getParameter("invitationid"));
			InvitationlistEntity invitationlistEntity=invitationlistService.get(InvitationlistEntity.class,request.getParameter("invitationChildId"));
			List<InvitationlistEntity> addChild=new ArrayList<>();
			addChild.add(invitationlistEntity);
			invitation.setInvitationlistEntityList(addChild);
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
		this.invitationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "getList")
	@ResponseBody
	public Object getList(InvitationlistEntity invitationList,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,invitationid,invitationName,inviteeid");
		//dataGrid.setField("id,inviterid,inviterphone,feastaddress,feastdate,feasttype,invitername,coverimg,photoalbum,state,createDate");
		CriteriaQuery cq = new CriteriaQuery(InvitationlistEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, invitationList, request.getParameterMap());
		try{
//			cq.eq("inviteeid",request.getParameter("userid"));
			cq.eq("inviteephone",request.getParameter("phone"));
			cq.addOrder("createDate", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		AjaxJson json= null;
		try {
			cq.add();
			this.invitationlistService.getDataGridReturn(cq, true);
			List<InvitationlistEntity> list= dataGrid.getResults();
			List<InvitationEntity> retList=new ArrayList<>();
			for (InvitationlistEntity item:list			 ) {
                InvitationEntity invitationEntity=	invitationService.get(InvitationEntity.class,item.getInvitationid());
                List<InvitationlistEntity> addChild=new ArrayList<>();
                addChild.add(item);
                invitationEntity.setInvitationlistEntityList(addChild);
                retList.add(invitationEntity);
            }
			json = new AjaxJson();
			json.setVarList(retList);
			json.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			json = new AjaxJson();
			json.setResult(0);
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}



	/**
	 * 删除请帖
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(InvitationEntity invitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		invitation = systemService.getEntity(InvitationEntity.class, invitation.getId());
		message = "请帖删除成功";
		try{
			invitationService.delete(invitation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除请帖
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖删除成功";
		try{
			for(String id:ids.split(",")){
				InvitationEntity invitation = systemService.getEntity(InvitationEntity.class, 
				id
				);
				invitationService.delete(invitation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加请帖
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(InvitationEntity invitation,String invitationListJson, HttpServletRequest request) {
		if(TokenVerifyTool.verify(request))
		{
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖添加成功";
		try{
			invitation.setCreateDate(new Date());
			invitation.setCreateBy(invitation.getInviterid());
			invitation.setCreateName(invitation.getCreateName());
			invitation.setState(1);
			Serializable retId=invitationService.save(invitation);
			if(retId!=null)
			{
				invitation.setId((String)retId);
				java.lang.reflect.Type type	=new TypeToken<List<InvitationlistEntity>>() { }.getType();
				Gson gson=new Gson();
				StringBuffer sbBuffer=new StringBuffer(
					"INSERT INTO invitationlist (id,invitationId,invitationName,InviteeId,InviteeName,InviteePhone,State,CREATE_DATE,CREATE_BY,CREATE_NAME,ManName,WomanName)values");
				List<InvitationlistEntity> list=gson.fromJson(invitationListJson, type);
				String[] phones=new String[list.size()];
				int i=0;
				for (InvitationlistEntity entity : list) {
					sbBuffer.append("(REPLACE(UUID(),'-','')");
					sbBuffer.append(",'"+invitation.getId()+"'");
					sbBuffer.append(",'"+invitation.getCreateName()+"'");
					sbBuffer.append(",'"+entity.getInviteeid()+"'");
					sbBuffer.append(",'"+entity.getInviteename()+"'");
					sbBuffer.append(",'"+entity.getInviteephone()+"',1,'"+DateUtils.date2Str(invitation.getFeastdate(),DateUtils.datetimeFormat)+"'");
					sbBuffer.append(",'"+invitation.getInviterid()+"'");
					sbBuffer.append(",'"+invitation.getCreateName()+"'");
					sbBuffer.append(",'"+invitation.getManname()+"'");
					sbBuffer.append(",'"+invitation.getWomanname()+"'),");
					phones[i]=entity.getInviteephone();
					i++;
				}
				sbBuffer=sbBuffer.deleteCharAt(sbBuffer.length()-1);
				//List<Object>  listParam=new ArrayList<>();
				invitationlistService.executeSql(sbBuffer.toString(), new Object[]{});
//				Thread thread=new Thread(new MyRunnable(phones));
//				thread.run();
				j.setResult(1);
				invitation.setId((String)retId);
				j.setObj(invitation);
			}else {
				j.setResult(0);
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	class MyRunnable implements Runnable{
	String[] phones;
	public  MyRunnable(String[] phones) {
		this.phones=phones;
	}
		@Override
		public void run() {
			for (String phone : phones) {
				
			}
			
		}
		
	}
	
	
	/**
	 * 更新请帖
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(InvitationEntity invitation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖更新成功";
		InvitationEntity t = invitationService.get(InvitationEntity.class, invitation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(invitation, t);
			invitationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "请帖更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 请帖新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(InvitationEntity invitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(invitation.getId())) {
			invitation = invitationService.getEntity(InvitationEntity.class, invitation.getId());
			req.setAttribute("invitationPage", invitation);
		}
		return new ModelAndView("com/jeecg/giftbook/invitation-add");
	}
	/**
	 * 请帖编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(InvitationEntity invitation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(invitation.getId())) {
			invitation = invitationService.getEntity(InvitationEntity.class, invitation.getId());
			req.setAttribute("invitationPage", invitation);
		}
		return new ModelAndView("com/jeecg/giftbook/invitation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","invitationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(InvitationEntity invitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
//		CriteriaQuery cq = new CriteriaQuery(InvitationEntity.class, dataGrid);
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, invitation, request.getParameterMap());
//		List<InvitationEntity> invitations = this.invitationService.getListByCriteriaQuery(cq,false);
//		modelMap.put(NormalExcelConstants.FILE_NAME,"请帖");
//		modelMap.put(NormalExcelConstants.CLASS,InvitationEntity.class);
//		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("请帖列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//			"导出信息"));
//		modelMap.put(NormalExcelConstants.DATA_LIST,invitations);
//		return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return null;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(InvitationEntity invitation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
//    	modelMap.put(NormalExcelConstants.FILE_NAME,"请帖");
//    	modelMap.put(NormalExcelConstants.CLASS,InvitationEntity.class);
//    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("请帖列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//    	"导出信息"));
//    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
//    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return null;
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
				List<InvitationEntity> listInvitationEntitys =(	List<InvitationEntity>)
				ExcelImportUtil.importExcelByIs(file.getInputStream(),InvitationEntity.class,params);
				for (InvitationEntity invitation : listInvitationEntitys) {
					invitationService.save(invitation);
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
	public List<InvitationEntity> list() {
		List<InvitationEntity> listInvitations=invitationService.getList(InvitationEntity.class);
		return listInvitations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		InvitationEntity task = invitationService.get(InvitationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody InvitationEntity invitation, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<InvitationEntity>> failures = validator.validate(invitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			invitationService.save(invitation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = invitation.getId();
		URI uri = uriBuilder.path("/rest/invitationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody InvitationEntity invitation) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<InvitationEntity>> failures = validator.validate(invitation);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			invitationService.saveOrUpdate(invitation);
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
		invitationService.deleteEntityById(InvitationEntity.class, id);
	}
	
	public  String replaceStr(String inputStr)
	{
		inputStr=inputStr.replaceAll("＆", "&amp;")  
         .replaceAll("<", "&lt;")  
         .replaceAll(">", "&gt;")  
         .replaceAll("=", "&ge;")  
          .replaceAll("\'", "&apos;")  
         .replaceAll("\"", "&quot;");
		return inputStr;
	}
	
	public static void main(String[] args) {
	//	String str=replaceStr("select *>= from aa where 1=1");
	//	System.out.println("防SQL注入:"+str);
	}
}











