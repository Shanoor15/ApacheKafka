package com.nt.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Producer.messageProducer;
import com.nt.Store.messageStore;

@RestController
@RequestMapping("/message-api")
public class KafkaMessageOperationsController {
	
	@Autowired
	private messageProducer producer;
	@Autowired
	private messageStore store;

	@GetMapping("/send")
	public ResponseEntity<String> setMessage(@RequestParam(name="message") String msg){
		//use repo
		String resultMsg=producer.sendMessage(msg);
		//return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		return  ResponseEntity.ok(resultMsg);//same meaning
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<String>> showAllMessages(){
		//use repo
		List<String> list=store.showAllMessages();
		//return new ResponseEntity<List<String>>(list,HttpStatus.OK);
		return ResponseEntity.ok(list);
	}
}
