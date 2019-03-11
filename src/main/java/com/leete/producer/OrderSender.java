package com.leete.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leete.domain.Order;

@Component
public class OrderSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendOrder(Order order) {
		
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageid());
		
		rabbitTemplate.convertAndSend("order-exchange", "order.abcd", order, correlationData);
	}
	
	

}
