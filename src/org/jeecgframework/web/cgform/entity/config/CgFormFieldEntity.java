package org.jeecgframework.web.cgform.entity.config;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 自动生成表的列属性
 * @author jueyue
 * @date 2013-06-30 11:37:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cgform_field", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@JsonAutoDetect
@SuppressWarnings("serial")
public class CgFormFieldEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**字段名称*/
	private String fieldName;
	/**关联的表*/
	private CgFormHeadEntity table;
	/**字段长度*/
	private Integer length;
	/**小数点长度*/
	private Integer pointLength;
	/**字段类型*/
	private String type;
	/**是否允许空值*/
	private String isNull;
	/**在表中的顺序*/
	private Integer orderNum;
	/**是否主键*/
	private String isKey;
	/**是否显示*/
	private String isShow;
	/**是否在列表上显示*/
	private String isShowList;
	/**显示类型*/
	private String showType;
	/**是否生产查询字段*/
	private String isQuery;
	/**控件长度*/
	private Integer fieldLength;
	/**字段Href*/
	private String fieldHref;
	/**控件校验*/
	private String fieldValidType;
	/**查询类型single(默认：单字段查询),group(范围查询)*/
	private String queryMode;
	/**功能注释*/
	private String content;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人ID*/
	private String createBy;
	/**创建人名称*/
	private String createName;
	/**修改时间*/
	private java.util.Date updateDate;
	/**修改人ID*/
	private String updateBy;
	/**修改人名称*/
	private String updateName;
	/**字典Code*/
	private String dictField;
	/**字典Table*/
	private String dictTable;
	/**字典Text*/
	private String dictText;
	/**主表名*/
	private String mainTable;
	/**主表字段*/
	private String mainField;
	/**旧的字段名称*/
	private String oldFieldName;
	/**字段默认值*/
	private String fieldDefault;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,length=32)
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
	 *@return: java.lang.String  字段名称
	 */
	@Column(name ="field_name",nullable=false,length=32)
	public String getFieldName(){
		return this.fieldName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段名称
	 */
	 public void setFieldName(String fieldName){
		this.fieldName = fieldName;
	}
	/**
	 *方法: 取得TablePropertyEntity
	 *@return: TablePropertyEntity  关联的表ＩＤ
	 */
	@ManyToOne
	@JoinColumn(name ="table_id",nullable=false,referencedColumnName="id")
	@JsonIgnore
	@ForeignKey(name="null")
	public CgFormHeadEntity getTable(){
		return this.table;
	}

	/**
	 *方法: 设置TablePropertyEntity
	 *@param: TablePropertyEntity  关联的表ID
	 */
	public void setTable(CgFormHeadEntity table){
		this.table = table;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  字段长度
	 */
	@Column(name ="length",nullable=false,precision=10,scale=0)
	public Integer getLength(){
		return this.length;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  字段长度
	 */
	public void setLength(Integer length){
		this.length = length;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  小数点长度
	 */
	@Column(name ="point_length",nullable=true,precision=10,scale=0)
	public Integer getPointLength(){
		return this.pointLength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  小数点长度
	 */
	public void setPointLength(Integer pointLength){
		this.pointLength = pointLength;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段类型
	 */
	@Column(name ="type",nullable=false,length=32)
	public String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段类型
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否允许空值
	 */
	@Column(name ="is_null",nullable=true,length=5)
	public String getIsNull(){
		return this.isNull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否允许空值
	 */
	public void setIsNull(String isNull){
		this.isNull = isNull;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否显示
	 */
	@Column(name ="is_show",nullable=true,length=5)
	public String getIsShow(){
		return this.isShow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否显示
	 */
	public void setIsShow(String isShow){
		this.isShow = isShow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  显示类型
	 */
	@Column(name ="show_type",nullable=true,length=10)
	public String getShowType(){
		return this.showType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  显示类型
	 */
	public void setShowType(String showType){
		this.showType = showType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否生产查询字段
	 */
	@Column(name ="is_query",nullable=true,length=5)
	public String getIsQuery(){
		return this.isQuery;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否生产查询字段
	 */
	public void setIsQuery(String isQuery){
		this.isQuery = isQuery;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查询类型single(默认：单字段查询),group(范围查询)
	 */
	@Column(name ="query_mode",nullable=true,length=10)
	public String getQueryMode(){
		return this.queryMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查询类型single(默认：单字段查询),group(范围查询)
	 */
	public void setQueryMode(String queryMode){
		this.queryMode = queryMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  功能注释
	 */
	@Column(name ="content",nullable=false,length=200)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  功能注释
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="create_date",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="create_by",nullable=true)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="create_name",nullable=true,length=32)
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
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="update_date",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人ID
	 */
	@Column(name ="update_by",nullable=true,length=32)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人ID
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人名称
	 */
	@Column(name ="update_name",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在表中的顺序
	 */
	@Column(name ="order_num",nullable=true,length=4)
	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否为主键
	 */
	@Column(name ="is_key",nullable=true,length=2)
	public String getIsKey() {
		return isKey;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  控件长度
	 */
	@Column(name ="field_length",nullable=true,length=10)
	public Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(Integer field_length) {
		this.fieldLength = field_length;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段Href
	 */
	@Column(name ="field_href",nullable=true,length=200)
	public String getFieldHref() {
		return fieldHref;
	}

	public void setFieldHref(String field_href) {
		this.fieldHref = field_href;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  控件校验
	 */
	@Column(name ="field_valid_type",nullable=true,length=10)
	public String getFieldValidType() {
		return fieldValidType;
	}

	public void setFieldValidType(String field_valid_type) {
		this.fieldValidType = field_valid_type;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  字典Code
	 * */
	@Column(name ="dict_field",nullable=true,length=100)
	public String getDictField() {
		return dictField;
	}

	public void setDictField(String dictField) {
		this.dictField = dictField;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  字典Table
	 * */
	@Column(name ="dict_table",nullable=true,length=100)
	public String getDictTable() {
		return dictTable;
	}

	public void setDictTable(String dictTable) {
		this.dictTable = dictTable;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  主表名称
	 * */
	@Column(name ="main_table",nullable=true,length=100)
	public String getMainTable() {
		return mainTable;
	}

	public void setMainTable(String mainTable) {
		this.mainTable = mainTable;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  主表名称
	 * */
	@Column(name ="main_field",nullable=true,length=100)
	public String getMainField() {
		return mainField;
	}

	public void setMainField(String mainField) {
		this.mainField = mainField;
	}

	/**
	 * 方法: 取得 java.lang.String
	 * @return  主表名称
	 * */
	@Column(name ="old_field_name",nullable=true,length=32)
	public String getOldFieldName() {
		return oldFieldName;
	}

	public void setOldFieldName(String oldFieldName) {
		this.oldFieldName = oldFieldName;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  是否在列表上显示
	 * */
	@Column(name ="is_show_list",nullable=true,length=5)
	public String getIsShowList() {
		return isShowList;
	}

	public void setIsShowList(String isShowList) {
		this.isShowList = isShowList;
	}
	/**
	 * 方法: 取得 java.lang.String
	 * @return  字典文本
	 * */
	@Column(name ="dict_text",nullable=true,length=100)
	public String getDictText() {
		return dictText;
	}

	public void setDictText(String dictText) {
		this.dictText = dictText;
	}

	@Column(name ="field_default",nullable=true,length=20)
	public String getFieldDefault() {
		if (fieldDefault != null) {
			fieldDefault = fieldDefault.trim();
		}
		return fieldDefault;
	}

	public void setFieldDefault(String fieldDefault) {
		this.fieldDefault = fieldDefault;
	}
	
	
}
