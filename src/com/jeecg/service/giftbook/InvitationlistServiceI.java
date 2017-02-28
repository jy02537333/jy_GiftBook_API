package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.InvitationlistEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface InvitationlistServiceI extends CommonService{
	
 	public void delete(InvitationlistEntity entity) throws Exception;
 	
 	public Serializable save(InvitationlistEntity entity) throws Exception;
 	
 	public void saveOrUpdate(InvitationlistEntity entity) throws Exception;
 	
}
