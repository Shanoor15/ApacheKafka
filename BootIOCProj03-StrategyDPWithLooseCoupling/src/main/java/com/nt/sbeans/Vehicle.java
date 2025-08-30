package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {
	
	@Autowired
	@Qualifier("motor")
	private IEngine engine;
	
	//b,method
	public void Journey(String start,String stop)
	{
		engine.startEngine();
		System.out.println("Journey started at "+start);
		System.out.println("Joureny is going from "+start+" to "+stop);
		engine.stopEngine();
		System.out.println("Journey started at "+stop);
	}

}
