package com.jeecg.entity.giftbook;

import java.util.Date;
import java.lang.String;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: v_receives_money
 * @author onlineGenerator
 * @date 2017-06-03 15:20:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "v_receives_money", schema = "")
@SuppressWarnings("serial")
public class VReceivesMoneyEntity implements java.io.Serializable {
	/**标题*/
	@Excel(name="标题")
	private String title;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createDate;
	/**Id*/
	private String id;
	/**receivestype*/
	@Excel(name="receivestype")
	private String receivestype;
	/**receivestypeid*/
	@Excel(name="receivestypeid")
	private String receivestypeid;
	/**sumMoney*/
	@Excel(name="sumMoney")
	private String sumMoney;
	/**num*/
	@Excel(name="num")
	private Integer num;
	/**create_by*/
	@Excel(name="create_by")
	private String create_by;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=false,length=32)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(String title){
		this.title = title;
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
	 *@return: java.lang.String  receivestype
	 */
	@Column(name ="RECEIVESTYPE",nullable=true,length=3)
	public String getReceivestype(){
		return this.receivestype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  receivestype
	 */
	public void setReceivestype(String receivestype){
		this.receivestype = receivestype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  receivestype
	 */
	@Column(name ="RECEIVESTYPEID",nullable=true,length=3)
	public String getReceivestypeId(){
		return this.receivestypeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  receivestype
	 */
	public void setReceivestypeId(String receivestypeid){
		this.receivestypeid = receivestypeid;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sumMoney
	 */
	@Column(name ="SUM_MONEY",nullable=true,scale=2,length=32)
	public String getSumMoney(){
		return this.sumMoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sumMoney
	 */
	public void setSumMoney(String sumMoney){
		this.sumMoney = sumMoney;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  num
	 */
	@Column(name ="NUM",nullable=false,length=19)
	public Integer getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  num
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  num
	 */
	@Column(name ="CREATE_BY",nullable=false,length=19)
	public String getCreate_by(){
		return this.create_by;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  num
	 */
	public void setCreate_by(String create_by){
		this.create_by = create_by;
	}
}
