package org.jeecgframework.web.demo.entity.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 公告
 * @author 张代浩
 * @date 2013-03-12 14:06:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jg_person", schema = "")
@SuppressWarnings("serial")
public class JeecgNoteEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**年龄*/
	private Integer age;
	/**生日*/
	private Date birthday;
	/**出生日期*/
	private Date createdt;
	/**用户名*/
	private String name;
	/**工资*/
	private BigDecimal salary;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年龄
	 */
	@Column(name ="AGE",nullable=true)
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
	public Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="CREATEDT",nullable=true)
	public Date getCreatedt(){
		return this.createdt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setCreatedt(Date createdt){
		this.createdt = createdt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */
	@Column(name ="NAME",nullable=false)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  工资
	 */
	@Column(name ="SALARY",nullable=true)
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
}
