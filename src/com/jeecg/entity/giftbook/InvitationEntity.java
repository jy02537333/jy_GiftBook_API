package com.jeecg.entity.giftbook;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 请帖
 * @author onlineGenerator
 * @date 2017-02-21 15:56:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "invitation", schema = "")
@SuppressWarnings("serial")
public class InvitationEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**邀请人*/
	@Excel(name="邀请人")
	private java.lang.String inviterid;
	/**邀请人电话*/
	@Excel(name="邀请人电话")
	private java.lang.String inviterphone;
	/**宴席地址*/
	@Excel(name="宴席地址")
	private java.lang.String feastaddress;
	/**宴席酒店*/
	@Excel(name="宴席酒店")
	private java.lang.String feasthotel;
	/**宴席时间*/
	@Excel(name="宴席时间",format = "yyyy-MM-dd")
	private java.util.Date feastdate;
	/**宴席类型*/
	@Excel(name="宴席类型")
	private java.lang.String feasttype;
	/**男士*/
	@Excel(name="男士")
	private java.lang.String manname;
	/**女士*/
	@Excel(name="女士")
	private java.lang.String womanname;
	/**封面图片*/
	@Excel(name="封面图片")
	private java.lang.String coverimg;
	/**相册图片*/
	@Excel(name="相册图片")
	private java.lang.String photoalbum;
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
	@Excel(name="更新任姓名")
	private java.lang.String updateName;

	/**收礼名称*/
	@Excel(name="收礼名称")
	private java.lang.String receivinggiftsname;

	private List<InvitationlistEntity> invitationlistEntityList;
	@Transient
	public List<InvitationlistEntity> getInvitationlistEntityList() {
		return invitationlistEntityList;
	}
	public void setInvitationlistEntityList(List<InvitationlistEntity> invitationlistEntityList) {
		this.invitationlistEntityList = invitationlistEntityList;
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
	 *@return: java.lang.String  邀请人
	 */
	@Column(name ="INVITERID",nullable=true,length=32)
	public java.lang.String getInviterid(){
		return this.inviterid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人
	 */
	public void setInviterid(java.lang.String inviterid){
		this.inviterid = inviterid;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人电话
	 */
	@Column(name ="INVITERPHONE",nullable=true,length=32)
	public String getInviterphone() {
		return inviterphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人电话
	 */
	public void setInviterphone(String inviterphone) {
		this.inviterphone = inviterphone;
	}



	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席酒店
	 */
	@Column(name ="FEASTHOTEL",nullable=true,length=100)
	public java.lang.String getFeasthotel(){
		return this.feasthotel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席酒店
	 */
	public void setFeasthotel(java.lang.String feasthotel){
		this.feasthotel = feasthotel;
	}



	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席地址
	 */
	@Column(name ="FEASTADDRESS",nullable=true,length=150)
	public java.lang.String getFeastaddress(){
		return this.feastaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席地址
	 */
	public void setFeastaddress(java.lang.String feastaddress){
		this.feastaddress = feastaddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  宴席时间
	 */
	@Column(name ="FEASTDATE",nullable=true)
	public java.util.Date getFeastdate(){
		return this.feastdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  宴席时间
	 */
	public void setFeastdate(java.util.Date feastdate){
		this.feastdate = feastdate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  宴席类型
	 */
	@Column(name ="FEASTTYPE",nullable=true,length=32)
	public java.lang.String getFeasttype(){
		return this.feasttype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  宴席类型
	 */
	public void setFeasttype(java.lang.String feasttype){
		this.feasttype = feasttype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  男士
	 */
	@Column(name ="MANNAME",nullable=true,length=100)
	public java.lang.String getManname(){
		return this.manname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  男士
	 */
	public void setManname(java.lang.String manname){
		this.manname = manname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  女士
	 */
	@Column(name ="WOMANNAME",nullable=true,length=100)
	public java.lang.String getWomanname(){
		return this.womanname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  女士
	 */
	public void setWomanname(java.lang.String womanname){
		this.womanname = womanname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  请帖名称
	 */
	@Column(name ="RECEIVINGGIFTSNAME",nullable=true,length=100)
	public java.lang.String getReceivinggiftsname(){
		return this.receivinggiftsname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请帖名称
	 */
	public void setReceivinggiftsname(java.lang.String receivinggiftsname){
		this.receivinggiftsname = receivinggiftsname;
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
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封面图片
	 */
	@Column(name ="COVERIMG",nullable=true,length=255)
	public java.lang.String getCoverimg(){
		return this.coverimg;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String 封面图片
	 */
	public void setCoverimg(java.lang.String coverimg){
		this.coverimg = coverimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相册图片
	 */
	@Column(name ="PHOTOALBUM",nullable=true,length=2000)
	public java.lang.String getPhotoalbum(){
		return this.photoalbum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相册图片
	 */
	public void setPhotoalbum(java.lang.String photoalbum){
		this.photoalbum = photoalbum;
	}

}
