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
 * @Description: 成员礼金记录
 * @author onlineGenerator
 * @date 2016-11-03 17:23:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "membergiftmoney", schema = "")
@SuppressWarnings("serial")
public class MembergiftmoneyEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**组成员id*/
	@Excel(name="组成员id")
	private java.lang.String gourpmemberid;
	/**组成员姓名*/
	@Excel(name="组成员姓名")
	private java.lang.String groupmember;
	/**是否支出*/
	@Excel(name="是否支出")
	private java.lang.Integer isexpenditure;
	/**金额*/
	@Excel(name="金额")
	private java.lang.String money;
	/**支出类型编号*/
	@Excel(name="支出类型编号")
	private java.lang.String expendituretype;
	/**支出类型名称*/
	@Excel(name="支出类型名称")
	private java.lang.String expendituretypename;
	/**相关请帖*/
	@Excel(name="相关请帖")
	private java.lang.String correlativeinvitation;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组成员id
	 */
	@Column(name ="GOURPMEMBERID",nullable=true,length=32)
	public java.lang.String getGourpmemberid(){
		return this.gourpmemberid;
	}
	
	/**
	 *方法: 相关请帖
	 *@param: 相关请帖
	 */
	public void setCorrelativeinvitation(java.lang.String correlativeinvitation){
		this.correlativeinvitation = correlativeinvitation;
	}
	/**
	 *方法: 相关请帖
	 *@return: 相关请帖
	 */
	@Column(name ="CORRELATIVEINVITATION",nullable=true,length=32)
	public java.lang.String getCorrelativeinvitation(){
		return this.correlativeinvitation;
	}
	
	

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员id
	 */
	public void setGourpmemberid(java.lang.String gourpmemberid){
		this.gourpmemberid = gourpmemberid;
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
	 *@return: java.lang.String  是否支出
	 */
	@Column(name ="ISEXPENDITURE",nullable=true,length=1)
	public java.lang.Integer getIsexpenditure(){
		return this.isexpenditure;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否支出
	 */
	public void setIsexpenditure(java.lang.Integer isexpenditure){
		this.isexpenditure = isexpenditure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */
	@Column(name ="MONEY",nullable=true,scale=2,length=10)
	public java.lang.String getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setMoney(java.lang.String money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支出类型编号
	 */
	@Column(name ="EXPENDITURETYPE",nullable=true,length=10)
	public java.lang.String getExpendituretype(){
		return this.expendituretype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支出类型编号
	 */
	public void setExpendituretype(java.lang.String expendituretype){
		this.expendituretype = expendituretype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出类型名称
	 */
	@Column(name ="EXPENDITURETYPENAME",nullable=true,length=100)
	public java.lang.String getExpendituretypename(){
		return this.expendituretypename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出类型名称
	 */
	public void setExpendituretypename(java.lang.String expendituretypename){
		this.expendituretypename = expendituretypename;
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
