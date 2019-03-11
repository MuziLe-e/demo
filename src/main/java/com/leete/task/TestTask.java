package com.leete.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	
	Logger logger = LoggerFactory.getLogger(TestTask.class);
	
	Long i = 0L;
	
	@Scheduled(cron="0/5 * * * * ?")
	public void autoRun() {
		
		logger.info((++i).toString());
	}

}
