package com.jeecg.entity.giftbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 登陆记录
 * @author onlineGenerator
 * @date 2016-11-04 13:51:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "loginlog", schema = "")
@SuppressWarnings("serial")
public class LoginlogEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**用户id*/
	@Excel(name="用户id")
	private java.lang.String userid;
	/**登录时间*/
	@Excel(name="登录时间",format = "yyyy-MM-dd")
	private java.util.Date logindate;
	/**上次登录时间*/
	@Excel(name="上次登录时间",format = "yyyy-MM-dd")
	private java.util.Date lastlogindate;
	/**登录token*/
	@Excel(name="登录token")
	private java.lang.String logintoken;
	/**设备编号*/
	@Excel(name="设备编号")
	private java.lang.String device;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人编号*/
	@Excel(name="创建人编号")
	private java.lang.String createBy;
	/**创建人姓名*/
	@Excel(name="创建人姓名")
	private java.lang.String createName;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**更新人编号*/
	@Excel(name="更新人编号")
	private java.lang.String updateBy;
	/**更信任姓名*/
	@Excel(name="更信任姓名")
	private java.lang.String updateName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  Id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  登录时间
	 */
	@Column(name ="LOGINDATE",nullable=true)
	public java.util.Date getLogindate(){
		return this.logindate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  登录时间
	 */
	public void setLogindate(java.util.Date logindate){
		this.logindate = logindate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上次登录时间
	 */
	@Column(name ="LASTLOGINDATE",nullable=true)
	public java.util.Date getLastlogindate(){
		return this.lastlogindate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上次登录时间
	 */
	public void setLastlogindate(java.util.Date lastlogindate){
		this.lastlogindate = lastlogindate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  登录token
	 */
	@Column(name ="LOGINTOKEN",nullable=true,length=1500)
	public java.lang.String getLogintoken(){
		return this.logintoken;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  登录token
	 */
	public void setLogintoken(java.lang.String logintoken){
		this.logintoken = logintoken;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备编号
	 */
	@Column(name ="DEVICE",nullable=true,length=100)
	public java.lang.String getDevice(){
		return this.device;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备编号
	 */
	public void setDevice(java.lang.String device){
		this.device = device;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人编号
	 */
	@Column(name ="CREATE_BY",nullable=true,length=100)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人编号
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人姓名
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人姓名
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人编号
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人编号
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更信任姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更信任姓名
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
}
