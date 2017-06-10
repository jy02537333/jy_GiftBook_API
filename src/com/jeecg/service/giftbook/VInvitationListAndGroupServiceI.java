package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.VInvitationListAndGroupEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VInvitationListAndGroupServiceI extends CommonService{
	
 	public void delete(VInvitationListAndGroupEntity entity) throws Exception;
 	
 	public Serializable save(VInvitationListAndGroupEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VInvitationListAndGroupEntity entity) throws Exception;
 	
}
