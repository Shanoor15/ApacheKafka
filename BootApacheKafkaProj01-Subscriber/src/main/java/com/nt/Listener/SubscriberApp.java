package com.nt.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriberApp {

	@KafkaListener(topics="${app.tpc.name}",groupId="grp2")
	public void readMessage(String msg)
	{
		System.out.println("Message::"+msg);
	}
}
