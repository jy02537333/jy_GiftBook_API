package com.jeecg.service.cms;

import org.jeecgframework.core.common.service.CommonService;
import com.jeecg.entity.cms.CmsArticleEntity;

import java.util.List;
import java.util.Map;

public interface CmsArticleServiceI extends CommonService {
	public List<CmsArticleEntity> list(CmsArticleEntity cmsArticleEntity);

	public List<CmsArticleEntity> list(CmsArticleEntity cmsArticleEntity,
                                       int page, int rows);

	@SuppressWarnings("unchecked")
	public List<CmsArticleEntity> listByMap(Map params);

	public List<CmsArticleEntity> listByMap(Map params, int page, int rows);

	public int getCount(Map params);
	
	public CmsArticleEntity getCmsArticleEntity(String id);
}
