package com.leete.producer;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.leete.domain.Order;

@Controller
public class OrderSender {
	
	private final Logger logger = LoggerFactory.getLogger(OrderSender.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	ScheduledThreadPoolExecutor taskExecutor = new ScheduledThreadPoolExecutor(100);
	
	
	final ConfirmCallback confirmCallback = new ConfirmCallback() {
		
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			
			logger.info(correlationData.getId());
			
			if(ack) {
				logger.info("消息投递成功");
			}else {
				logger.info("消息投递失败");
			}
			
		}
	};
	
	
	private int i = 0;
	
	
	@Scheduled(cron="0/3 * 23 * * ?")
	//@Async("asynExecutor")
	public void sendOrder() {
		
		logger.info("开始sendOrder :  " + System.currentTimeMillis());
		
		CorrelationData correlationData = new CorrelationData();
		rabbitTemplate.setConfirmCallback(confirmCallback);
		
		Order order = new Order("order--", "hello Order");
		order.setMessageid(order.getId() + String.valueOf(i++));
		
		logger.info("order message：  " +  order.toString());
		
		
		correlationData.setId(order.getMessageid());
			
		rabbitTemplate.convertAndSend("order-exchange", "order.abcd", order, correlationData);
		
		
		logger.info("结束sendOrder :  " + System.currentTimeMillis());
	}
	
	

}
