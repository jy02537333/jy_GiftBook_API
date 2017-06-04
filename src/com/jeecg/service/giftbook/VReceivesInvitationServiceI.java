package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VReceivesInvitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VReceivesInvitationServiceI extends CommonService{
	
 	public void delete(VReceivesInvitationEntity entity) throws Exception;
 	
 	public Serializable save(VReceivesInvitationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VReceivesInvitationEntity entity) throws Exception;
 	
}
