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
 * @Description: receiving_gifts_money
 * @author onlineGenerator
 * @date 2017-06-03 15:11:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "receiving_gifts_money", schema = "")
@SuppressWarnings("serial")
public class ReceivingGiftsMoneyEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**组成员id*/
	@Excel(name="组成员id")
	private String gourpmemberid;
	/**组成员姓名*/
	@Excel(name="组成员姓名")
	private String groupmember;
	/**是否支出*/
	@Excel(name="是否支出")
	private Integer isexpenditure;
	/**金额*/
	@Excel(name="金额")
	private String money;
	/**支出类型编号*/
	@Excel(name="支出类型编号")
	private String expendituretype;
	/**支出类型名称*/
	@Excel(name="支出类型名称")
	private String expendituretypename;
	/**相关的请帖*/
	@Excel(name="相关的请帖")
	private String correlativeinvitation;
	/**支出时间*/
	@Excel(name="支出时间",format = "yyyy-MM-dd")
	private Date expendituredate;
	/**备注*/
	@Excel(name="备注")
	private String remark;
	/**状态(0=删除，1正常)*/
	@Excel(name="状态(0=删除，1正常)")
	private Integer state;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createDate;
	/**创建人编号*/
	@Excel(name="创建人编号")
	private String createBy;
	/**创建人姓名*/
	@Excel(name="创建人姓名")
	private String createName;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateDate;
	/**更新人编号*/
	@Excel(name="更新人编号")
	private String updateBy;
	/**更信任姓名*/
	@Excel(name="更信任姓名")
	private String updateName;
	
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
	 *@return: java.lang.String  组成员id
	 */
	@Column(name ="GOURPMEMBERID",nullable=true,length=32)
	public String getGourpmemberid(){
		return this.gourpmemberid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员id
	 */
	public void setGourpmemberid(String gourpmemberid){
		this.gourpmemberid = gourpmemberid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组成员姓名
	 */
	@Column(name ="GROUPMEMBER",nullable=true,length=100)
	public String getGroupmember(){
		return this.groupmember;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员姓名
	 */
	public void setGroupmember(String groupmember){
		this.groupmember = groupmember;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否支出
	 */
	@Column(name ="ISEXPENDITURE",nullable=true,length=1)
	public Integer getIsexpenditure(){
		return this.isexpenditure;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否支出
	 */
	public void setIsexpenditure(Integer isexpenditure){
		this.isexpenditure = isexpenditure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */
	@Column(name ="MONEY",nullable=true,scale=2,length=10)
	public String getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setMoney(String money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出类型编号
	 */
	@Column(name ="EXPENDITURETYPE",nullable=true,length=32)
	public String getExpendituretype(){
		return this.expendituretype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出类型编号
	 */
	public void setExpendituretype(String expendituretype){
		this.expendituretype = expendituretype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出类型名称
	 */
	@Column(name ="EXPENDITURETYPENAME",nullable=true,length=100)
	public String getExpendituretypename(){
		return this.expendituretypename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出类型名称
	 */
	public void setExpendituretypename(String expendituretypename){
		this.expendituretypename = expendituretypename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相关的请帖
	 */
	@Column(name ="CORRELATIVEINVITATION",nullable=true,length=32)
	public String getCorrelativeinvitation(){
		return this.correlativeinvitation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相关的请帖
	 */
	public void setCorrelativeinvitation(String correlativeinvitation){
		this.correlativeinvitation = correlativeinvitation;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支出时间
	 */
	@Column(name ="EXPENDITUREDATE",nullable=true)
	public Date getExpendituredate(){
		return this.expendituredate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  支出时间
	 */
	public void setExpendituredate(Date expendituredate){
		this.expendituredate = expendituredate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=500)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态(0=删除，1正常)
	 */
	@Column(name ="STATE",nullable=true,length=10)
	public Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态(0=删除，1正常)
	 */
	public void setState(Integer state){
		this.state = state;
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
	 *@return: java.lang.String  创建人编号
	 */
	@Column(name ="CREATE_BY",nullable=true,length=100)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人编号
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人姓名
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人姓名
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人编号
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人编号
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更信任姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更信任姓名
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
}
