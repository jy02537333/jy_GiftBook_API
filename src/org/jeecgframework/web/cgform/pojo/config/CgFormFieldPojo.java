package org.jeecgframework.web.cgform.pojo.config;

/**   
 * @Title: Entity
 * @Description: 自动生成表的列属性
 * @author jueyue
 * @date 2013-06-30 11:37:32
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class CgFormFieldPojo implements java.io.Serializable {
	/**id*/
	private String id;
	/**字段名称*/
	private String fieldName;
	/**关联的表*/
	private String tableId;
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
	public String getTableId(){
		return this.tableId;
	}

	/**
	 *方法: 设置TablePropertyEntity
	 *@param: TablePropertyEntity  关联的表ID
	 */
	public void setTableId(String tableId){
		this.tableId = tableId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  字段长度
	 */
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
	public String getDictText() {
		return dictText;
	}

	public void setDictText(String dictText) {
		this.dictText = dictText;
	}

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
