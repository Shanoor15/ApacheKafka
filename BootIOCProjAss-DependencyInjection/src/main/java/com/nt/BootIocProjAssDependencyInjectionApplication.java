package com.nt;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.nt.sbeans.WishMsgGenerator;

@SpringBootApplication
public class BootIocProjAssDependencyInjectionApplication {
	
	public BootIocProjAssDependencyInjectionApplication()
	{
		System.out.println("BootIocProjAssDependencyInjectionApplication::0-param costructor");
	}
	//@Primary
	@Bean("ltime1")
	public LocalTime createLTime()
	{
		System.out.println("ltime1()(EXECUTED)");
		return LocalTime.now();
	}
	
	@Bean("ltime2")
	public LocalTime createLTime1()
	{
		System.out.println("ltime2()(EXECUTED)");
		return LocalTime.of(14,30);
	}

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootIocProjAssDependencyInjectionApplication.class, args);
		WishMsgGenerator obj=ctx.getBean("wmg",WishMsgGenerator.class);
		String msg=obj.showWishMsgGenerator("shanoor");
		System.out.println("WishMessageGenerator: "+msg);
		((ConfigurableApplicationContext) ctx).close();
	}

}
