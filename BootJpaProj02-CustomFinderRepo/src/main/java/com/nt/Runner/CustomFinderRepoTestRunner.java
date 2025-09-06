package com.nt.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Doctor;
import com.nt.Repository.IDoctorRepository;

@Component
public class CustomFinderRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/*List<Doctor> doc=docRepo.findByDnameEquals("Rohan");
		doc.forEach(v->{
			System.out.println(v);
		});*/
		
		//docRepo.findByDnameStartingWith("R").forEach(System.out::println);
		
		//docRepo.findByDnameLike("S%").forEach(System.out::println);
		
		//docRepo.findByFeeBetween(20000.0, 28000.0).forEach(System.out::println);
		
		//docRepo.findByDnameStartingWithAndFeeBetween("R", 20000.0, 25000.0).forEach(System.out::println);
		
		docRepo.findByFeeBetweenOrderByDnameAsc(20000.0, 25000.0).forEach(System.out::println);
	}

}
