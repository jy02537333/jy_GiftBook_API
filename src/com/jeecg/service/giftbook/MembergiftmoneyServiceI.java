package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.MembergiftmoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface MembergiftmoneyServiceI extends CommonService{
	
 	public void delete(MembergiftmoneyEntity entity) throws Exception;
 	
 	public Serializable save(MembergiftmoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MembergiftmoneyEntity entity) throws Exception;
 	
}
