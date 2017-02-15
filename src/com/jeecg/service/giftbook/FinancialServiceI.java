package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.FinancialEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FinancialServiceI extends CommonService{
	
 	public void delete(FinancialEntity entity) throws Exception;
 	
 	public Serializable save(FinancialEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FinancialEntity entity) throws Exception;
 	
}
