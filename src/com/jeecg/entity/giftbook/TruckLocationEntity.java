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
 * @Description: truck_location
 * @author onlineGenerator
 * @date 2018-01-08 20:55:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "truck_location", schema = "")
@SuppressWarnings("serial")
public class TruckLocationEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**逻辑id*/
	@Excel(exportName="逻辑id")
	private String dtid;
	/**货车编号*/
	@Excel(exportName="货车编号")
	private String truckId;
	/**经纬度*/
	@Excel(exportName="经纬度")
	private String latlng;
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
	 *@return: java.lang.String  货车编号
	 */
	@Column(name ="TRUCK_ID",nullable=true,length=32)
	public String getTruckId(){
		return this.truckId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货车编号
	 */
	public void setTruckId(String truckId){
		this.truckId = truckId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经纬度
	 */
	@Column(name ="LATLNG",nullable=true,length=40)
	public String getLatlng(){
		return this.latlng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经纬度
	 */
	public void setLatlng(String latlng){
		this.latlng = latlng;
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
