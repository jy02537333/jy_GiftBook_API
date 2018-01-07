package com.jeecg.entity.cms;

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
 * @Description: 微站点模板
 * @author onlineGenerator
 * @date 2014-07-15 22:20:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "weixin_cms_style", schema = "")
@SuppressWarnings("serial")
public class WeixinCmsStyleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建日期*/
	private Date createDate;
	/**修改人名称*/
	private String updateName;
	/**修改日期*/
	private Date updateDate;
	/**模板名称*/
	@Excel(exportName="模板名称")
	private String templateName;
	/**模板路径*/
	@Excel(exportName="模板路径")
	private String templateUrl;
	/**预览图*/
	@Excel(exportName="预览图")
	private String reviewImgUrl;
	/**公众帐号原始ID*/
	private String accountid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板名称
	 */
	@Column(name ="TEMPLATE_NAME",nullable=true,length=100)
	public String getTemplateName(){
		return this.templateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板名称
	 */
	public void setTemplateName(String templateName){
		this.templateName = templateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板路径
	 */
	@Column(name ="TEMPLATE_URL",nullable=true,length=200)
	public String getTemplateUrl(){
		return this.templateUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板路径
	 */
	public void setTemplateUrl(String templateUrl){
		this.templateUrl = templateUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预览图
	 */
	@Column(name ="REVIEW_IMG_URL",nullable=true,length=100)
	public String getReviewImgUrl(){
		return this.reviewImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预览图
	 */
	public void setReviewImgUrl(String reviewImgUrl){
		this.reviewImgUrl = reviewImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公众帐号原始ID
	 */
	@Column(name ="ACCOUNTID",nullable=true,length=50)
	public String getAccountid(){
		return this.accountid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公众帐号原始ID
	 */
	public void setAccountid(String accountid){
		this.accountid = accountid;
	}
}
