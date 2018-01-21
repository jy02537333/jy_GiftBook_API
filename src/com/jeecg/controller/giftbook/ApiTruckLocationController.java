package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.TruckLocationEntity;
import com.jeecg.service.giftbook.TruckLocationServiceI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.*;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * @Title: Controller
 * @Description: truck_location
 * @author onlineGenerator
 * @date 2018-01-08 20:55:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiTruckLocationController")
public class ApiTruckLocationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiTruckLocationController.class);

	@Autowired
	private TruckLocationServiceI truckLocationService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * truck_location列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "truckLocation")
	public ModelAndView truckLocation(HttpServletRequest request) {
		return new ModelAndView("com/buss/giftbook/truckLocationList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(TruckLocationEntity truckLocation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,userid,latlng,dtid");
		CriteriaQuery cq = new CriteriaQuery(TruckLocationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truckLocation, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.truckLocationService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 * 删除truck_location
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TruckLocationEntity truckLocation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		truckLocation = systemService.getEntity(TruckLocationEntity.class, truckLocation.getId());
		message = "truck_location删除成功";
		try{
			truckLocationService.delete(truckLocation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "truck_location删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除truck_location
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "truck_location删除成功";
		try{
			for(String id:ids.split(",")){
				TruckLocationEntity truckLocation = systemService.getEntity(TruckLocationEntity.class, 
				id
				);
				truckLocationService.delete(truckLocation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "truck_location删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加truck_location
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TruckLocationEntity truckLocation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			Serializable id= truckLocationService.save(truckLocation);
			if(id!=null)
			{
				truckLocation.setId((String)id);
				j.setObj(truckLocation);
				j.setResult(1);
			}else
				j.setResult(0);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			j.setResult(0);
			e.printStackTrace();
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新truck_location
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TruckLocationEntity truckLocation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "truck_location更新成功";
		TruckLocationEntity t = truckLocationService.get(TruckLocationEntity.class, truckLocation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(truckLocation, t);
			truckLocationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "truck_location更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * truck_location新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TruckLocationEntity truckLocation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truckLocation.getId())) {
			truckLocation = truckLocationService.getEntity(TruckLocationEntity.class, truckLocation.getId());
			req.setAttribute("truckLocationPage", truckLocation);
		}
		return new ModelAndView("com/buss/giftbook/truckLocation-add");
	}
	/**
	 * truck_location编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TruckLocationEntity truckLocation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truckLocation.getId())) {
			truckLocation = truckLocationService.getEntity(TruckLocationEntity.class, truckLocation.getId());
			req.setAttribute("truckLocationPage", truckLocation);
		}
		return new ModelAndView("com/buss/giftbook/truckLocation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/buss/giftbook/truckLocationUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(TruckLocationEntity truckLocation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck_location";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			CriteriaQuery cq = new CriteriaQuery(TruckLocationEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truckLocation, request.getParameterMap());
			
			List<TruckLocationEntity> truckLocations = this.truckLocationService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck_location列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckLocationEntity.class, truckLocations);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public void exportXlsByT(TruckLocationEntity truckLocation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck_location";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck_location列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckLocationEntity.class, null);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
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
			params.setSecondTitleRows(1);
			params.setNeedSave(true);
			try {
				List<TruckLocationEntity> listTruckLocationEntitys = 
					(List<TruckLocationEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TruckLocationEntity.class,params);
				for (TruckLocationEntity truckLocation : listTruckLocationEntitys) {
					truckLocationService.save(truckLocation);
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
}
