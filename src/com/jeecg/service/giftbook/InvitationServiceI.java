package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.InvitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface InvitationServiceI extends CommonService{
	
 	public void delete(InvitationEntity entity) throws Exception;
 	
 	public Serializable save(InvitationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(InvitationEntity entity) throws Exception;
 	
}
