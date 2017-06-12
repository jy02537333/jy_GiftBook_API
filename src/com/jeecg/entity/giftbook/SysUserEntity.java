package com.jeecg.entity.giftbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Title: Entity
 * @Description: 用户
 * @author onlineGenerator
 * @date 2016-11-04 13:51:00
 * @version V1.0
 * 
 */
@Entity
@Table(name = "sys_user", schema = "")
@SuppressWarnings("serial")
public class SysUserEntity implements java.io.Serializable {
	/** 自动编号 */
	private java.lang.String id;
	/** 手机号码 */
	@Excel(name = "手机号码")
	private java.lang.String userphone;
	/** 性别1=男，2=女，0=未知 */
	@Excel(name = "性别1=男，2=女，0=未知")
	private java.lang.Integer sex;
	/** 用户头像 */
	@Excel(name = "用户头像")
	private java.lang.String portrait;
	/** 用户头像 */
	@Excel(name = "用户头像缩略图")
	private java.lang.String portraitThumbnail;
	/** 真实姓名 */
	@Excel(name = "真实姓名")
	private java.lang.String username;
	/** 登录账号 */
	@Excel(name = "登录账号")
	private java.lang.String loginname;
	/** 登录密码 */
	@Excel(name = "登录密码")
	private java.lang.String loginpassword;
	private String oldPwd;
	/** 电子邮箱 */
	@Excel(name = "电子邮箱")
	private java.lang.String useremail;
	/** 所属省Id */
	@Excel(name = "所属省Id")
	private java.lang.Integer provinceid;
	/** 所属省 */
	@Excel(name = "所属省")
	private java.lang.String province;
	/** 所属市Id */
	@Excel(name = "所属市Id")
	private java.lang.Integer cityid;
	/** 所属市 */
	@Excel(name = "所属市")
	private java.lang.String city;
	/** 所属区/县Id */
	@Excel(name = "所属区/县Id")
	private java.lang.Integer districtid;
	/** 所属区/县 */
	@Excel(name = "所属区/县")
	private java.lang.String district;
	/** 详细地址 */
	@Excel(name = "详细地址")
	private java.lang.String detailaddress;
	/** 使用状态(1启用2停用） */
	@Excel(name = "使用状态(1启用2停用）")
	private java.lang.Integer loginflag;
	/** qqopenid */
	@Excel(name = "qqopenid")
	private java.lang.String qqopenid;
	/** wxopenid */
	@Excel(name = "wxopenid")
	private java.lang.String wxopenid;
	/** sinaopenid */
	@Excel(name = "sinaopenid")
	private java.lang.String sinaopenid;
	/** 创建时间 */
	@Excel(name = "创建时间", format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/** 创建人编号 */
	@Excel(name = "创建人编号")
	private java.lang.String createBy;
	/** 创建人姓名 */
	@Excel(name = "创建人姓名")
	private java.lang.String createName;
	/** 更新时间 */
	@Excel(name = "更新时间", format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/** 更新人编号 */
	@Excel(name = "更新人编号")
	private java.lang.String updateBy;
	/** 更信任姓名 */
	@Excel(name = "更信任姓名")
	private java.lang.String updateName;
	private String timestamp;
	private String decvices;

	@Transient
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Transient
	public String getDecvices() {
		return decvices;
	}

	public void setDecvices(String decvices) {
		this.decvices = decvices;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 自动编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = true, length = 32)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 自动编号
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 性别1=男，2=女，0=未知
	 * 
	 * @return: java.lang.Integer 自动编号
	 */
	@Column(name = "Sex", nullable = true, length = 10)
	public java.lang.Integer getSex() {
		return this.sex;
	}

	/**
	 * 方法: 性别1=男，2=女，0=未知
	 * 
	 * @param: java.lang.Integer 自动编号
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 手机号码
	 */
	@Column(name = "USERPHONE", nullable = true, length = 32)
	public java.lang.String getUserphone() {
		return this.userphone;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 手机号码
	 */
	public void setUserphone(java.lang.String userphone) {
		this.userphone = userphone;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 用户头像
	 */
	@Column(name = "PORTRAIT", nullable = true, length = 255)
	public java.lang.String getPortrait() {
		return this.portrait;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 用户头像
	 */
	public void setPortrait(java.lang.String portrait) {
		this.portrait = portrait;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 用户头像
	 */
	@Transient
	public java.lang.String getPortraitThumbnail() {
		return this.portraitThumbnail;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 用户头像
	 */
	public void setPortraitThumbnail(java.lang.String portraitThumbnail) {
		this.portrait = portraitThumbnail;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 真实姓名
	 */
	@Column(name = "USERNAME", nullable = true, length = 64)
	public java.lang.String getUsername() {
		return this.username;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 真实姓名
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 登录账号
	 */
	@Column(name = "LOGINNAME", nullable = true, length = 64)
	public java.lang.String getLoginname() {
		return this.loginname;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 登录账号
	 */
	public void setLoginname(java.lang.String loginname) {
		this.loginname = loginname;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 登录密码
	 */
	@Column(name = "LOGINPASSWORD", nullable = true, length = 64)
	public java.lang.String getLoginpassword() {
		return this.loginpassword;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 登录密码
	 */
	public void setLoginpassword(java.lang.String loginpassword) {
		this.loginpassword = loginpassword;
	}

	@Transient
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 电子邮箱
	 */
	@Column(name = "USEREMAIL", nullable = true, length = 128)
	public java.lang.String getUseremail() {
		return this.useremail;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 电子邮箱
	 */
	public void setUseremail(java.lang.String useremail) {
		this.useremail = useremail;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 所属省Id
	 */
	@Column(name = "PROVINCEID", nullable = true, length = 10)
	public java.lang.Integer getProvinceid() {
		return this.provinceid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 所属省Id
	 */
	public void setProvinceid(java.lang.Integer provinceid) {
		this.provinceid = provinceid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 所属省
	 */
	@Column(name = "PROVINCE", nullable = true, length = 64)
	public java.lang.String getProvince() {
		return this.province;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 所属省
	 */
	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 所属市Id
	 */
	@Column(name = "CITYID", nullable = true, length = 10)
	public java.lang.Integer getCityid() {
		return this.cityid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 所属市Id
	 */
	public void setCityid(java.lang.Integer cityid) {
		this.cityid = cityid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 所属市
	 */
	@Column(name = "CITY", nullable = true, length = 64)
	public java.lang.String getCity() {
		return this.city;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 所属市
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 所属区/县Id
	 */
	@Column(name = "DISTRICTID", nullable = true, length = 10)
	public java.lang.Integer getDistrictid() {
		return this.districtid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 所属区/县Id
	 */
	public void setDistrictid(java.lang.Integer districtid) {
		this.districtid = districtid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 所属区/县
	 */
	@Column(name = "DISTRICT", nullable = true, length = 64)
	public java.lang.String getDistrict() {
		return this.district;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 所属区/县
	 */
	public void setDistrict(java.lang.String district) {
		this.district = district;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 详细地址
	 */
	@Column(name = "DETAILADDRESS", nullable = true, length = 512)
	public java.lang.String getDetailaddress() {
		return this.detailaddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 详细地址
	 */
	public void setDetailaddress(java.lang.String detailaddress) {
		this.detailaddress = detailaddress;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 使用状态(1启用2停用）
	 */
	@Column(name = "LOGINFLAG", nullable = true, length = 10)
	public java.lang.Integer getLoginflag() {
		return this.loginflag;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 使用状态(1启用2停用）
	 */
	public void setLoginflag(java.lang.Integer loginflag) {
		this.loginflag = loginflag;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String qqopenid
	 */
	@Column(name = "QQOPENID", nullable = true, length = 100)
	public java.lang.String getQqopenid() {
		return this.qqopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String qqopenid
	 */
	public void setQqopenid(java.lang.String qqopenid) {
		this.qqopenid = qqopenid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String wxopenid
	 */
	@Column(name = "WXOPENID", nullable = true, length = 100)
	public java.lang.String getWxopenid() {
		return this.wxopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String wxopenid
	 */
	public void setWxopenid(java.lang.String wxopenid) {
		this.wxopenid = wxopenid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String sinaopenid
	 */
	@Column(name = "SINAOPENID", nullable = true, length = 100)
	public java.lang.String getSinaopenid() {
		return this.sinaopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String sinaopenid
	 */
	public void setSinaopenid(java.lang.String sinaopenid) {
		this.sinaopenid = sinaopenid;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 创建时间
	 */
	@Column(name = "CREATE_DATE", nullable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 创建时间
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 创建人编号
	 */
	@Column(name = "CREATE_BY", nullable = true, length = 100)
	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 创建人编号
	 */
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 创建人姓名
	 */
	@Column(name = "CREATE_NAME", nullable = true, length = 100)
	public java.lang.String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 创建人姓名
	 */
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 更新时间
	 */
	@Column(name = "UPDATE_DATE", nullable = true)
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 更新人编号
	 */
	@Column(name = "UPDATE_BY", nullable = true, length = 100)
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 更新人编号
	 */
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 更信任姓名
	 */
	@Column(name = "UPDATE_NAME", nullable = true, length = 100)
	public java.lang.String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 更信任姓名
	 */
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

	public String toSignString(String timestampStr, String decvicesStr) {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"id\":\"");
		sb.append(id).append("\",\"loginname\":\"");
		if (loginname != null)
			sb.append(loginname);
		sb.append("\",\"loginflag\":\"");
		if (loginflag != null)
			sb.append(loginflag);
		sb.append("\",\"qqopenid\":\"");
		if (qqopenid != null)
			sb.append(qqopenid);
		sb.append("\",\"wxopenid\":\"");
		if (wxopenid != null)
			sb.append(wxopenid);
		sb.append("\",\"sinaopenid\":\"");
		if (sinaopenid != null)
			sb.append(sinaopenid);
		sb.append("\",\"createDate\":\"");
		if (createDate != null)
			sb.append(createDate);
		sb.append("\",\"timestamp\":\"");
		if (timestampStr != null)
			sb.append(timestampStr);
		sb.append("\",\"decvices\":\"");
		if (decvicesStr != null)
			sb.append(decvicesStr);
		sb.append("\"");

		sb.append(",\"username\":\"");
		if (decvicesStr != null)
			sb.append(username);
		sb.append("\"");

		sb.append("}");
		return sb.toString();
	}

}
