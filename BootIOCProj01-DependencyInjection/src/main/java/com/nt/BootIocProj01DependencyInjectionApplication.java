package com.nt;

import java.io.PrintStream;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication {
	
	public BootIocProj01DependencyInjectionApplication()
	{
		System.out.println("BootIocProj01DependencyInjectionApplication::0-param constructor");
	}
	
	@Bean("ldate")
	public LocalDate createLDate()
	{
		System.out.println("BootIocProj01DependencyInjectionApplication.createLDate()");
		return LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println("BootIocProj01DependencyInjectionApplication.main()(START)");
		//get ioc container
		ApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		//which cls create IOC container
		System.out.println("which cls create IOC container="+ctx.getClass());
		//get target spring bean cls obj ref
		SeasonFinder season=ctx.getBean("sf",SeasonFinder.class);
		//invoke b.method
		String msg=season.showSeason();
		System.out.println("Season name="+msg);
		
		//close the ioc container
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("BootIocProj01DependencyInjectionApplication.main()(END)");
	}

}
