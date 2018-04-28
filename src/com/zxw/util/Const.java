package com.zxw.util;

import org.springframework.context.ApplicationContext;

/**
 * 
 * @类名: Constants.java
 * @描述: 项目名称配置文件
 * @创建时间: 2016年7月4日 下午5:33:30
 * @version V1.0
 */
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_WX_USER = "wx_user";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList"; // 当前菜单
	public static final String SESSION_allmenuList = "allmenuList"; // 全部菜单
	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";
	public static final String SESSION_USERROL = "USERROL"; // 用户对象
	public static final String SESSION_USERNAME = "USERNAME"; // 用户名
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String WX_WOLCOME= "admin/config/wx_wolcome.txt"; // 微信欢迎语
	public static final String SESSION_USER_DATA_PC = "userData"; // PC前端session用户
	
	/**
	 * 微信接口wkey键
	 */
	public static final String WECHAT_SECURITY_KEY = "wkey";
	
	/**
	 * 微信菜单，目前以文件形式，之后要用列表
	 */
	public static final String WX_MENU= "admin/config/wx_menu.txt"; // 微信菜单
	public static final String LOGIN = "/main/tologin"; // 登录地址
	public static final String SYSNAME = "admin/config/SYSNAME.txt"; // 系统名称路径
	public static final String PAGE = "admin/config/PAGE.txt"; // 分页条数配置路径
	public static final String EMAIL = "admin/config/EMAIL.txt"; // 邮箱服务器配置路径
	public static final String SMS1 = "admin/config/SMS1.txt"; // 短信账户配置路径1
	public static final String SMS2 = "admin/config/SMS2.txt"; // 短信账户配置路径2
	public static final String SMS= "admin/config/SMS999.txt"; // 短信账户配置路径
	/**
	 * wkey.properties文件路径
	 */
	public static final String WKEY_PROP_PATH = "wkey.properties";
	
	public static final String SETPWD= "admin/config/SETPWD.txt"; // 设置环信默认密码
	
	public static final String SMSCONTES= "admin/config/SMSCONTES.txt"; // 短信发送的内容
	
	public static final String ENCRYPT= "admin/config/ENCRYPT.txt"; // 加密文件
	public static final String FWATERM = "admin/config/FWATERM.txt"; // 文字水印配置路径
	public static final String IWATERM = "admin/config/IWATERM.txt"; // 图片水印配置路径
	public static final String WEIXIN = "admin/config/WEIXIN.txt"; // 微信配置路径
	public static final String WEBSOCKET = "admin/config/WEBSOCKET.txt";// WEBSOCKET配置路径
	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/"; // 图片上传路径
	public static final String AVATAR = "uploadFiles/avatar/"; // 移动端的头像上传目录
	public static final String UPLOAD = "uploadFiles/upload/"; // 移动端的头像上传目录
	public static final String FILEAPP = "uploadFiles/app/"; // app上传路径
	public static final String VIDEOPATH="uploadFiles/video/";	//视频上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/"; // 文件上传路径
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; // 二维码存放路径
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(send)|(code)|(app)|(wxapi)|(weixin)|(static)|(uploadFiles)|(page)|(resourse)|(plugins)|(main)|(cloudIndex)|(websocket)|(cloudAssist)|(cloudAdvantage)|(cloudRegLogin)|(cloudActivity)|(cloudData)|(cloudHonor)|(cloudNotice)|(videoCentre)|(cloudTourism)|(cloudVideo)|(home)|(file)|(mobile)|(wechat)).*"; // 不对匹配该值的访问路径拦截（正则）
	/**
	 * 用户头像上传路径
	 */
	public static final String FILEPATH_HEADIMG = "uploadFiles/userHeadImg/";
	/**导入Ecxcel表的临时目录*/
	public static final String excel = "uploadFiles/excel/";
	public static final String root = "uploadFiles";
	public static final String dir_excel = "excel";
	
	public static ApplicationContext WEB_APP_CONTEXT = null; // 该值会在web容器启动时由WebAppContextListener初始化

	/**
	 * APP Constants
	 */
	// app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[] {
			"countries", "uname", "passwd", "title", "full_name",
			"company_name", "countries_code", "area_code", "telephone",
			"mobile" };
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[] {
			"国籍", "邮箱帐号", "密码", "称谓", "名称", "公司名称", "国家编号", "区号", "电话", "手机号" };

	// app根据用户名获取会员信息接口_请求协议中的参数
	public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[] { "USERNAME" };
	public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[] { "用户名" };
	
	//大屏和app的redis的seturl
	public static final String SETURL = "http://10.25.159.147/redis/set";
	public static final String APPSETURL = "http://10.25.159.147/redis/setApp";
	//redis的geturl
	public static final String GETURL = "http://10.25.159.147/redis/get";
	//redis的存活时间
	public static final int SES = 3000;

}
