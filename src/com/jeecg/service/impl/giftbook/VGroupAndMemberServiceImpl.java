package com.jeecg.service.impl.giftbook;
import com.jeecg.service.giftbook.VGroupAndMemberServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.entity.giftbook.VGroupAndMemberEntity;
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

@Service("vGroupAndMemberService")
@Transactional
public class VGroupAndMemberServiceImpl extends CommonServiceImpl implements VGroupAndMemberServiceI {

	
 	public void delete(VGroupAndMemberEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VGroupAndMemberEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VGroupAndMemberEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VGroupAndMemberEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VGroupAndMemberEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(VGroupAndMemberEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(VGroupAndMemberEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupid", t.getGroupid());
		map.put("isdefault", t.getIsdefault());
		map.put("groupmembersnum", t.getGroupmembersnum());
		map.put("groupname", t.getGroupname());
		map.put("createdate", t.getCreatedate());
		map.put("id", t.getId());
		map.put("groupmember", t.getGroupmember());
		map.put("totalmoney", t.getTotalmoney());
		map.put("memberphone", t.getMemberphone());
		map.put("affiliatedperson", t.getAffiliatedperson());
		map.put("affiliatedpersonid", t.getAffiliatedpersonid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VGroupAndMemberEntity t){
 		sql  = sql.replace("#{groupid}",String.valueOf(t.getGroupid()));
 		sql  = sql.replace("#{isdefault}",String.valueOf(t.getIsdefault()));
 		sql  = sql.replace("#{groupmembersnum}",String.valueOf(t.getGroupmembersnum()));
 		sql  = sql.replace("#{groupname}",String.valueOf(t.getGroupname()));
 		sql  = sql.replace("#{createdate}",String.valueOf(t.getCreatedate()));
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{groupmember}",String.valueOf(t.getGroupmember()));
 		sql  = sql.replace("#{totalmoney}",String.valueOf(t.getTotalmoney()));
 		sql  = sql.replace("#{memberphone}",String.valueOf(t.getMemberphone()));
 		sql  = sql.replace("#{affiliatedperson}",String.valueOf(t.getAffiliatedperson()));
 		sql  = sql.replace("#{affiliatedpersonid}",String.valueOf(t.getAffiliatedpersonid()));
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