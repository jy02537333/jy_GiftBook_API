package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.ReceivesInvitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ReceivesInvitationServiceI extends CommonService{
	
 	public void delete(ReceivesInvitationEntity entity) throws Exception;
 	
 	public Serializable save(ReceivesInvitationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ReceivesInvitationEntity entity) throws Exception;
 	
}
