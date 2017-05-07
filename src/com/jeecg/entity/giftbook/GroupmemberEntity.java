package com.jeecg.entity.giftbook;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;


/**   
 * @Title: Entity
 * @Description: 组成员
 * @author onlineGenerator
 * @date 2016-11-04 13:55:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "groupmember", schema = "")
@SuppressWarnings("serial")
public class GroupmemberEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**组id*/
	@Excel(name="组id")
	private java.lang.String gourpid;
	/**组名称*/
	private java.lang.String gourpName;
	/**组成员姓名*/
	@Excel(name="组成员姓名")
	private java.lang.String groupmember;
	/**总金额*/
	@Excel(name="总金额")
	private java.lang.String totalmoney;
	/**成员电话*/
	@Excel(name="成员电话")
	private String memberphone;
	/**关联人,与该成员相关的人*/
	@Excel(name="关联人,与该成员相关的人")
	private String affiliatedperson;
	/**关联人id*/
	@Excel(name="关联人,与该成员相关的人")
	private String affiliatedpersonid;
	
	private List<GroupmemberEntity>  affiliatedpersonList;
	/**状态(0=删除，1正常)*/
	@Excel(name="状态(0=删除，1正常)")
	private java.lang.Integer state;

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
	 *方法: 取得 成员电话
	 *@return: java.lang.String  组id
	 */
	@Column(name ="MEMBERPHONE",nullable=true,length=20)
	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	/**
	 *方法: 关联人
	 *@return: java.lang.String  组id
	 */
	@Column(name ="AFFILIATEDPERSON",nullable=true,length=30)
	public String getAffiliatedperson() {
		return affiliatedperson;
	}

	public void setAffiliatedperson(String affiliatedperson) {
		this.affiliatedperson = affiliatedperson;
	}
	/**
	 *方法: 关联人id
	 *@return: java.lang.String 关联人id
	 */
	@Column(name ="AFFILIATEDPERSONID",nullable=false,length=32)
	public String getAffiliatedpersonid() {
		return affiliatedpersonid;
	}

	public void setAffiliatedpersonid(String affiliatedpersonid) {
		this.affiliatedpersonid = affiliatedpersonid;
	}
	/**
	 *方法: 关联人id
	 *@return: java.lang.String 关联人id
	 */
	@Transient
	public List<GroupmemberEntity> getAffiliatedpersonList() {
		return affiliatedpersonList;
	}
	/**
	 *方法: 关联人id
	 *@return: java.lang.String 关联人id
	 */
	public void setAffiliatedpersonList(List<GroupmemberEntity> affiliatedpersonList) {
		this.affiliatedpersonList = affiliatedpersonList;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组id
	 */
	@Column(name ="GOURPID",nullable=true,length=32)
	public java.lang.String getGourpid(){
		return this.gourpid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组id
	 */
	public void setGourpid(java.lang.String gourpid){
		this.gourpid = gourpid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组id
	 */
	@Transient
	public java.lang.String getGourpName(){
		return this.gourpName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组id
	 */
	public void setGourpName(java.lang.String gourpName){
		this.gourpName = gourpName;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组成员姓名
	 */
	@Column(name ="GROUPMEMBER",nullable=true,length=100)
	public java.lang.String getGroupmember(){
		return this.groupmember;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员姓名
	 */
	public void setGroupmember(java.lang.String groupmember){
		this.groupmember = groupmember;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  总金额
	 */
	@Column(name ="TOTALMONEY",nullable=true,scale=2,length=10)
	public java.lang.String getTotalmoney(){
		return this.totalmoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  总金额
	 */
	public void setTotalmoney(java.lang.String totalmoney){
		this.totalmoney = totalmoney;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态(0=删除，1正常)
	 */
	@Column(name ="STATE",nullable=true,length=10)
	public java.lang.Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态(0=删除，1正常)
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
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
