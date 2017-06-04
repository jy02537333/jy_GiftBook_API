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
 * @Description: v_receives_invitation
 * @author onlineGenerator
 * @date 2017-06-02 23:18:08
 * @version V1.0
 *
 */
@Entity
@Table(name = "v_receives_invitation", schema = "")
@SuppressWarnings("serial")
public class VReceivesInvitationEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**邀请人编号*/
	@Excel(name="邀请人编号")
	private java.lang.String inviterid;
	/**收礼名称*/
	@Excel(name="收礼名称")
	private java.lang.String receivinggiftsname;
	/**宴席时间*/
	@Excel(name="宴席时间",format = "yyyy-MM-dd")
	private java.util.Date feastdate;
	/**宴席类型*/
	@Excel(name="宴席类型")
	private java.lang.String feasttype;
	/**封面图片*/
	@Excel(name="封面图片")
	private java.lang.String coverimg;
	/**男士姓名*/
	@Excel(name="男士姓名")
	private java.lang.String manname;
	/**女士姓名*/
	@Excel(name="女士姓名")
	private java.lang.String womanname;
	/**summoney*/
	@Excel(name="summoney")
	private java.lang.String summoney;
	/**sumcount*/
	@Excel(name="sumcount")
	private java.lang.Double sumcount;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=32)
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
	 *@return: java.lang.String  邀请人编号
	 */
	@Column(name ="INVITERID",nullable=true,length=32)
	public java.lang.String getInviterid(){
		return this.inviterid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人编号
	 */
	public void setInviterid(java.lang.String inviterid){
		this.inviterid = inviterid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收礼名称
	 */
	@Column(name ="RECEIVINGGIFTSNAME",nullable=true,length=100)
	public java.lang.String getReceivinggiftsname(){
		return this.receivinggiftsname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收礼名称
	 */
	public void setReceivinggiftsname(java.lang.String receivinggiftsname){
		this.receivinggiftsname = receivinggiftsname;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席类型
	 */
	@Column(name ="FEASTTYPE",nullable=true,length=32)
	public java.lang.String getFeasttype(){
		return this.feasttype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席类型
	 */
	public void setFeasttype(java.lang.String feasttype){
		this.feasttype = feasttype;
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
	 *@param: java.lang.String  封面图片
	 */
	public void setCoverimg(java.lang.String coverimg){
		this.coverimg = coverimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  男士姓名
	 */
	@Column(name ="MANNAME",nullable=true,length=100)
	public java.lang.String getManname(){
		return this.manname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  男士姓名
	 */
	public void setManname(java.lang.String manname){
		this.manname = manname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  女士姓名
	 */
	@Column(name ="WOMANNAME",nullable=true,length=100)
	public java.lang.String getWomanname(){
		return this.womanname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  女士姓名
	 */
	public void setWomanname(java.lang.String womanname){
		this.womanname = womanname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  summoney
	 */
	@Column(name ="SUMMONEY",nullable=true,scale=2,length=32)
	public java.lang.String getSummoney(){
		return this.summoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  summoney
	 */
	public void setSummoney(java.lang.String summoney){
		this.summoney = summoney;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  sumcount
	 */
	@Column(name ="SUMCOUNT",nullable=true,length=23)
	public java.lang.Double getSumcount(){
		return this.sumcount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  sumcount
	 */
	public void setSumcount(java.lang.Double sumcount){
		this.sumcount = sumcount;
	}
}
