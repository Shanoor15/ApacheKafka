package com.nt.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class messageStore {

	private List<String> list=new ArrayList();
	
	public void addMessage(String msg) {
		list.add(msg);
	}
	
	public List<String> showAllMessages(){
		return list;
	}
}
