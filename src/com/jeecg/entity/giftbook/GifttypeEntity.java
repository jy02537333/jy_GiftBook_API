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
 * @Description: 礼金类型
 * @author onlineGenerator
 * @date 2016-11-03 09:52:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "gifttype", schema = "")
@SuppressWarnings("serial")
public class GifttypeEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**类型id，逻辑id*/
	@Excel(name="类型id，逻辑id")
	private java.lang.String dtid;
	/**是否默认使用*/
	@Excel(name="是否默认使用")
	private java.lang.Integer isDefault;
	/**类型所属用户*/
	@Excel(name="类型所属用户")
	private java.lang.String userid;
	/**类型名称*/
	@Excel(name="类型名称")
	private java.lang.String typename;
	/**父级id*/
	@Excel(name="父级id")
	private java.lang.String parentid;
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
	/**更新人姓名*/
	@Excel(name="更新人姓名")
	private java.lang.String updateName;
	
	
	
	@Column(name ="ISDEFAULT",nullable=true,length=10)
	public java.lang.Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(java.lang.Integer isDefault) {
		this.isDefault = isDefault;
	}
	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid() {
		return userid;
	}

	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
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
	 *@return: java.lang.String  类型id，逻辑id
	 */
	@Column(name ="DTID",nullable=true,length=32)
	public java.lang.String getDtid(){
		return this.dtid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型id，逻辑id
	 */
	public void setDtid(java.lang.String dtid){
		this.dtid = dtid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型名称
	 */
	@Column(name ="TYPENAME",nullable=true,length=32)
	public java.lang.String getTypename(){
		return this.typename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型名称
	 */
	public void setTypename(java.lang.String typename){
		this.typename = typename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父级id
	 */
	@Column(name ="PARENTID",nullable=true,length=32)
	public java.lang.String getParentid(){
		return this.parentid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父级id
	 */
	public void setParentid(java.lang.String parentid){
		this.parentid = parentid;
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
	 *@return: java.lang.String  更新人姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人姓名
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
}
