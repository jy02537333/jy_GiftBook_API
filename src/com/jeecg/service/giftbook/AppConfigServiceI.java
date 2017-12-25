package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.AppConfigEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AppConfigServiceI extends CommonService{
	
 	public void delete(AppConfigEntity entity) throws Exception;
 	
 	public Serializable save(AppConfigEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AppConfigEntity entity) throws Exception;
 	
}
