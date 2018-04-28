package org.jeecgframework.web.cgform.entity.button;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 按钮sql增强
 * @author 张代浩
 * @date 2013-08-07 23:09:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_button_sql", schema = "")
@SuppressWarnings("serial")
public class CgformButtonSqlEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**外键关联cgform_head*/
	private String formId;
	/**按钮编码*/
	private String buttonCode;
	/**称名*/
	private String cgbSqlName;
	/**强增sql*/
	private byte[] cgbSql;
	/**强增sql Str*/
	private String cgbSqlStr;
	/**描述*/
	private String content;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键关联cgform_head
	 */
	@Column(name ="FORM_ID",nullable=true,length=32)
	public String getFormId(){
		return this.formId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键关联cgform_head
	 */
	public void setFormId(String formId){
		this.formId = formId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  按钮编码
	 */
	@Column(name ="BUTTON_CODE",nullable=true,length=50)
	public String getButtonCode(){
		return this.buttonCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮编码
	 */
	public void setButtonCode(String buttonCode){
		this.buttonCode = buttonCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  称名
	 */
	@Column(name ="CGB_SQL_NAME",nullable=true,length=50)
	public String getCgbSqlName(){
		return this.cgbSqlName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  称名
	 */
	public void setCgbSqlName(String cgbSqlName){
		this.cgbSqlName = cgbSqlName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  强增sql
	 */
	@Column(name ="CGB_SQL",nullable=true)
	public byte[] getCgbSql(){
		return this.cgbSql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  强增sql
	 */
	public void setCgbSql(byte[] cgbSql){
		this.cgbSql = cgbSql;
	}
	
	@Transient
	public String getCgbSqlStr() {
		if(cgbSql!=null){
			cgbSqlStr = new String(cgbSql);
		}
		return cgbSqlStr;
	}

	public void setCgbSqlStr(String cgbSqlStr) {
		this.cgbSqlStr = cgbSqlStr;
		if(cgbSqlStr!=null){
			this.cgbSql = cgbSqlStr.getBytes();
		}
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="CONTENT",nullable=true,length=1000)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setContent(String content){
		this.content = content;
	}
}
