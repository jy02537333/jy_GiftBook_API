package com.jeecg.service.impl.giftbook;
import com.jeecg.entity.giftbook.ReceivingGiftsMoneyEntity;
import com.jeecg.service.giftbook.ReceivingGiftsMoneyServiceI;
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

@Service("receivingGiftsMoneyService")
@Transactional
public class ReceivingGiftsMoneyServiceImpl extends CommonServiceImpl implements ReceivingGiftsMoneyServiceI {

	
 	public void delete(ReceivingGiftsMoneyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ReceivingGiftsMoneyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ReceivingGiftsMoneyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ReceivingGiftsMoneyEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(ReceivingGiftsMoneyEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(ReceivingGiftsMoneyEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(ReceivingGiftsMoneyEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("gourpmemberid", t.getGourpmemberid());
		map.put("groupmember", t.getGroupmember());
		map.put("isexpenditure", t.getIsexpenditure());
		map.put("money", t.getMoney());
		map.put("expendituretype", t.getExpendituretype());
		map.put("expendituretypename", t.getExpendituretypename());
		map.put("correlativeinvitation", t.getCorrelativeinvitation());
		map.put("expendituredate", t.getExpendituredate());
		map.put("remark", t.getRemark());
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
 	public String replaceVal(String sql,ReceivingGiftsMoneyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{gourpmemberid}",String.valueOf(t.getGourpmemberid()));
 		sql  = sql.replace("#{groupmember}",String.valueOf(t.getGroupmember()));
 		sql  = sql.replace("#{isexpenditure}",String.valueOf(t.getIsexpenditure()));
 		sql  = sql.replace("#{money}",String.valueOf(t.getMoney()));
 		sql  = sql.replace("#{expendituretype}",String.valueOf(t.getExpendituretype()));
 		sql  = sql.replace("#{expendituretypename}",String.valueOf(t.getExpendituretypename()));
 		sql  = sql.replace("#{correlativeinvitation}",String.valueOf(t.getCorrelativeinvitation()));
 		sql  = sql.replace("#{expendituredate}",String.valueOf(t.getExpendituredate()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
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