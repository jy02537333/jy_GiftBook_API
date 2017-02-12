package com.jeecg.service.impl.giftbook;
import com.jeecg.service.giftbook.SysUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.entity.giftbook.SysUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("sysUserService")
@Transactional
public class SysUserServiceImpl extends CommonServiceImpl implements SysUserServiceI {

	
 	public void delete(SysUserEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(SysUserEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(SysUserEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(SysUserEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(SysUserEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(SysUserEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(SysUserEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("userphone", t.getUserphone());
		map.put("portrait", t.getPortrait());
		map.put("username", t.getUsername());
		map.put("loginname", t.getLoginname());
		map.put("loginpassword", t.getLoginpassword());
		map.put("useremail", t.getUseremail());
		map.put("provinceid", t.getProvinceid());
		map.put("province", t.getProvince());
		map.put("cityid", t.getCityid());
		map.put("city", t.getCity());
		map.put("districtid", t.getDistrictid());
		map.put("district", t.getDistrict());
		map.put("detailaddress", t.getDetailaddress());
		map.put("loginflag", t.getLoginflag());
		map.put("qqopenid", t.getQqopenid());
		map.put("wxopenid", t.getWxopenid());
		map.put("sinaopenid", t.getSinaopenid());
		map.put("create_date", t.getCreateDate());
		map.put("create_by", t.getCreateBy());
		map.put("create_name", t.getCreateName());
		map.put("update_date", t.getUpdateDate());
		map.put("update_by", t.getUpdateBy());
		map.put("update_name", t.getUpdateName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,SysUserEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{userphone}",String.valueOf(t.getUserphone()));
 		sql  = sql.replace("#{portrait}",String.valueOf(t.getPortrait()));
 		sql  = sql.replace("#{username}",String.valueOf(t.getUsername()));
 		sql  = sql.replace("#{loginname}",String.valueOf(t.getLoginname()));
 		sql  = sql.replace("#{loginpassword}",String.valueOf(t.getLoginpassword()));
 		sql  = sql.replace("#{useremail}",String.valueOf(t.getUseremail()));
 		sql  = sql.replace("#{provinceid}",String.valueOf(t.getProvinceid()));
 		sql  = sql.replace("#{province}",String.valueOf(t.getProvince()));
 		sql  = sql.replace("#{cityid}",String.valueOf(t.getCityid()));
 		sql  = sql.replace("#{city}",String.valueOf(t.getCity()));
 		sql  = sql.replace("#{districtid}",String.valueOf(t.getDistrictid()));
 		sql  = sql.replace("#{district}",String.valueOf(t.getDistrict()));
 		sql  = sql.replace("#{detailaddress}",String.valueOf(t.getDetailaddress()));
 		sql  = sql.replace("#{loginflag}",String.valueOf(t.getLoginflag()));
 		sql  = sql.replace("#{qqopenid}",String.valueOf(t.getQqopenid()));
 		sql  = sql.replace("#{wxopenid}",String.valueOf(t.getWxopenid()));
 		sql  = sql.replace("#{sinaopenid}",String.valueOf(t.getSinaopenid()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}