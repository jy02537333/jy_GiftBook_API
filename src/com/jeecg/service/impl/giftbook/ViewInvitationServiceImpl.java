package com.jeecg.service.impl.giftbook;

import com.jeecg.entity.giftbook.ViewInvitationEntity;
import com.jeecg.service.giftbook.ViewInvitationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("viewInvitationService")
@Transactional
public class ViewInvitationServiceImpl extends CommonServiceImpl implements ViewInvitationServiceI {

	
 	public void delete(ViewInvitationEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ViewInvitationEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ViewInvitationEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ViewInvitationEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(ViewInvitationEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(ViewInvitationEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(ViewInvitationEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("inviterid", t.getInviterid());
		map.put("feastaddress", t.getFeastaddress());
		map.put("feastdate", t.getFeastdate());
		map.put("feasttype", t.getFeasttype());
		map.put("invitername", t.getInvitername());
		map.put("state", t.getState());
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
 	public String replaceVal(String sql,ViewInvitationEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{inviterid}",String.valueOf(t.getInviterid()));
 		sql  = sql.replace("#{feastaddress}",String.valueOf(t.getFeastaddress()));
 		sql  = sql.replace("#{feastdate}",String.valueOf(t.getFeastdate()));
 		sql  = sql.replace("#{feasttype}",String.valueOf(t.getFeasttype()));
 		sql  = sql.replace("#{invitername}",String.valueOf(t.getInvitername()));
 		sql  = sql.replace("#{state}",String.valueOf(t.getState()));
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