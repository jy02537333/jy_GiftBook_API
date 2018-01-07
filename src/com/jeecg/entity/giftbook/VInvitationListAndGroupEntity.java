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
 * @Title: 请帖邀请人 加分组 视图
 * @Description: v_invitation_list_and_group
 * @author onlineGenerator
 * @date 2017-06-09 11:34:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "v_invitation_list_and_group", schema = "")
@SuppressWarnings("serial")
public class VInvitationListAndGroupEntity implements java.io.Serializable {
	/**Id*/
	private java.lang.String id;
	/**被邀请人*/
	private String inviteeid;
	/**被邀请人*/
	private String inviteename;
	/**被邀请人电话*/
	private String inviteephone;
	/**组名称*/
	private String groupname;
	/**组id*/
	private String gourpid;
	/**请帖编号*/
	private String invitationid;



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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组名称
	 */
	@Column(name ="GROUPNAME",nullable=true,length=100)
	public String getGroupname(){
		return this.groupname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组名称
	 */
	public void setGroupname(String groupname){
		this.groupname = groupname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组id
	 */
	@Column(name ="GOURPID",nullable=true,length=32)
	public String getGourpid(){
		return this.gourpid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组id
	 */
	public void setGourpid(String gourpid){
		this.gourpid = gourpid;
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
}
