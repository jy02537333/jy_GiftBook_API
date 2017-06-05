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
 * @Title: Entity
 * @Description: v_receiving_money
 * @author onlineGenerator
 * @date 2017-06-05 17:02:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "v_receiving_money", schema = "")
@SuppressWarnings("serial")
public class VReceivingMoneyEntity implements java.io.Serializable {
	/**标题*/
	@Excel(name="标题")
	private String title;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createdate;
	/**创建人编号*/
	@Excel(name="创建人编号")
	private String createby;
	/**Id*/
	private String id;
	/**收礼类型*/
	@Excel(name="收礼类型")
	private Integer typeid;
	/**receivestype*/
	@Excel(name="receivestype")
	private String receivestype;
	/**summoney*/
	@Excel(name="summoney")
	private String summoney;
	/**num*/
	@Excel(name="num")
	private Integer num;
	
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
	@Column(name ="CREATEDATE",nullable=true)
	public Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatedate(Date createdate){
		this.createdate = createdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人编号
	 */
	@Column(name ="CREATEBY",nullable=true,length=100)
	public String getCreateby(){
		return this.createby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人编号
	 */
	public void setCreateby(String createby){
		this.createby = createby;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  收礼类型
	 */
	@Column(name ="TYPEID",nullable=false,length=10)
	public Integer getTypeid(){
		return this.typeid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  收礼类型
	 */
	public void setTypeid(Integer typeid){
		this.typeid = typeid;
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
	 *@return: java.lang.String  summoney
	 */
	@Column(name ="SUMMONEY",nullable=true,scale=2,length=32)
	public String getSummoney(){
		return this.summoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  summoney
	 */
	public void setSummoney(String summoney){
		this.summoney = summoney;
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
}
