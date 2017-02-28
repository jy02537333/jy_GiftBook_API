package org.jeecgframework.core.timer;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.jeecgframework.web.system.pojo.base.TSTimeTaskEntity;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerBean;

import com.jeecg.controller.giftbook.SmsSendCtrl;
import com.jeecg.entity.giftbook.InvitationlistEntity;
import com.jeecg.service.giftbook.InvitationlistServiceI;
/**
 * 在原有功能的基础上面增加数据库的读取
 * @author JueYue
 * @date 2013-9-22
 * @version 1.0
 */
public class DataBaseCronTriggerBean extends CronTriggerBean{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TimeTaskServiceI timeTaskService;
	@Autowired
	private InvitationlistServiceI invitationlistService;
	/**
	 * 读取数据库更新文件  111
	 */
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		TSTimeTaskEntity task = timeTaskService.findUniqueByProperty
				(TSTimeTaskEntity.class,"taskId",this.getName());
		if(task!=null&&task.getIsEffect().equals("1")
				&&!task.getCronExpression().equals(this.getCronExpression())){

			try {
				
				this.setCronExpression(task.getCronExpression());
			} catch (ParseException e) {
				// TODO 异常必须被处理
				e.printStackTrace();
			}

			DynamicTask.updateSpringMvcTaskXML(this,task.getCronExpression());
		}
	}

}
