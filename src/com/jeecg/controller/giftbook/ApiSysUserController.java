package com.jeecg.controller.giftbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxw.util.ComUtil;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.core.util.*;
import org.jeecgframework.core.util.base64.BASE64Decoder;
import org.jeecgframework.web.demo.entity.test.QueryCondition;
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
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.base64.HandlerRSAUtils;

import com.jeecg.entity.giftbook.LoginlogEntity;
import com.jeecg.entity.giftbook.SidekickergroupEntity;
import com.jeecg.entity.giftbook.SysUserEntity;
import com.jeecg.service.giftbook.LoginlogServiceI;
import com.jeecg.service.giftbook.SidekickergroupServiceI;
import com.jeecg.service.giftbook.SysUserServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Title: Controller
 * @Description: 用户信息表
 * @author zhangdaihao
 * @date 2016/11/4 14:19:13
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/apiSysUserCtrl")
public class ApiSysUserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ApiSysUserController.class);

	@Autowired
	private SysUserServiceI sysUserService;
	@Autowired
	private LoginlogServiceI loginlogService;
	@Autowired
	private SidekickergroupServiceI sidekickergroupService;
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
	public Object datagrid(SysUserEntity sysUser, HttpServletRequest request,
						   HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,userphone,portrait,username,loginname,useremail,provinceid,province,cityid,city,districtid,district,detailaddress,loginflag,qqopenid,wxopenid,sinaopenid,createDate");
		dataGrid.setSort("createDate");
		CriteriaQuery cq = new CriteriaQuery(SysUserEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				sysUser, request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sysUserService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(AjaxReturnTool.hanlderPage(dataGrid),
				request,response);
	}



	@RequestMapping(params = "login2")
	@ResponseBody
	public Object login2(@RequestParam(value = "info") String info,
						 SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		DataGrid dataGrid = new DataGrid();
		dataGrid.setField("id,userphone,portrait,username,loginname,useremail,provinceid,province,cityid,city,districtid,district,detailaddress,loginflag,qqopenid,wxopenid,sinaopenid");
		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("loginname", new String[] { "a111"});
//		map.put("loginpassword",
//				new String[] { "gagawe" });
		AjaxJson j = new AjaxJson();
		CriteriaQuery cq = new CriteriaQuery(SysUserEntity.class,
				dataGrid);
		// 查询条件组装器
		try{
			//自定义追加查询条件
//			sysUser.setLoginname("a111" );
//			sysUser.setLoginpassword("MTEx1" );
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
					.installHql(cq, sysUser, map);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sysUserService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}

	/**
	 * 登陆
	 *
	 * @return
	 */
	@RequestMapping(params = "login")
	@ResponseBody
	public Object login(@RequestParam(value = "info") String info,
						SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		String message = "登录信息异常";
		AjaxJson j = new AjaxJson();
		try {
			SysUserEntity signEntity = TokenVerifyTool.verifyLoginInfo(info);
			if (signEntity != null && signEntity.getLoginname() != null
					&& signEntity.getLoginname().equals(sysUser.getLoginname())) {
				DataGrid dataGrid = new DataGrid();
				dataGrid.setField("id,userphone,portrait,username,loginname,sex,loginpassword,useremail,provinceid,province,cityid,city,districtid,district,detailaddress,loginflag,qqopenid,wxopenid,sinaopenid");
				Map<String, String[]> map = new HashMap<String, String[]>();
				CriteriaQuery cq = new CriteriaQuery(SysUserEntity.class,
						dataGrid);
				// 查询条件组装器
//				sysUser.setLoginpassword(signEntity.getLoginpassword().trim());
				org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
						.installHql(cq, sysUser, map);
				cq.add();
				this.sysUserService.getDataGridReturn(cq, true);
				if (dataGrid.getResults() != null
						&& dataGrid.getResults().size()>0) {
					SysUserEntity retEntity = (SysUserEntity) dataGrid
							.getResults().get(0);
					if(retEntity.getLoginpassword().equals(signEntity.getLoginpassword()))
					{
						retEntity=getSignificanceProperty(signEntity,retEntity);
						retEntity.setLoginpassword("");
						String token =saveLoginInfo(retEntity);
						Map<String, Object> retMap = new HashMap<String, Object>();
						retMap.put("token", token);
						retMap.put("obj", retEntity);
						j.setMap(retMap);
						j.setResult(1);
						message = "登录成功";
					}else
					{
						j.setResult(0);
						message = "帐号或者密码不正确";
					}
				} else {
					j.setResult(0);
					message = "帐号或者密码不正确";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "登录信息异常";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return  AjaxReturnTool.retJsonp(j, request,response);
	}

	public void querySidekickergroupExisting(String userid)
	{
		SidekickergroupEntity entity=(SidekickergroupEntity)sidekickergroupService.findUniqueByProperty(
				SidekickergroupEntity.class
				, "userid", userid);
		if(entity==null)
		{
			entity=new SidekickergroupEntity();
			entity.setIsDefault(1);
			entity.setGroupmembersnum(0);
			entity.setGroupname("亲戚");
			entity.setUserid(userid);
			try {
				sidekickergroupService.save(entity);
				entity=new SidekickergroupEntity();
				entity.setIsDefault(1);
				entity.setGroupmembersnum(0);
				entity.setGroupname("py");
				entity.setUserid(userid);
				sidekickergroupService.save(entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除用户
	 *
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request)) {
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		sysUser = systemService.getEntity(SysUserEntity.class, sysUser.getId());
		message = "用户删除成功";
		try {
			sysUserService.delete(sysUser);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 批量删除用户
	 *
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public Object doBatchDel(String ids, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户删除成功";
		try {
			for (String id : ids.split(",")) {
				SysUserEntity sysUser = systemService.getEntity(
						SysUserEntity.class, id);
				sysUserService.delete(sysUser);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(@RequestParam(value = "info") String info,SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注册成功";
		try {
			SysUserEntity signEntity = TokenVerifyTool.verifyLoginInfo(info);
			String code=SmsSendCtrl.codeMap.get(signEntity.getLoginname());
			if(code==null||code.trim().length()==0||code.equals(ComUtil.getParam(request,"code")))
			{
				j.setResult(5);
				j.setMsg("验证码不正确！");
				return AjaxReturnTool.retJsonp(j, request,response);
			}
			signEntity.setUserphone(signEntity.getLoginname());
			signEntity.setSex(0);
			signEntity.setLoginflag(1);
			Serializable obj = sysUserService.save(signEntity);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
			if (obj == null)
				j.setResult(0);
			else {
				signEntity.setLoginpassword("");
				String token = saveLoginInfo(signEntity);
				Map<String, Object> retMap = new HashMap<String, Object>();
				retMap.put("token", token);
				retMap.put("obj", signEntity);
				j.setMap(retMap);
				j.setResult(1);
				message = "登录成功";
				SmsSendCtrl.codeMap.remove(signEntity.getLoginname());
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "注册失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 修改密码
	 *
	 * @return
	 */
	@RequestMapping(params = "editPwd")
	@ResponseBody
	public Object editPwd(SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		SysUserEntity signEntity = TokenVerifyTool.verifyLoginInfo(request.getParameter("info"));
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "密码修改成功！";
		int ret=1;
		SysUserEntity user=sysUserService.findUniqueByProperty(SysUserEntity.class,"loginname",signEntity.getLoginname());
		if(user.getLoginpassword().equals(signEntity.getOldPwd()))
		{
			try {
				String newPwd=signEntity.getLoginpassword();//记录新密码
				MyBeanUtils.copyBeanNotNull2Bean(user, signEntity);//将新user的空信息补全
				signEntity.setLoginpassword(newPwd);
//				sysUserService.saveOrUpdate(signEntity);
				String pwd=StringUtil.decodeSpecialCharsWhenLikeUseBackslash( signEntity.getLoginpassword() );//去除特殊字符
				 ret=sysUserService.updateBySqlString("update sys_user set loginpassword='"+pwd+"' where id='"+signEntity.getId()+"' ");
//				sysUser=getSignificanceProperty(signEntity,sysUser);
				signEntity.setLoginpassword("");
				if(ret>0) {
					String token = saveLoginInfo(signEntity);
					Map<String, Object> retMap = new HashMap<String, Object>();
					retMap.put("token", token);
					retMap.put("obj", signEntity);
					j.setMap(retMap);
					ret=1;
					j.setResult(1);
				}

			} catch (Exception e) {
				ret=2;
				message="修改密码出异常！";
				e.printStackTrace();
			}
		}else
		{
			ret=4;
			message = "密码或者帐号不不正确！";
		}
		j.setMsg(message);
		j.setResult(ret);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 更新用户
	 *
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(SysUserEntity sysUser, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户更新成功";
		SysUserEntity t =sysUserService.get(SysUserEntity.class,
				sysUser.getId());
		try {
			SysUserEntity tokenUser= TokenVerifyTool.getUser(request);
			MyBeanUtils.copyBeanNotNull2Bean(sysUser, t);
			sysUserService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
			t=getSignificanceProperty(tokenUser,t);
			t.setLoginpassword("");
			String token =saveLoginInfo(t);
			Map<String, Object> retMap = new HashMap<String, Object>();
			retMap.put("token", token);
			retMap.put("obj", t);
			j.setMap(retMap);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户更新失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object get(@PathVariable("id") String id, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();
		SysUserEntity task = sysUserService.get(SysUserEntity.class, id);
		if (task == null) {
			j.setResult(2);
		} else {
			j.setObj(task);
			j.setResult(1);
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object create(@RequestBody SysUserEntity sysUser,
						 UriComponentsBuilder uriBuilder, HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SysUserEntity>> failures = validator
				.validate(sysUser);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		// 保存
		try {
			sysUserService.save(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = sysUser.getId();

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody SysUserEntity sysUser) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<SysUserEntity>> failures = validator
				.validate(sysUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(
					BeanValidators.extractPropertyAndMessage(failures),
					HttpStatus.BAD_REQUEST);
		}

		// 保存
		try {
			sysUserService.saveOrUpdate(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(params = "delete", value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") String id,
						 HttpServletRequest request,HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson json = new AjaxJson();
		try {
			sysUserService.deleteEntityById(SysUserEntity.class, id);
			json.setResult(1);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(3);
			json.setMsg("删除发生异常！");
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}

	/**
	 * 保存登录信息
	 */
	private String saveLoginInfo(SysUserEntity signEntity)
	{
		try {
			String  token=HandlerRSAUtils.encode(signEntity
					.toSignString(signEntity.getTimestamp(),
							signEntity.getDecvices()) );
//			byte[] bytes=new BASE64Decoder().decodeBuffer(token);
//			String entity=new String(bytes);
//			SysUserEntity user=	JSONHelper.fromJsonToObject(entity, SysUserEntity.class);
//			if(signEntity.getId().equals(user.getId()))
//			{
//
//			}
			LoginlogEntity loginlogEntity = (LoginlogEntity) loginlogService
					.findUniqueByProperty(LoginlogEntity.class,
							"userid", signEntity.getId());
			if (loginlogEntity == null) {
				loginlogEntity = new LoginlogEntity();
				loginlogEntity.setDevice(signEntity.getDecvices());
				loginlogEntity.setLogindate(DateUtils.getDate());
				loginlogEntity.setUserid(signEntity.getId());
				querySidekickergroupExisting(signEntity.getId());
			} else {
				loginlogEntity.setLastlogindate(loginlogEntity
						.getLogindate());
			}
			loginlogEntity.setLogintoken(token);
			loginlogService.saveOrUpdate(loginlogEntity);
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SysUserEntity getSignificanceProperty(SysUserEntity requestInfoUser,SysUserEntity sqlUser)
	{
		sqlUser.setDecvices(requestInfoUser.getDecvices());
		sqlUser.setTimestamp(requestInfoUser.getTimestamp());
		return sqlUser;
	}


}
