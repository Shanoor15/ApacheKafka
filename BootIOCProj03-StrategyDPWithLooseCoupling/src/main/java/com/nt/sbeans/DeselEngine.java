package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DeselEngine implements IEngine {

	@Override
	public void startEngine() {
		System.out.println("DeselEngine.started");

	}

	@Override
	public void stopEngine() {
		System.out.println("DeselEngine.stoped");

	}

}
