package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.TruckRouteEntity;
import com.jeecg.service.giftbook.TruckRouteServiceI;
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
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Title: Controller
 * @Description: truck_route
 * @author onlineGenerator
 * @date 2018-01-08 20:55:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiTruckRouteController")
public class ApiTruckRouteController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiTruckRouteController.class);

	@Autowired
	private TruckRouteServiceI truckRouteService;
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
	 * truck_route列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "truckRoute")
	public ModelAndView truckRoute(HttpServletRequest request) {
		return new ModelAndView("com/buss/giftbook/truckRouteList");
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
	public Object datagrid(TruckRouteEntity truckRoute,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,startAddr,endAddr,info,licensePlate,phone,addr,latLng");
		CriteriaQuery cq = new CriteriaQuery(TruckRouteEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truckRoute, request.getParameterMap());
		try{
				cq.eq("type",truckRoute.getType());
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.truckRouteService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 * 删除truck_route
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TruckRouteEntity truckRoute, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		truckRoute = systemService.getEntity(TruckRouteEntity.class, truckRoute.getId());
		message = "truck_route删除成功";
		try{
			truckRouteService.delete(truckRoute);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "truck_route删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除truck_route
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "truck_route删除成功";
		try{
			for(String id:ids.split(",")){
				TruckRouteEntity truckRoute = systemService.getEntity(TruckRouteEntity.class, 
				id
				);
				truckRouteService.delete(truckRoute);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "truck_route删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加truck_route
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TruckRouteEntity truckRoute, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			truckRoute.setCreateDate(new Date());
			Serializable id= truckRouteService.save(truckRoute);
			if(id!=null)
			{
				truckRoute.setId((String)id);
				j.setObj(truckRoute);
				j.setResult(1);
			}else
				j.setResult(0);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			j.setResult(0);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新truck_route
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TruckRouteEntity truckRoute, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "truck_route更新成功";
		TruckRouteEntity t = truckRouteService.get(TruckRouteEntity.class, truckRoute.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(truckRoute, t);
			truckRouteService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "truck_route更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * truck_route新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TruckRouteEntity truckRoute, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truckRoute.getId())) {
			truckRoute = truckRouteService.getEntity(TruckRouteEntity.class, truckRoute.getId());
			req.setAttribute("truckRoutePage", truckRoute);
		}
		return new ModelAndView("com/buss/giftbook/truckRoute-add");
	}
	/**
	 * truck_route编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TruckRouteEntity truckRoute, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truckRoute.getId())) {
			truckRoute = truckRouteService.getEntity(TruckRouteEntity.class, truckRoute.getId());
			req.setAttribute("truckRoutePage", truckRoute);
		}
		return new ModelAndView("com/buss/giftbook/truckRoute-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/buss/giftbook/truckRouteUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(TruckRouteEntity truckRoute,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck_route";
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
			CriteriaQuery cq = new CriteriaQuery(TruckRouteEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truckRoute, request.getParameterMap());
			
			List<TruckRouteEntity> truckRoutes = this.truckRouteService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck_route列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckRouteEntity.class, truckRoutes);
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
	public void exportXlsByT(TruckRouteEntity truckRoute,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck_route";
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
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck_route列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckRouteEntity.class, null);
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
				List<TruckRouteEntity> listTruckRouteEntitys = 
					(List<TruckRouteEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TruckRouteEntity.class,params);
				for (TruckRouteEntity truckRoute : listTruckRouteEntitys) {
					truckRouteService.save(truckRoute);
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
