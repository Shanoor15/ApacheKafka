package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootIocProj02StrategyDpApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootIocProj02StrategyDpApplication.class, args);
		Vehicle obj=ctx.getBean("vehicle",Vehicle.class);
		obj.Journey("warangal","LBSANA");
		((ConfigurableApplicationContext) ctx).close();
	}

}
