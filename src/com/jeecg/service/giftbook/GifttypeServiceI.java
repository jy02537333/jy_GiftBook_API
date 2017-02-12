package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.GifttypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface GifttypeServiceI extends CommonService{
	
 	public void delete(GifttypeEntity entity) throws Exception;
 	
 	public Serializable save(GifttypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(GifttypeEntity entity) throws Exception;
 	
}
