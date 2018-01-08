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
 * @Description: truck
 * @author onlineGenerator
 * @date 2018-01-08 20:56:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "truck", schema = "")
@SuppressWarnings("serial")
public class TruckEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**逻辑id*/
	@Excel(exportName="逻辑id")
	private String dtid;
	/**userid*/
	@Excel(exportName="userid")
	private String userid;
	/**车类型*/
	@Excel(exportName="车类型")
	private String vehicleType;
	/**车牌*/
	@Excel(exportName="车牌")
	private String licensePlate;
	/**描述*/
	@Excel(exportName="描述")
	private String describes;
	/**联系方式*/
	@Excel(exportName="联系方式")
	private String phone;
	/**创建时间*/
	@Excel(exportName="创建时间")
	private Date createDate;
	/**创建人编号*/
	@Excel(exportName="创建人编号")
	private String createBy;
	/**创建人姓名*/
	@Excel(exportName="创建人姓名")
	private String createName;
	/**更新时间*/
	@Excel(exportName="更新时间")
	private Date updateDate;
	/**更新人编号*/
	@Excel(exportName="更新人编号")
	private String updateBy;
	/**更新人姓名*/
	@Excel(exportName="更新人姓名")
	private String updateName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  Id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  逻辑id
	 */
	@Column(name ="DTID",nullable=true,length=32)
	public String getDtid(){
		return this.dtid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  逻辑id
	 */
	public void setDtid(String dtid){
		this.dtid = dtid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userid
	 */
	public void setUserid(String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车类型
	 */
	@Column(name ="VEHICLE_TYPE",nullable=true,length=32)
	public String getVehicleType(){
		return this.vehicleType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车类型
	 */
	public void setVehicleType(String vehicleType){
		this.vehicleType = vehicleType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌
	 */
	@Column(name ="LICENSE_PLATE",nullable=true,length=100)
	public String getLicensePlate(){
		return this.licensePlate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌
	 */
	public void setLicensePlate(String licensePlate){
		this.licensePlate = licensePlate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="DESCRIBES",nullable=true,length=100)
	public String getDescribes(){
		return this.describes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescribes(String describes){
		this.describes = describes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="PHONE",nullable=true,length=32)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人编号
	 */
	@Column(name ="CREATE_BY",nullable=true,length=100)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人编号
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人姓名
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人姓名
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人编号
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人编号
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人姓名
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
}
