package com.nt.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nt.Store.messageStore;

@Component
public class KafkaMessageListener {
	
	@Autowired
	private messageStore store;

	@KafkaListener(topics="${app.tpc.name}",groupId="grp1")
	public void readMessage(String msg) {
		//add the msg to store
		store.addMessage(msg);
	}
}
