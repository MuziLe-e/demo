package com.leete.demo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.leete.domain.Order;
import com.leete.producer.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	@Autowired
	private OrderSender orderSender;
	
	@Test
	public 	void testSendOrder() {
		Order order = new Order("34234224", "leete", System.currentTimeMillis()+ "$$" +UUID.randomUUID());
		
		
		//orderSender.sendOrder(order);
		
	}

}
