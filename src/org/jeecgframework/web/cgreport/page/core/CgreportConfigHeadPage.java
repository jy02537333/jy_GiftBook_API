package org.jeecgframework.web.cgreport.page.core;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

import org.jeecgframework.web.cgreport.entity.core.CgreportConfigItemEntity;

/**   
 * @Title: Entity
 * @Description: 动态报表配置抬头
 * @author 张代浩
 * @date 2013-12-07 16:00:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jform_cgreport_head", schema = "")
@SuppressWarnings("serial")
public class CgreportConfigHeadPage implements java.io.Serializable {
	/**保存-动态报表配置明细*/
	private List<CgreportConfigItemEntity> cgreportConfigItemList = new ArrayList<CgreportConfigItemEntity>();
	public List<CgreportConfigItemEntity> getCgreportConfigItemList() {
		return cgreportConfigItemList;
	}
	public void setCgreportConfigItemList(List<CgreportConfigItemEntity> cgreportConfigItemList) {
		this.cgreportConfigItemList = cgreportConfigItemList;
	}


	/**主键*/
	private String id;
	/**编码*/
	private String code;
	/**名称*/
	private String name;
	/**查询数据SQL*/
	private String cgrSql;
	/**描述*/
	private String content;
	
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
	 *@return: java.lang.String  编码
	 */
	@Column(name ="CODE",nullable=false,length=36)
	public String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=false,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查询数据SQL
	 */
	@Column(name ="CGR_SQL",nullable=false,length=2000)
	public String getCgrSql(){
		return this.cgrSql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查询数据SQL
	 */
	public void setCgrSql(String cgrSql){
		this.cgrSql = cgrSql;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="CONTENT",nullable=false,length=1000)
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
