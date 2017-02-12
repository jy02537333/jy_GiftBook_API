package org.jeecgframework.core.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.hqlsearch.SysContextSqlConvert;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.JeecgDataAutorUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSDataRule;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.pojo.base.TSOperation;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * 接口与前端  权限拦截器
 * 
 * @author  张代浩
 * 
 */
public class ApiWebInterceptor implements HandlerInterceptor {
	 
	private static final Logger logger = Logger.getLogger(ApiWebInterceptor.class);
	private SystemService systemService;
	private List<String> excludeUrls;
	private static List<TSFunction> functionList;


	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		//logger.info("-----authInterceptor----requestPath------"+requestPath);
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if(client == null){ 
			client = ClientManager.getInstance().getClient(
					request.getParameter("sessionId"));
		}
		request.setAttribute("isInterceptor", "1");
		return true;
	}
	
	/**
	 * 判断用户是否有菜单访问权限
	 * @param request
	 * @return
	 */
	private boolean hasMenuAuth(HttpServletRequest request){
		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		// 是否是功能表中管理的url
		boolean bMgrUrl = false;
		if (functionList == null) {
//			functionList = systemService.loadAll(TSFunction.class);

			functionList = systemService.findHql("from TSFunction where functionType = ? ", (short)0);

		}
		for (TSFunction function : functionList) {
			if (function.getFunctionUrl() != null && function.getFunctionUrl().startsWith(requestPath)) {
				bMgrUrl = true;
				break;
			}
		}
		if (!bMgrUrl) {
			return true;
		}
		 
		String funcid=oConvertUtils.getString(request.getParameter("clickFunctionId"));
		if(!bMgrUrl && (requestPath.indexOf("loginController.do")!=-1||funcid.length()==0)){
			return true;
		} 
		TSUser currLoginUser = ClientManager.getInstance().getClient(ContextHolderUtils.getSession().getId()).getUser();
        String userid = currLoginUser.getId();
		//requestPath=requestPath.substring(0, requestPath.indexOf("?")+1);
		String sql = "SELECT DISTINCT f.id FROM t_s_function f,t_s_role_function  rf,t_s_role_user ru " +
					" WHERE f.id=rf.functionid AND rf.roleid=ru.roleid AND " +
					"ru.userid='"+userid+"' AND f.functionurl like '"+requestPath+"%'";
		List list = this.systemService.findListbySql(sql);
		if(list.size()==0){

            String orgId = currLoginUser.getCurrentDepart().getId();

            String functionOfOrgSql = "SELECT DISTINCT f.id from t_s_function f, t_s_role_function rf, t_s_role_org ro  " +
                    "WHERE f.ID=rf.functionid AND rf.roleid=ro.role_id " +
                    "AND ro.org_id='" +orgId+ "' AND f.functionurl like '"+requestPath+"%'";
            List functionOfOrgList = this.systemService.findListbySql(functionOfOrgSql);
			return functionOfOrgList.size() > 0;

        }else{
			return true;
		}
	}
	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {
		return new ModelAndView(new RedirectView("loginController.do?login"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("webpage/login/timeout.jsp").forward(request, response);
	}

}
