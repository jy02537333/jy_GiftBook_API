package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.SysUserEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SysUserServiceI extends CommonService{
	
 	public void delete(SysUserEntity entity) throws Exception;
 	
 	public Serializable save(SysUserEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SysUserEntity entity) throws Exception;
 	
}
