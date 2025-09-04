package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMsgGenerator {
	
	public WishMsgGenerator()
	{
		System.out.println("WishMsgGenerator::0-param constructor");
	}
	@Autowired
	@Qualifier("ltime2")
	private LocalTime time;
	
	public String showWishMsgGenerator(String user)
	{
		int hour=time.getHour();
		
		if(hour<12)
			return "GOOD MORNING "+user;
		else if(hour<16)
			return "GOOD AFTERNOON "+user;
		else if(hour<20)
			return "GOOD EVENING "+user;
		else
			return "GOOD NIGHT "+user;
	}
}
