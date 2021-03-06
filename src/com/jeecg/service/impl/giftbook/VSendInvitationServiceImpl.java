package com.jeecg.service.impl.giftbook;
import com.jeecg.service.giftbook.VSendInvitationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.entity.giftbook.VSendInvitationEntity;
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

@Service("vSendInvitationService")
@Transactional
public class VSendInvitationServiceImpl extends CommonServiceImpl implements VSendInvitationServiceI {

	
 	public void delete(VSendInvitationEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VSendInvitationEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VSendInvitationEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VSendInvitationEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VSendInvitationEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(VSendInvitationEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(VSendInvitationEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("manname", t.getManname());
		map.put("womanname", t.getWomanname());
		map.put("state", t.getState());
		map.put("create_date", t.getCreatedate());
		map.put("create_by", t.getCreateby());
		map.put("create_name", t.getCreatename());
		map.put("inviterid", t.getInviterid());
		map.put("inviterphone", t.getInviterphone());
		map.put("feastaddress", t.getFeastaddress());
		map.put("feastdate", t.getFeastdate());
		map.put("coverimg", t.getCoverimg());
		map.put("photoalbum", t.getPhotoalbum());
		map.put("feasttype", t.getFeasttype());
		map.put("num", t.getNum());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VSendInvitationEntity t){
 		sql  = sql.replace("#{manname}",String.valueOf(t.getManname()));
 		sql  = sql.replace("#{womanname}",String.valueOf(t.getWomanname()));
 		sql  = sql.replace("#{state}",String.valueOf(t.getState()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreatedate()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateby()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreatename()));
 		sql  = sql.replace("#{inviterid}",String.valueOf(t.getInviterid()));
 		sql  = sql.replace("#{inviterphone}",String.valueOf(t.getInviterphone()));
 		sql  = sql.replace("#{feastaddress}",String.valueOf(t.getFeastaddress()));
 		sql  = sql.replace("#{feastdate}",String.valueOf(t.getFeastdate()));
 		sql  = sql.replace("#{coverimg}",String.valueOf(t.getCoverimg()));
 		sql  = sql.replace("#{photoalbum}",String.valueOf(t.getPhotoalbum()));
 		sql  = sql.replace("#{feasttype}",String.valueOf(t.getFeasttype()));
 		sql  = sql.replace("#{num}",String.valueOf(t.getNum()));
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