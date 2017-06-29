package com.jeecg.controller.giftbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import com.jeecg.entity.giftbook.VGroupAndMemberEntity;
import com.jeecg.service.giftbook.VGroupAndMemberServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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
	private VGroupAndMemberServiceI vGroupAndMemberServiceI;
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
	 */

	@RequestMapping(params = "getAll")
	@ResponseBody
	public Object getAll(HttpServletRequest request,
						 HttpServletResponse response, DataGrid dataGrid) {
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j = new AjaxJson();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String useridString = request.getParameter("userid");
			if (useridString != null) {
				VGroupAndMemberEntity vGroupAndMemberEntity=new VGroupAndMemberEntity();
				vGroupAndMemberEntity.setUserid(useridString);
				dataGrid.setField("userid,groupid,isdefault,groupmembersnum,groupname,createdate,id,groupmember,totalmoney,memberphone,affiliatedperson,affiliatedpersonid");
				CriteriaQuery cq = new CriteriaQuery(VGroupAndMemberEntity.class, dataGrid);
				//查询条件组装器
				org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vGroupAndMemberEntity, request.getParameterMap());
					//自定义追加查询条件
					cq.addOrder("groupid", SortDirection.asc);
					cq.addOrder("createdate",SortDirection.desc);
					cq.add();
					this.vGroupAndMemberServiceI.getDataGridReturn(cq, true);
					List<GroupmemberEntity> list=dataGrid.getResults();
				map.put("sidekickerGroups", list);
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


	@RequestMapping(params = "getdata11")
	@ResponseBody
	public Object getdata11(HttpServletRequest request,
							HttpServletResponse response)
	{
		String str=
		 "[{\"name\":\"name\",\"id\":\"1x\"},{\"name\":\"name1\",\"id\":\"1\"},{\"name\":\"name2\",\"id\":\"2\"},{\"name3\":\"name09090\",\"id\":\"090909\"},"
				+ "{\"name\":\"name4\",\"id\":\"4\"},{\"name\":\"name5\",\"id\":\"5\"},{\"name\":\"name666\",\"id\":\"666\"},{\"name\":\"name22\",\"id\":\"23232\"},{\"name\":\"name0909090\",\"id\":\"090909090909\"},"
				+ "{\"name\":\"name44\",\"id\":\"44\"},{\"name\":\"name555\",\"id\":\"555\"},{\"name\":\"name6666\",\"id\":\"6666\"},{\"name\":\"name22222\",\"id\":\"2323232\"},{\"name\":\"name090\",\"id\":\"090\"},"
				+ "{\"name\":\"name55\",\"id\":\"55\"},{\"name\":\"name5555\",\"id\":\"5555\"},{\"name\":\"name66666\",\"id\":\"666666\"},{\"name\":\"name223232\",\"id\":\"23232323232\"},{\"name\":\"name09090\",\"id\":\"0909090909\"},"
				+ "{\"name\":\"name66\",\"id\":\"66\"},{\"name\":\"name55555\",\"id\":\"55555\"},{\"name\":\"name66666\",\"id\":\"666666\"},{\"name\":\"name2223232\",\"id\":\"32323232323\"},{\"name\":\"name754765756g\",\"id\":\"f54f754f754f7e54f4efe7754\"}]";
		AjaxJson j = new AjaxJson();
		j.setResult(1);
		j.setMsg("fawefewa");
		j.setObj(str);
		return AjaxReturnTool.retJsonp(j, request,response);
	}
}
