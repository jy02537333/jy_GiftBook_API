package com.jeecg.service.impl.cms;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeecg.service.cms.AdServiceI;

import java.util.List;
import java.util.Map;

@Service("adService")
@Transactional
public class AdServiceImpl extends CommonServiceImpl implements AdServiceI {
//	@Autowired
//	private CmsAdDao cmsAdDao;

	@Override
	public List list(Map params, int page, int rows) {
		return null;
	}

	@Override
	public List list(Map params) {
		return null;
	}

	@Override
	public List list(String adEntity) {
		return null;
	}

	@Override
	public List  list(String adEntity, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
}