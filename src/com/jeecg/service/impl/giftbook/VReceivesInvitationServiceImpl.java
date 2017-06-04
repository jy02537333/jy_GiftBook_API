package com.jeecg.service.impl.giftbook;
import com.jeecg.entity.giftbook.VReceivesInvitationEntity;
import com.jeecg.service.giftbook.VReceivesInvitationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
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

@Service("vReceivesInvitationService")
@Transactional
public class VReceivesInvitationServiceImpl extends CommonServiceImpl implements VReceivesInvitationServiceI {

	
 	public void delete(VReceivesInvitationEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VReceivesInvitationEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VReceivesInvitationEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VReceivesInvitationEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VReceivesInvitationEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(VReceivesInvitationEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(VReceivesInvitationEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("inviterid", t.getInviterid());
		map.put("receivinggiftsname", t.getReceivinggiftsname());
		map.put("feastdate", t.getFeastdate());
		map.put("feasttype", t.getFeasttype());
		map.put("coverimg", t.getCoverimg());
		map.put("manname", t.getManname());
		map.put("womanname", t.getWomanname());
		map.put("summoney", t.getSummoney());
		map.put("sumcount", t.getSumcount());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VReceivesInvitationEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{inviterid}",String.valueOf(t.getInviterid()));
 		sql  = sql.replace("#{receivinggiftsname}",String.valueOf(t.getReceivinggiftsname()));
 		sql  = sql.replace("#{feastdate}",String.valueOf(t.getFeastdate()));
 		sql  = sql.replace("#{feasttype}",String.valueOf(t.getFeasttype()));
 		sql  = sql.replace("#{coverimg}",String.valueOf(t.getCoverimg()));
 		sql  = sql.replace("#{manname}",String.valueOf(t.getManname()));
 		sql  = sql.replace("#{womanname}",String.valueOf(t.getWomanname()));
 		sql  = sql.replace("#{summoney}",String.valueOf(t.getSummoney()));
 		sql  = sql.replace("#{sumcount}",String.valueOf(t.getSumcount()));
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