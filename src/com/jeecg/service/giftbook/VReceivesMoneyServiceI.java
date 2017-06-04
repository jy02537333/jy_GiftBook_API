package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VReceivesMoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 收到礼金
 */
public interface VReceivesMoneyServiceI extends CommonService{
	
 	public void delete(VReceivesMoneyEntity entity) throws Exception;
 	
 	public Serializable save(VReceivesMoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VReceivesMoneyEntity entity) throws Exception;
 	
}
