package com.jeecg.entity.giftbook;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 金融超市
 * @author onlineGenerator
 * @date 2017-02-21 14:54:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "financial_supermarket", schema = "")
@SuppressWarnings("serial")
public class FinancialSupermarketEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**第三方公司名称*/
	private java.lang.String thirdpartyname;
	/**第三方公司关键字*/
	private java.lang.String thirdpartycode;
	/**第三方公司关键字2*/
	private java.lang.String thirdpartycode2;
	/**第三方地址*/
	private java.lang.String thirdpartyaddr;
	/**描述*/
	private java.lang.String description;
	/**贷款额度*/
	private java.lang.String moneylimit;
	/**logo*/
	private java.lang.String logourl;
	/**贷款利息*/
	private java.lang.String moneyinterest;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人编号*/
	private java.lang.String createBy;
	/**创建人姓名*/
	private java.lang.String createName;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人编号*/
	private java.lang.String updateBy;
	/**更新人姓名*/
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
	 *@return: java.lang.String  第三方公司名称
	 */
	@Column(name ="THIRDPARTYNAME",nullable=true,length=200)
	public java.lang.String getThirdpartyname(){
		return this.thirdpartyname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司名称
	 */
	public void setThirdpartyname(java.lang.String thirdpartyname){
		this.thirdpartyname = thirdpartyname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方公司关键字
	 */
	@Column(name ="THIRDPARTYCODE",nullable=true,length=200)
	public java.lang.String getThirdpartycode(){
		return this.thirdpartycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司关键字
	 */
	public void setThirdpartycode(java.lang.String thirdpartycode){
		this.thirdpartycode = thirdpartycode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方公司关键字2
	 */
	@Column(name ="THIRDPARTYCODE2",nullable=true,length=200)
	public java.lang.String getThirdpartycode2(){
		return this.thirdpartycode2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司关键字2
	 */
	public void setThirdpartycode2(java.lang.String thirdpartycode2){
		this.thirdpartycode2 = thirdpartycode2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方地址
	 */
	@Column(name ="THIRDPARTYADDR",nullable=true,length=500)
	public java.lang.String getThirdpartyaddr(){
		return this.thirdpartyaddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方地址
	 */
	public void setThirdpartyaddr(java.lang.String thirdpartyaddr){
		this.thirdpartyaddr = thirdpartyaddr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=500)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款额度
	 */
	@Column(name ="MONEYLIMIT",nullable=true,length=100)
	public java.lang.String getMoneylimit(){
		return this.moneylimit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款额度
	 */
	public void setMoneylimit(java.lang.String moneylimit){
		this.moneylimit = moneylimit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  logo
	 */
	@Column(name ="LOGOURL",nullable=true,length=255)
	public java.lang.String getLogourl(){
		return this.logourl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  logo
	 */
	public void setLogourl(java.lang.String logourl){
		this.logourl = logourl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款利息
	 */
	@Column(name ="MONEYINTEREST",nullable=true,length=100)
	public java.lang.String getMoneyinterest(){
		return this.moneyinterest;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款利息
	 */
	public void setMoneyinterest(java.lang.String moneyinterest){
		this.moneyinterest = moneyinterest;
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
