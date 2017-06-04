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

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: v_invitation
 * @author onlineGenerator
 * @date 2017-05-27 16:46:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "v_invitation", schema = "")
@SuppressWarnings("serial")
public class ViewInvitationEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**请帖编号*/
	@Excel(name="请帖编号")
	private String invitationid;
	/**邀请人信息*/
	@Excel(name="邀请人信息")
	private String invitationname;
	/**被邀请人*/
	@Excel(name="被邀请人")
	private String inviteeid;
	/**被邀请人*/
	@Excel(name="被邀请人")
	private String inviteename;
	/**男士*/
	@Excel(name="男士")
	private java.lang.String manname;
	/**女士*/
	@Excel(name="女士")
	private java.lang.String womanname;
	/**被邀请人电话*/
	@Excel(name="被邀请人电话")
	private String inviteephone;
	/**状态(0=删除，1正常)*/
	@Excel(name="状态(0=删除，1正常)")
	private Integer state;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createDate;
	/**创建人编号*/
	@Excel(name="创建人编号")
	private String createBy;
	/**创建人姓名*/
	@Excel(name="创建人姓名")
	private String createName;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateDate;
	/**更新人编号*/
	@Excel(name="更新人编号")
	private String updateBy;
	/**更信任姓名*/
	@Excel(name="更信任姓名")
	private String updateName;
	/**是否发送出去*/
	@Excel(name="是否发送出去")
	private String issend;
	/**邀请人*/
	@Excel(name="邀请人")
	private String inviterid;
	/**邀请人电话*/
	@Excel(name="邀请人电话")
	private String inviterphone;
	/**宴席地址*/
	@Excel(name="宴席地址")
	private String feastaddress;
	/**宴席时间*/
	@Excel(name="宴席时间",format = "yyyy-MM-dd")
	private Date feastdate;
	/**封面图片*/
	@Excel(name="封面图片")
	private String coverimg;
	/**相册图片*/
	@Excel(name="相册图片")
	private String photoalbum;
	/**邀请人*/
	@Excel(name="邀请人")
	private String invitername;
	/**feasttype*/
	@Excel(name="feasttype")
	private String feasttype;
	
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
	 *@return: java.lang.String  请帖编号
	 */
	@Column(name ="INVITATIONID",nullable=true,length=32)
	public String getInvitationid(){
		return this.invitationid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请帖编号
	 */
	public void setInvitationid(String invitationid){
		this.invitationid = invitationid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人信息
	 */
//	@Column(name ="INVITATIONNAME",nullable=true,length=100)
	@Transient
	public String getInvitationname(){
		return this.invitationname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人信息
	 */
	public void setInvitationname(String invitationname){
		this.invitationname = invitationname;
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
	 *@return: java.lang.String  被邀请人
	 */
	@Column(name ="INVITEEID",nullable=true,length=32)
	public String getInviteeid(){
		return this.inviteeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人
	 */
	public void setInviteeid(String inviteeid){
		this.inviteeid = inviteeid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被邀请人
	 */
	@Column(name ="INVITEENAME",nullable=true,length=100)
	public String getInviteename(){
		return this.inviteename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人
	 */
	public void setInviteename(String inviteename){
		this.inviteename = inviteename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被邀请人电话
	 */
	@Column(name ="INVITEEPHONE",nullable=true,length=100)
	public String getInviteephone(){
		return this.inviteephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人电话
	 */
	public void setInviteephone(String inviteephone){
		this.inviteephone = inviteephone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态(0=删除，1正常)
	 */
	@Column(name ="STATE",nullable=true,length=10)
	public Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态(0=删除，1正常)
	 */
	public void setState(Integer state){
		this.state = state;
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
	 *@return: java.lang.String  更信任姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更信任姓名
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否发送出去
	 */
	@Column(name ="ISSEND",nullable=true,length=1)
	public String getIssend(){
		return this.issend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否发送出去
	 */
	public void setIssend(String issend){
		this.issend = issend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人
	 */
	@Column(name ="INVITERID",nullable=true,length=32)
	public String getInviterid(){
		return this.inviterid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人
	 */
	public void setInviterid(String inviterid){
		this.inviterid = inviterid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人电话
	 */
	@Column(name ="INVITERPHONE",nullable=true,length=32)
	public String getInviterphone(){
		return this.inviterphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人电话
	 */
	public void setInviterphone(String inviterphone){
		this.inviterphone = inviterphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席地址
	 */
	@Column(name ="FEASTADDRESS",nullable=true,length=150)
	public String getFeastaddress(){
		return this.feastaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席地址
	 */
	public void setFeastaddress(String feastaddress){
		this.feastaddress = feastaddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  宴席时间
	 */
	@Column(name ="FEASTDATE",nullable=true)
	public Date getFeastdate(){
		return this.feastdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  宴席时间
	 */
	public void setFeastdate(Date feastdate){
		this.feastdate = feastdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封面图片
	 */
	@Column(name ="COVERIMG",nullable=true,length=255)
	public String getCoverimg(){
		return this.coverimg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封面图片
	 */
	public void setCoverimg(String coverimg){
		this.coverimg = coverimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相册图片
	 */
	@Column(name ="PHOTOALBUM",nullable=true,length=2000)
	public String getPhotoalbum(){
		return this.photoalbum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相册图片
	 */
	public void setPhotoalbum(String photoalbum){
		this.photoalbum = photoalbum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人
	 */
	@Column(name ="INVITERNAME",nullable=true,length=100)
	public String getInvitername(){
		return this.invitername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人
	 */
	public void setInvitername(String invitername){
		this.invitername = invitername;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  feasttype
	 */
	@Column(name ="FEASTTYPE",nullable=true,length=3)
	public String getFeasttype(){
		return this.feasttype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  feasttype
	 */
	public void setFeasttype(String feasttype){
		this.feasttype = feasttype;
	}
}
