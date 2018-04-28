package org.jeecgframework.web.demo.entity.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 乐观锁测试
 * @author 张代浩
 * @date 2013-06-24 14:46:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "OPTIMISTIC_LOCKING", schema = "")
@SuppressWarnings("serial")
public class OptimisticLockingEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**name*/
	private String name;
	/**age*/
	private Integer age;
	/**account*/
	private Integer account;
	/**ver*/
	private Integer ver;
	
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
	 *@return: java.lang.String  name
	 */
	@Column(name ="NAME",nullable=true,length=85)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  age
	 */
	@Column(name ="AGE",nullable=true,precision=10,scale=0)
	public Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  age
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  account
	 */
	@Column(name ="ACCOUNT",nullable=true,precision=10,scale=0)
	public Integer getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  account
	 */
	public void setAccount(Integer account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ver
	 */
	 @Version
	 @Column(name="VER")
	public Integer getVer(){
		return this.ver;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ver
	 */
	public void setVer(Integer ver){
		this.ver = ver;
	}
}
