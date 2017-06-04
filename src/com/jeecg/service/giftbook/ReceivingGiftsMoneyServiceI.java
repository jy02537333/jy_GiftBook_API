package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.ReceivingGiftsMoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ReceivingGiftsMoneyServiceI extends CommonService{
	
 	public void delete(ReceivingGiftsMoneyEntity entity) throws Exception;
 	
 	public Serializable save(ReceivingGiftsMoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ReceivingGiftsMoneyEntity entity) throws Exception;
 	
}
