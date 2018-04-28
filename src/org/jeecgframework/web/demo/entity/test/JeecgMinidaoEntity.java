package org.jeecgframework.web.demo.entity.test;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: Minidao例子
 * @author 张代浩
 * @date 2013-12-23 21:18:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jeecg_minidao", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class JeecgMinidaoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**年龄*/
	private Integer age;
	/**生日*/
	private java.util.Date birthday;
	/**说明*/
	private String content;
	/**创建时间*/
	private java.util.Date createTime;
	/**部门*/
	private String depId;
	/**电子邮箱*/
	private String email;
	/**手机*/
	private String mobilePhone;
	/**办公电话*/
	private String officePhone;
	/**工资*/
	private BigDecimal salary;
	/**性别*/
	private Integer sex;
	/**状态*/
	private String status;
	/**用户名*/
	private String userName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年龄
	 */
	@Column(name ="AGE",nullable=true,precision=10,scale=0)
	public Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年龄
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生日
	 */
	@Column(name ="BIRTHDAY",nullable=true)
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  说明
	 */
	@Column(name ="CONTENT",nullable=true,length=255)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  说明
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */
	@Column(name ="DEP_ID",nullable=true,length=255)
	public String getDepId(){
		return this.depId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setDepId(String depId){
		this.depId = depId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=255)
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机
	 */
	@Column(name ="MOBILE_PHONE",nullable=true,length=255)
	public String getMobilePhone(){
		return this.mobilePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公电话
	 */
	@Column(name ="OFFICE_PHONE",nullable=true,length=255)
	public String getOfficePhone(){
		return this.officePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公电话
	 */
	public void setOfficePhone(String officePhone){
		this.officePhone = officePhone;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  工资
	 */
	@Column(name ="SALARY",nullable=true,precision=19,scale=2)
	public BigDecimal getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  工资
	 */
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  性别
	 */
	@Column(name ="SEX",nullable=true,precision=10,scale=0)
	public Integer getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  性别
	 */
	public void setSex(Integer sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=255)
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */
	@Column(name ="USER_NAME",nullable=false,length=255)
	public String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
}
