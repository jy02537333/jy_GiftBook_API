package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.SidekickergroupEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SidekickergroupServiceI extends CommonService{
	
 	public void delete(SidekickergroupEntity entity) throws Exception;
 	
 	public Serializable save(SidekickergroupEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SidekickergroupEntity entity) throws Exception;
 	
}
