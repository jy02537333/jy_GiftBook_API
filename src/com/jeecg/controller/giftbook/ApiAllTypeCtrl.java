package com.jeecg.controller.giftbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

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

import com.jeecg.entity.giftbook.GifttypeEntity;
import com.jeecg.entity.giftbook.GroupmemberEntity;
import com.jeecg.entity.giftbook.SidekickergroupEntity;
import com.jeecg.service.giftbook.GifttypeServiceI;
import com.jeecg.service.giftbook.GroupmemberServiceI;
import com.jeecg.service.giftbook.SidekickergroupServiceI;

/**
 * 
 * @ClassName: ApiAllTypeCtrl
 * @Description: TODO(获取所有的分类类型数据)
 * @author 张相伟
 * @date 2016年11月8日 下午4:27:01
 */
@Controller
@RequestMapping("/apiAllTypeCtrl")
public class ApiAllTypeCtrl extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ApiGifttypeController.class);

	@Autowired
	private GroupmemberServiceI groupmemberService;
	@Autowired
	private SidekickergroupServiceI sidekickergroupService;
	@Autowired
	private GifttypeServiceI gifttypeService;
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
	 * @param user
	 */

	@RequestMapping(params = "getAll")
	@ResponseBody
	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String useridString = request.getParameter("userid");
			if (useridString != null) {
				// map.put("groupmembers",
				// groupmemberService.findByProperty(GroupmemberEntity.class,
				// "createBy", useridString));
				if (request.getParameter("groupid") != null) {
					List<GroupmemberEntity> list = groupmemberService
							.findByQueryString("select id,groupmember from GroupmemberEntity where createBy='"
									+ useridString
									+ "'and gourpid='"
									+ request.getParameter("groupid") + "'");
					map.put("groupmembers", list);
				}

				map.put("sidekickerGroups", sidekickergroupService
						.findByProperty(SidekickergroupEntity.class, "userid",
								useridString));
				map.put("gifttypes", gifttypeService.findByProperty(
						GifttypeEntity.class, "userid", useridString));
			}
			j.setMap(map);
			j.setResult(1);
			j.setMsg("成功！");
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(params = "getGroupMember")
	@ResponseBody
	public Object getGroupMember(HttpServletRequest request,
			HttpServletResponse response) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String useridString = request.getParameter("userid");
			if (useridString != null) {
				// map.put("groupmembers",
				// groupmemberService.findByProperty(GroupmemberEntity.class,
				// "createBy", useridString));
				List<GroupmemberEntity> list = groupmemberService
						.findByQueryString("select id,groupmember from GroupmemberEntity where createBy='"
								+ useridString
								+ "'and gourpid='"
								+ request.getParameter("groupid") + "'");
				j.setVarList(list);
				j.setResult(1);
				j.setMsg("成功！");
			} else {
				j.setResult(0);
				j.setMsg("缺少参数！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
			j.setMsg("网络异常！");
		}

		return AjaxReturnTool.retJsonp(j, request,response);
	}

}
