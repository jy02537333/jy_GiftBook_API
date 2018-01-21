package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.TruckEntity;
import com.jeecg.service.giftbook.TruckServiceI;
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
@RequestMapping("/apiWxIndexController")
public class ApiWxIndexController extends BaseController {



	/**
	 * truck列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "truck")
	public ModelAndView truck(HttpServletRequest request) {
		return new ModelAndView("weixin/index");
	}

}
