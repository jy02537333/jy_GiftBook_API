package org.jeecgframework.web.cgform.entity.button;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 表单自定义按钮
 * @author 张代浩
 * @date 2013-08-07 20:16:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_button", schema = "")
@SuppressWarnings("serial")
public class CgformButtonEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**外键关联cgform_head*/
	private String formId;
	/**按钮编码*/
	private String buttonCode;
	/**按钮名称*/
	private String buttonName;
	/**按钮样式link/button*/
	private String buttonStyle;
	/**动作类型:js/bus*/
	private String optType;
	/**显示表达式:exp="status#eq#0"*/
	private String exp;
	/**0:禁用/1:使用*/
	private String buttonStatus;
	/**顺序*/
	private Integer orderNum;
	/**按钮图标样式*/
	private String buttonIcon;
	
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
	 *@return: java.lang.String  按钮名称
	 */
	@Column(name ="BUTTON_NAME",nullable=true,length=50)
	public String getButtonName(){
		return this.buttonName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮名称
	 */
	public void setButtonName(String buttonName){
		this.buttonName = buttonName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  按钮样式link/button
	 */
	@Column(name ="BUTTON_STYLE",nullable=true,length=20)
	public String getButtonStyle(){
		return this.buttonStyle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮样式link/button
	 */
	public void setButtonStyle(String buttonStyle){
		this.buttonStyle = buttonStyle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  动作类型:js/bus
	 */
	@Column(name ="OPT_TYPE",nullable=true,length=20)
	public String getOptType(){
		return this.optType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  动作类型:js/bus
	 */
	public void setOptType(String optType){
		this.optType = optType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  显示表达式:exp="status#eq#0"
	 */
	@Column(name ="EXP",nullable=true,length=255)
	public String getExp(){
		return this.exp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  显示表达式:exp="status#eq#0"
	 */
	public void setExp(String exp){
		this.exp = exp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  0:禁用/1:使用
	 */
	@Column(name ="BUTTON_STATUS",nullable=true,length=2)
	public String getButtonStatus(){
		return this.buttonStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  0:禁用/1:使用
	 */
	public void setButtonStatus(String buttonStatus){
		this.buttonStatus = buttonStatus;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  顺序
	 */
	@Column(name ="order_num",nullable=true,length=4)
	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name ="button_icon",nullable=true,length=20)
	public String getButtonIcon() {
		return buttonIcon;
	}

	public void setButtonIcon(String buttonIcon) {
		this.buttonIcon = buttonIcon;
	}
	
	
}
