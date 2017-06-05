package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VReceivingMoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VReceivingMoneyServiceI extends CommonService{
	
 	public void delete(VReceivingMoneyEntity entity) throws Exception;
 	
 	public Serializable save(VReceivingMoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VReceivingMoneyEntity entity) throws Exception;
 	
}
