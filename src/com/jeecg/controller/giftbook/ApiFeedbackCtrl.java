package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.GifttypeEntity;
import com.jeecg.entity.giftbook.GroupmemberEntity;
import com.jeecg.entity.giftbook.SidekickergroupEntity;
import com.jeecg.service.giftbook.GifttypeServiceI;
import com.jeecg.service.giftbook.GroupmemberServiceI;
import com.jeecg.service.giftbook.SidekickergroupServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ApiAllTypeCtrl
 * @Description: TODO(意见反馈与关于)
 * @author 张相伟
 * @date 2016年11月8日 下午4:27:01
 */
@Controller
@RequestMapping("/apiFeedbackCtrl")
public class ApiFeedbackCtrl extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ApiGifttypeController.class);


	/**
	 *  意见反馈
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(params = "feedback")
	public ModelAndView feedback(HttpServletRequest request,
							   HttpServletResponse response) {
		return new ModelAndView("");
	}

	@RequestMapping(params = "about")
	@ResponseBody
	public Object about(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("");
	}

}
