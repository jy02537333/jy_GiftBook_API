package com.jeecg.service.impl.giftbook;
import com.jeecg.service.giftbook.VInvitationListAndGroupServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.entity.giftbook.VInvitationListAndGroupEntity;
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

@Service("vInvitationListAndGroupService")
@Transactional
public class VInvitationListAndGroupServiceImpl extends CommonServiceImpl implements VInvitationListAndGroupServiceI {

	
 	public void delete(VInvitationListAndGroupEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VInvitationListAndGroupEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VInvitationListAndGroupEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VInvitationListAndGroupEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VInvitationListAndGroupEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(VInvitationListAndGroupEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(VInvitationListAndGroupEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("inviteeid", t.getInviteeid());
		map.put("inviteename", t.getInviteename());
		map.put("inviteephone", t.getInviteephone());
		map.put("groupname", t.getGroupname());
		map.put("gourpid", t.getGourpid());
		map.put("invitationid", t.getInvitationid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VInvitationListAndGroupEntity t){
 		sql  = sql.replace("#{inviteeid}",String.valueOf(t.getInviteeid()));
 		sql  = sql.replace("#{inviteename}",String.valueOf(t.getInviteename()));
 		sql  = sql.replace("#{inviteephone}",String.valueOf(t.getInviteephone()));
 		sql  = sql.replace("#{groupname}",String.valueOf(t.getGroupname()));
 		sql  = sql.replace("#{gourpid}",String.valueOf(t.getGourpid()));
 		sql  = sql.replace("#{invitationid}",String.valueOf(t.getInvitationid()));
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