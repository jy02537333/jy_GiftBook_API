package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VGroupAndMemberEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VGroupAndMemberServiceI extends CommonService{
	
 	public void delete(VGroupAndMemberEntity entity) throws Exception;
 	
 	public Serializable save(VGroupAndMemberEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VGroupAndMemberEntity entity) throws Exception;
 	
}
