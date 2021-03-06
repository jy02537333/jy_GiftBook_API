package org.jeecgframework.web.cgform.controller.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.entity.config.CgFormHeadEntity;
import org.jeecgframework.web.cgform.service.autolist.CgTableServiceI;
import org.jeecgframework.web.cgform.service.build.DataBaseService;
import com.jeecg.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.cgform.util.SignatureUtil;
import org.jeecgframework.web.cgform.util.TableJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cgFormDataController")
public class CgFormDataController {
	@Autowired
	private DataBaseService dataBaseService;
	@Autowired
	private CgTableServiceI cgTableService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	/**
	 * 签名密钥key
	 */
	private static final String SIGN_KEY = "26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";
	
	/**
	 * online表单对外接口：getFormInfo 获取表单数据
	 * 注意： 
	 * @return
	 */
	@RequestMapping(params = "getFormInfo")
	@ResponseBody
	public TableJson getFormInfo(String tableName,
								 String id, 
								 String sign, 
								 HttpServletRequest request,HttpServletResponse response) {
		TableJson j = new TableJson();
		try {
			//参数校验
			if(StringUtil.isEmpty(tableName)){
				throw new BusinessException("tableName不能为空");
			}
			if(StringUtil.isEmpty(id)){
				throw new BusinessException("id不能为空");
			}
			if(StringUtil.isEmpty(sign)){
				throw new BusinessException("sign不能为空");
			}
			//签名验证
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("tableName", tableName);
			paramMap.put("id", id);
			paramMap.put("method", "getFormInfo");
			if(!SignatureUtil.checkSign(paramMap, SIGN_KEY, sign)){
				throw new BusinessException("签名验证失败");
			}
			//校验该表是否是online表单
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if(head==null){
				throw new BusinessException("该表单不是online表单");
			}
			
			if(head.getJformType()==1){
				//单表
				j.setTableType(head.getJformType());
				Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
				j.setTableData(dataForm);
			}else if(head.getJformType()==2){
				//主表
				j.setTableType(head.getJformType());
				Map<String, Object> mainForm = dataBaseService.findOneForJdbc(tableName, id);
				j.setTableData(mainForm);
				Map<String, Object> tableData  = new HashMap<String, Object>();
				String subTableStr = head.getSubTableStr();
		    	if(StringUtils.isNotEmpty(subTableStr)){
		    		 String [] subTables = subTableStr.split(",");
		    		 List<Map<String,Object>> subTableData = new ArrayList<Map<String,Object>>();
		    		 for(String subTable:subTables){
			    			subTableData = cgFormFieldService.getSubTableData(tableName,subTable,id);
			    			tableData.put(subTable, subTableData);
		    		 }
		    	}
		    	j.setSubTableDate(tableData);
			}else{
				throw new BusinessException("不支持该类型的表单的操作");
			}
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	/**
	 * online表单对外接口：deleteFormInfo 删除表单数据
	 * 注意： 
	 * @return
	 */
	@RequestMapping(params = "deleteFormInfo")
	@ResponseBody
	public TableJson deleteFormInfo(String tableName,
									String id, 
									String sign, 
									HttpServletRequest request,HttpServletResponse response) {
		TableJson j = new TableJson();
		try {
			//参数校验
			if(StringUtil.isEmpty(tableName)){
				throw new BusinessException("tableName不能为空");
			}
			if(StringUtil.isEmpty(id)){
				throw new BusinessException("id不能为空");
			}
			if(StringUtil.isEmpty(sign)){
				throw new BusinessException("sign不能为空");
			}
			//签名验证
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("tableName", tableName);
			paramMap.put("id", id);
			paramMap.put("method", "deleteFormInfo");
			if(!SignatureUtil.checkSign(paramMap, SIGN_KEY, sign)){
				throw new BusinessException("签名验证失败");
			}
			//校验该表是否是online表单
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if(head==null){
				throw new BusinessException("该表单不是online表单");
			}
			if(head.getJformType()!=1&&head.getJformType()!=2){
				throw new BusinessException("不支持该类型的表单的操作");
			}
	        cgTableService.delete(tableName, id);
	        j.setMsg("删除成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}
	
	
	/**
	 * online表单对外接口：addFormInfo 新增表单数据
	 * 注意： 
	 * @return
	 */
	@RequestMapping(params = "addFormInfo")
	@ResponseBody
	public TableJson addFormInfo(String tableName,
								 String id,
								 String data,
								 String sign,
								 HttpServletRequest request,HttpServletResponse response) {
		TableJson j = new TableJson();
		try {
			//参数校验
			if(StringUtil.isEmpty(tableName)){
				throw new BusinessException("tableName不能为空");
			}
			if(StringUtil.isEmpty(id)){
				throw new BusinessException("id不能为空");
			}
			if(StringUtil.isEmpty(data)){
				throw new BusinessException("data不能为空");
			}
			if(StringUtil.isEmpty(sign)){
				throw new BusinessException("sign不能为空");
			}
			//签名验证
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("tableName", tableName);
			paramMap.put("id", id);
			paramMap.put("data", data);
			paramMap.put("method", "addFormInfo");
			if(!SignatureUtil.checkSign(paramMap, SIGN_KEY, sign)){
				throw new BusinessException("签名验证失败");
			}
			//校验该表是否是online表单
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if(head==null){
				throw new BusinessException("该表单不是online表单");
			}
			if(head.getJformType()!=1&&head.getJformType()!=2){
				throw new BusinessException("不支持该类型的表单的操作");
			}
			Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
			if(dataForm!=null){
				throw new BusinessException("表单数据已存在");
			}
			if(head.getJformType()==1){
				Map<String, Object> formData;
				try {
					formData = new HashMap<String, Object>();
					formData = JSONHelper.json2Map(data);
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
		    	formData.put("id", id);
		    	dataBaseService.insertTable(tableName, formData);
			}else if(head.getJformType()==2){
				Map<String, List<Map<String, Object>>> formData;
				try {
					formData = new HashMap<String, List<Map<String,Object>>>();
					formData = JSONHelper.json2MapList(data);
					List<Map<String,Object>> list = formData.get(tableName);
					if(list==null||list.size()<=0){
						throw new BusinessException("主表数据异常");
					}
					Map<String,Object> mainMap = list.get(0);
					if(mainMap.get("id")==null||"".equals((String)mainMap.get("id"))){
						throw new BusinessException("主表数据缺少id");
					}
					if(!id.equals((String)mainMap.get("id"))){
						throw new BusinessException("id与主表id不一致");
					}
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
//				Map<String,List<Map<String,Object>>> mapMore =CommUtils.mapConvertMore(formData, tableName);
				dataBaseService.insertTableMore(formData, tableName);
			}
	        j.setMsg("新增表单数据成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		
		return j;
	}
	
	
	/**
	 * online表单对外接口：updateFormInfo 更新表单数据
	 * 注意： 
	 * @return
	 */
	@RequestMapping(params = "updateFormInfo")
	@ResponseBody
	public TableJson updateFormInfo(String tableName,
									String id,
									String data,
									String sign,
									HttpServletRequest request,HttpServletResponse response) {
		TableJson j = new TableJson();
		try {
			//参数校验
			if(StringUtil.isEmpty(tableName)){
				throw new BusinessException("tableName不能为空");
			}
			if(StringUtil.isEmpty(id)){
				throw new BusinessException("id不能为空");
			}
			if(StringUtil.isEmpty(data)){
				throw new BusinessException("data不能为空");
			}
			if(StringUtil.isEmpty(sign)){
				throw new BusinessException("sign不能为空");
			}
			//签名验证
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("tableName", tableName);
			paramMap.put("id", id);
			paramMap.put("data", data);
			paramMap.put("method", "updateFormInfo");
			if(!SignatureUtil.checkSign(paramMap, SIGN_KEY, sign)){
				throw new BusinessException("签名验证失败");
			}
			//校验该表是否是online表单
			CgFormHeadEntity head = cgFormFieldService.getCgFormHeadByTableName(tableName);
			if(head==null){
				throw new BusinessException("该表单不是online表单");
			}
			if(head.getJformType()!=1&&head.getJformType()!=2){
				throw new BusinessException("不支持该类型的表单的操作");
			}
			Map<String, Object> dataForm = dataBaseService.findOneForJdbc(tableName, id);
			if(dataForm==null){
				throw new BusinessException("表单数据不存在");
			}
			if(head.getJformType()==1){
				Map<String, Object> formData;
				try {
					formData = new HashMap<String, Object>();
					formData = JSONHelper.json2Map(data);
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
		    	dataBaseService.updateTable(tableName,id, formData);
			}else if(head.getJformType()==2){
				Map<String, List<Map<String, Object>>> formData;
				try {
					formData = new HashMap<String, List<Map<String,Object>>>();
					formData = JSONHelper.json2MapList(data);
					List<Map<String,Object>> list = formData.get(tableName);
					if(list==null||list.size()<=0){
						throw new BusinessException("主表数据异常");
					}
					Map<String,Object> mainMap = list.get(0);
					if(mainMap.get("id")==null||"".equals((String)mainMap.get("id"))){
						throw new BusinessException("主表数据缺少id");
					}
					if(!id.equals((String)mainMap.get("id"))){
						throw new BusinessException("id与主表id不一致");
					}
				} catch (Exception e) {
					throw new BusinessException("json解析异常");
				}
//				Map<String,List<Map<String,Object>>> mapMore =CommUtils.mapConvertMore(formData, tableName);
				dataBaseService.updateTableMore(formData, tableName);
			}
	        j.setMsg("更新表单数据成功");
		} catch (BusinessException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("系统异常");
		}
		return j;
	}

	

}
