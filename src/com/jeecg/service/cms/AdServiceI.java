package com.jeecg.service.cms;

import org.jeecgframework.core.common.service.CommonService;

import java.util.List;
import java.util.Map;

public interface AdServiceI extends CommonService {

	public List list(String adEntity);

	public List list(String adEntity, int page, int rows);

	public List list(Map params, int page, int rows);

	public List list(Map params);

}
