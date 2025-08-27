package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	@Autowired
	private LocalDate date;
	
	public SeasonFinder()
	{
		System.out.println("SeasonFinder::0-param constructor");
	}
	
	//b.method
	public String showSeason()
	{
		System.out.println("SeasonFinder.showSeason()");
		int month=date.getMonthValue();
		if(month>=3 && month<=7)
			return "SUMMER SEASON";
		else if(month>=8 && month<=10)
			return "RAINY SEASON";
		else
			return "WINTER SEASON";
	}
}
