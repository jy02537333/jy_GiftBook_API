package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.TruckEntity;
import com.jeecg.entity.giftbook.TruckLocationEntity;
import com.jeecg.service.giftbook.TruckLocationServiceI;
import com.jeecg.service.giftbook.TruckServiceI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Title: Controller
 * @Description: truck
 * @author onlineGenerator
 * @date 2018-01-08 20:56:14
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiTruckController")
public class ApiTruckController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiTruckController.class);

	@Autowired
	private TruckServiceI truckService;
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
	 * truck列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "truck")
	public ModelAndView truck(HttpServletRequest request) {
		return new ModelAndView("com/buss/giftbook/truckList");
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
	public Object datagrid(TruckEntity truck,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,userid,vehicleType,licensePlate,describes,phone");
		CriteriaQuery cq = new CriteriaQuery(TruckEntity.class, dataGrid);
		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truck, request.getParameterMap());
		try{
			if(truck.getVehicleType()!=null&&truck.getVehicleType().equals("1"))
				cq.eq("vehicleType","拖车");
			else
			{
				cq.notEq("vehicleType","拖车");
			}
			truck.setVehicleType(null);
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.truckService.getDataGridReturn(cq, true);
		List<TruckEntity> trucks= dataGrid.getResults();
		for (TruckEntity item:trucks) {
//			String hql="from TruckLocation where truckId='"+item.getId()+"' and createDate=max(createDate) ";
			String hql="from TruckLocationEntity where TRUCK_ID='"+item.getId()+"'   and createDate=(select  max(e.createDate) from  TruckLocationEntity e where  truckId='"+item.getId()+"') ";
			TruckLocationEntity entity= truckLocationService.singleResult(hql);
			if(entity!=null)
				item.setTruckLocation(entity);
		}
//		TagUtil.datagrid(response, dataGrid);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 * 删除truck
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TruckEntity truck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		truck = systemService.getEntity(TruckEntity.class, truck.getId());
		message = "truck删除成功";
		try{
			truckService.delete(truck);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "truck删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除truck
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "truck删除成功";
		try{
			for(String id:ids.split(",")){
				TruckEntity truck = systemService.getEntity(TruckEntity.class, 
				id
				);
				truckService.delete(truck);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "truck删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加truck
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TruckEntity truck,TruckLocationEntity entity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		truck.setCreateDate(new Date());
		message = "truck添加成功";
		try{
			Serializable id=	truckService.save(truck);
			if(id!=null)
			{
				truck.setId((String)id);
				j.setResult(1);
				j.setObj(truck);
//				TruckLocationEntity entity=new TruckLocationEntity();
				if(entity!=null&&entity.getDtid()!=null)
				{
					entity.setCreateDate(new Date());
					entity.setTruckId((String)id);
					truckLocationService.save(entity);
				}
			}else
				j.setResult(0);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "truck添加失败";
			j.setResult(0);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新truck
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TruckEntity truck, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "truck更新成功";
		TruckEntity t = truckService.get(TruckEntity.class, truck.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(truck, t);
			truckService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "truck更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * truck新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TruckEntity truck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truck.getId())) {
			truck = truckService.getEntity(TruckEntity.class, truck.getId());
			req.setAttribute("truckPage", truck);
		}
		return new ModelAndView("com/buss/giftbook/truck-add");
	}
	/**
	 * truck编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TruckEntity truck, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(truck.getId())) {
			truck = truckService.getEntity(TruckEntity.class, truck.getId());
			req.setAttribute("truckPage", truck);
		}
		return new ModelAndView("com/buss/giftbook/truck-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/buss/giftbook/truckUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(TruckEntity truck,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck";
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
			CriteriaQuery cq = new CriteriaQuery(TruckEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, truck, request.getParameterMap());
			
			List<TruckEntity> trucks = this.truckService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckEntity.class, trucks);
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
	public void exportXlsByT(TruckEntity truck,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "truck";
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
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("truck列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
					"导出信息"), TruckEntity.class, null);
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
				List<TruckEntity> listTruckEntitys = 
					(List<TruckEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TruckEntity.class,params);
				for (TruckEntity truck : listTruckEntitys) {
					truckService.save(truck);
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
