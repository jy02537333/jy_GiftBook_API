package weixin.idea.photo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import weixin.guanjia.menu.entity.MenuEntity;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 微相册
 * @author zhangdaihao
 * @date 2014-07-29 10:08:26
 * @version V1.0   
 *
 */
/**   
 * @Title: Entity
 * @Description: 微相册
 * @author zhangdaihao
 * @date 2014-07-29 10:08:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "weixin_photo_album", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class WeixinPhotoAlbumEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**相册名称*/
	private String name;
	/**相册描述*/
	private String content;
	/**accountid*/
	private String accountid;
	/**创建时间*/
	private Date createDate;
	/**创建人*/
	private String createBy;
	/**修改时间*/
	private Date updateDate;
	/**修改人*/
	private String updateBy;
	/**相片列表*/
	private List<WeixinPhotoEntity> photos; 
	private WeixinPhotoEntity photo;
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
	 *@return: java.lang.String  相册名称
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相册名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相册描述
	 */
	@Column(name ="CONTENT",nullable=true,length=255)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相册描述
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  accountid
	 */
	@Column(name ="ACCOUNTID",nullable=true,length=100)
	public String getAccountid(){
		return this.accountid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  accountid
	 */
	public void setAccountid(String accountid){
		this.accountid = accountid;
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
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_BY",nullable=true,length=32)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=32)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *相册相片列表
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public List<WeixinPhotoEntity> getPhotos() {
		return photos;
	}

	public void setPhotos(List<WeixinPhotoEntity> photos) {
		this.photos = photos;
	}
	@OneToOne(fetch=FetchType.LAZY)  
	@JoinColumn(name="PHOTO_ID")  
	public WeixinPhotoEntity getPhoto() {
		return photo;
	}

	public void setPhoto(WeixinPhotoEntity photo) {
		this.photo = photo;
	}
}
