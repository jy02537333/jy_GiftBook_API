package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.ViewInvitationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ViewInvitationServiceI extends CommonService{

 	public void delete(ViewInvitationEntity entity) throws Exception;

 	public Serializable save(ViewInvitationEntity entity) throws Exception;

 	public void saveOrUpdate(ViewInvitationEntity entity) throws Exception;

}
