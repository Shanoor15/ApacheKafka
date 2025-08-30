package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public final class ElectricEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("ElectricEngine.started");

	}

	@Override
	public void stopEngine() {
		System.out.println("ElectricEngine.stoped");

	}

}
