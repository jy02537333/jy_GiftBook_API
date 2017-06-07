package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VSendInvitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VSendInvitationServiceI extends CommonService{
	
 	public void delete(VSendInvitationEntity entity) throws Exception;
 	
 	public Serializable save(VSendInvitationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VSendInvitationEntity entity) throws Exception;
 	
}
