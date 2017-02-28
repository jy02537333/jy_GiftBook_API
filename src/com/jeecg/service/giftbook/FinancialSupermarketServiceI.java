package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.FinancialSupermarketEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FinancialSupermarketServiceI extends CommonService{
	
 	public void delete(FinancialSupermarketEntity entity) throws Exception;
 	
 	public Serializable save(FinancialSupermarketEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FinancialSupermarketEntity entity) throws Exception;
 	
}
