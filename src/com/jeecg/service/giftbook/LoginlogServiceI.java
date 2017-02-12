package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.LoginlogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LoginlogServiceI extends CommonService{
	
 	public void delete(LoginlogEntity entity) throws Exception;
 	
 	public Serializable save(LoginlogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LoginlogEntity entity) throws Exception;
 	
}
