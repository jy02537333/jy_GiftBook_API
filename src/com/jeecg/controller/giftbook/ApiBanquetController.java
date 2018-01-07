package com.jeecg.controller.giftbook;
import com.jeecg.entity.giftbook.FinancialSupermarketEntity;
import com.jeecg.entity.giftbook.InvitationEntity;
import com.jeecg.entity.giftbook.InvitationlistEntity;
import com.jeecg.service.giftbook.FinancialSupermarketServiceI;
import com.jeecg.service.giftbook.InvitationServiceI;
import com.jeecg.service.giftbook.InvitationlistServiceI;

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
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;

import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
 * @Description: 请帖详情
 * @author onlineGenerator
 * @date 2017-02-21 14:54:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiBCtrl")
public class ApiBanquetController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiBanquetController.class);

	@Autowired
	private InvitationServiceI invitationService;
	@Autowired
	private InvitationlistServiceI invitationListService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 婚宴信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String invitationId=request.getParameter("invitationListId");
		List< InvitationlistEntity> invitationlistEntity= invitationListService.findByProperty(
				InvitationlistEntity.class, "id", invitationId);
		if(invitationlistEntity!=null&&invitationlistEntity.size()>0)
		{
		List<InvitationEntity> invitationEntity=invitationService.findByProperty(
				InvitationEntity.class,"id", invitationlistEntity.get(0).getInvitationid());
		InvitationEntity entity=invitationEntity.get(0);
		modelAndView.addObject("invitationEntity", entity);
		modelAndView.addObject("invitationlistEntity", invitationlistEntity.get(0));
		}
		modelAndView.setViewName("com/jeecg/giftbook/api_banquet");
		return modelAndView;
	}
	
	@RequestMapping(params = "test")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("com/jeecg/giftbook/test/index");
		return modelAndView;
	}
	
}
