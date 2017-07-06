
package com.jeecg.controller.giftbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxw.util.ComUtil;
import com.zxw.util.JsonEqualSymbolConvertJson;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;








import com.jeecg.entity.giftbook.MembergiftmoneyEntity;
import com.jeecg.service.giftbook.MembergiftmoneyServiceI;




import com.thoughtworks.xstream.mapper.Mapper.Null;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.Serializable;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;


/**   
 * @Title: Controller
 * @Description: 成员来往金额
 * @author zhangdaihao
 * @date 2016/11/4 14:09:57
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiMembergiftmoneyCtrl")
public class ApiMembergiftmoneyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiMembergiftmoneyController.class);

	@Autowired
	private MembergiftmoneyServiceI membergiftmoneyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(MembergiftmoneyEntity membergiftmoney,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,gourpmemberid,groupmember,isexpenditure,money,expendituretype,expendituretypename,correlativeinvitation,createDate");
		CriteriaQuery cq = new CriteriaQuery(MembergiftmoneyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, membergiftmoney, request.getParameterMap());
		try{
			//自定义追加查询条件
			String correlativeinvitatioStr=	membergiftmoney.getCorrelativeinvitation();
			if(correlativeinvitatioStr!=null)
			{
				cq.eq("correlativeinvitation", correlativeinvitatioStr);
			}
			Integer isexpenditure=	membergiftmoney.getIsexpenditure();
			if(isexpenditure!=null)
			{
				cq.eq("isexpenditure", isexpenditure);
			}
			String expendituretype=	membergiftmoney.getExpendituretype();
			if(expendituretype!=null)
			{
				cq.eq("expendituretype", expendituretype);
			}
			cq.eq("YEAR(createDate)",request.getParameter("year"));
			cq.addOrder("createDate", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} 
		
		cq.add();
		this.membergiftmoneyService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}


	@RequestMapping(params = "getList")
	@ResponseBody
	public Object getList(HttpServletRequest request, HttpServletResponse response)
	{
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		String correlativeinvitatioStr=	request.getParameter("correlativeinvitatio");
		StringBuffer whereStr=new StringBuffer();
		Map<String ,Object> kv=new TreeMap();
		if(correlativeinvitatioStr!=null)
		{
			whereStr.append(" and correlativeinvitation=:correlativeinvitation");
			kv.put("correlativeinvitation", ComUtil.clearSqlParam(correlativeinvitatioStr));
		}
		Integer isexpenditure=	request.getParameter("isexpenditure")==null?null:
				Integer.parseInt( request.getParameter("isexpenditure").toString());
		if(isexpenditure!=null)
		{
			whereStr.append(" and isexpenditure=:isexpenditure");
			kv.put("isexpenditure",isexpenditure);
		}
		String expendituretype=	request.getParameter("expendituretype");
		if(expendituretype!=null)
		{
			whereStr.append(" and expendituretype=:expendituretype");
			kv.put("expendituretype",ComUtil.clearSqlParam(expendituretype) );
		}
		String year=	request.getParameter("year");
		if(year!=null&&!year.equals("0"))
		{
			whereStr.append(" and year(createDate)=:year");
			kv.put("year",Integer.parseInt(year) );
		}
		String month=	request.getParameter("month");
		if(month!=null&&!month.equals("0"))
		{
			whereStr.append(" and month(createDate)=:month");
			kv.put("month",Integer.parseInt(month) );
		}
		whereStr.append(" and createBy=:createBy");
		kv.put("createBy",request.getParameter("createBy") );

		String getCount=	request.getParameter("getCount");
		if(!StringUtil.isEmpty(getCount))
		{
			String countHql="select sum(money) from MembergiftmoneyEntity  where 1=1 "+whereStr+" ";
			 List<Object> sumList=this.membergiftmoneyService.findHQLQuery(countHql,kv,null,null);
			 if(sumList!=null&&sumList.get(0)==null)
			 {
				 j.setSumCount(0);
			 }else
			 if(sumList!=null&&sumList.size()>0)
			 	j.setSumCount(Double.parseDouble( sumList.get(0).toString()) );
		}


		Integer page=	request.getParameter("page")==null?null:
				Integer.parseInt( request.getParameter("page").toString());
		Integer count=	request.getParameter("getCount")==null?null:
				Integer.parseInt( request.getParameter("getCount").toString());

		List< MembergiftmoneyEntity> list= null;
		try {
			String hql= //"select id,gourpmemberid,groupmember,isexpenditure,money,expendituretype,expendituretypename,correlativeinvitation,createDate" +
					" from MembergiftmoneyEntity where 1=1 "+whereStr+" order by  createDate desc ";
			list = this.membergiftmoneyService.findHQLQuery(hql,kv,page,count);
			if(list==null||list.size()==0)
			{
				j.setResult(2);
			}else
			{
				j.setResult(1);
				j.setVarList(list);
			}
		} catch (Exception e) {
			j.setResult(3);
			e.printStackTrace();
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 删除礼金记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(MembergiftmoneyEntity membergiftmoney, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
		{
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		membergiftmoney = systemService.getEntity(MembergiftmoneyEntity.class, membergiftmoney.getId());
		message = "礼金类型删除成功";
		try{
			membergiftmoneyService.delete(membergiftmoney);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
	    return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 批量删除礼金记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public Object doBatchDel(String ids,HttpServletRequest request,HttpServletResponse response){
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金记录删除成功";
		try{
			for(String id:ids.split(",")){
				MembergiftmoneyEntity membergiftmoney = systemService.getEntity(MembergiftmoneyEntity.class, 
						id
						);
				membergiftmoneyService.delete(membergiftmoney);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金记录删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	/**
	 * 添加礼金记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(MembergiftmoneyEntity membergiftmoney, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		membergiftmoney.setCreateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金记录添加成功";
		try{
			membergiftmoney.setState(1);
		Serializable  obj=	membergiftmoneyService.save(membergiftmoney);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			if(obj==null)
				j.setResult(0);
			else
				j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金记录添加失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 更新礼金记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(MembergiftmoneyEntity membergiftmoney, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		membergiftmoney.setUpdateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金记录更新成功";
		MembergiftmoneyEntity t = membergiftmoneyService.get(MembergiftmoneyEntity.class, membergiftmoney.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(membergiftmoney, t);
			membergiftmoneyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "礼金记录更新失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	


	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object get(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		MembergiftmoneyEntity task = membergiftmoneyService.get(MembergiftmoneyEntity.class, id);
		if (task == null) {
			j.setResult(2);
		}
		else {
			j.setObj(task);
			j.setResult(1);
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object create(@RequestBody MembergiftmoneyEntity membergiftmoney, UriComponentsBuilder uriBuilder
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MembergiftmoneyEntity>> failures = validator.validate(membergiftmoney);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		//保存
		try{
			membergiftmoneyService.save(membergiftmoney);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = membergiftmoney.getId();

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody MembergiftmoneyEntity membergiftmoney) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MembergiftmoneyEntity>> failures = validator.validate(membergiftmoney);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			membergiftmoneyService.saveOrUpdate(membergiftmoney);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(params = "delete",value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") String id
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson json=new AjaxJson();
		try {
			membergiftmoneyService.deleteEntityById(MembergiftmoneyEntity.class, id);
			json.setResult(1);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(3);
			json.setMsg("删除发生异常！");
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}

//
//	public static  String colltionString (Meteor meteor,String Conllection){
//		Collection collection = meteor.getDatabase().getCollection(Conllection);
//		String [] ids = collection.getDocumentIds();
//		StringBuffer sbJson = new StringBuffer();
//		sbJson.append("[");
//		for (int i=0;i<ids.length;i++){
//			sbJson.append("{");
//			Document document = collection.getDocument(ids[i]);
//			String [] fielNames = document.getFieldNames();
//			for (int j=0;j<fielNames.length;j++){
//				Object object = document.getField(fielNames[j]);
//				String obj=String.valueOf(object);
//				sbJson.append("\""+fielNames[j]+"\":\""+obj+"\"");
//				if (j+1<fielNames.length){
//					sbJson.append(",");
//				}
//			}
//			sbJson.append("}");
//			if(i+1<ids.length){
//				sbJson.append(",");
//			}
//		}
//		sbJson.append("]");
//		return  sbJson.toString();
//	}

	public static String handlerjson(String str)
	{
		StringBuffer sb=new StringBuffer();
		String comma=str.trim().substring(0,1);
		if(comma.equals("["))
		{
			String[] arrays=str.trim().substring(1).split("}");
			for (int i = 0; i <arrays.length ; i++) {
				String itemStr=null;
				if(i>0)
				{
					itemStr=arrays[i].substring(1);
				}else
					itemStr=arrays[i];
				if(i+1<arrays.length)
				{
					sb.append( handlerjson(itemStr+"}") ).append(",");
				}else
				{
					sb.append( handlerjson(itemStr+"}") );
				}

			}
			sb.insert(0,"[");
			sb.append("]");
			return sb.toString();
		}else
		{
			StringBuffer jsonSB=new StringBuffer();
			StringBuffer oldSb=new StringBuffer(str.substring(1,str.length()-1)  );
			sb.append( getJson(oldSb,jsonSB) );
			sb.insert(0,"{");
			sb.append("}");
			return sb.toString();
		}

	}


	Map<String,Object> jsonMap=new HashMap<>();
	public static String getJson(StringBuffer oldSb,StringBuffer jsonSb)
	{

		boolean isObj=false;
		int elIndex=oldSb.indexOf("=");
		int commaIndex=oldSb.indexOf(",");
		String ss=oldSb.substring(0,elIndex);
		String val=null;
		val=oldSb.substring(elIndex+1).trim();
		if(val.trim().length()==0)
			val="null";
		String bracketStr=val.substring(0,1);
		if(bracketStr.equals("[")||bracketStr.equals("{"))
		{
			isObj=true;
			if(val.indexOf("[")>-1)
			{
				commaIndex=oldSb.indexOf("]")+1;
				val=val.substring(0,val.indexOf("]"));
			}
			else if(val.indexOf("{")>-1)
			{
				commaIndex=oldSb.indexOf("}");
				val=val.substring(0,val.indexOf("}"));
			}
			val=handlerjson(val);
		}
		else if(commaIndex==0)
		{
			val="";
		}
		else if(commaIndex==-1)
		{
			val=oldSb.substring(elIndex+1);
		}else{
			val=oldSb.substring(elIndex+1,commaIndex);
		}

		String newStr=oldSb.substring(commaIndex+1);
		ss=ss.trim();
		if(isObj){
			jsonSb.append("\""+ss+"\":"+val);
		}else
		if(val.equals("null"))
			jsonSb.append("\""+ss+"\":null");
		else if(val.toLowerCase().equals("true")||val.toLowerCase().equals("false"))
			jsonSb.append("\""+ss+"\":"+val);
		else
			jsonSb.append("\""+ss+"\":\""+val+"\"");
		if(commaIndex>-1)
		{
			jsonSb.append(",");
		}
		if(newStr.indexOf("=")>0&&commaIndex!=-1)
		{
			oldSb=new StringBuffer(newStr);
			return 	getJson(oldSb,jsonSb);
		}
		return jsonSb.toString();
	}

	public static void main(String[] args) {
		String str="{name=我的好友, order=0, friends=[{friend_id=593f4eb4c9eb613015000003, remark_name=null, avatar=static/image/yjjy7TXCfd6631fSKXYz1498634140.png, nickname=超哥, phone=18785880765, description=},{friend_id=593f4eb4c9eb613015000001, remark_name=null, avatar=static/image/yjjy7TXCfd6631fSKXYz1498634140.png, nickname=超哥1, phone=18785880765, description=}], is_system=true}";

		System.out.print(JsonEqualSymbolConvertJson.handlerjson(str).toString());
	}

}




     





































