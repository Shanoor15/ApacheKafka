package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.ActorDetails;

@SpringBootApplication
public class BootIocProj08YmlFileApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootIocProj08YmlFileApplication.class, args);
		ActorDetails details=ctx.getBean("actor",ActorDetails.class);
		System.out.println(details);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
