package com.jeecg.service.giftbook;
import com.jeecg.entity.giftbook.GroupmemberEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface GroupmemberServiceI extends CommonService{
	
 	public void delete(GroupmemberEntity entity) throws Exception;
 	
 	public Serializable save(GroupmemberEntity entity) throws Exception;
 	
 	public void saveOrUpdate(GroupmemberEntity entity) throws Exception;
 	
}
