package com.nt.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Doctor;
import com.nt.Repository.IDoctorRepository;

@Component
public class CustomQueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/*List<Doctor> list=docRepo.showDoctorSpecialization("Orthopedic", " Pediatrician", "Oncologist");
		list.forEach(System.out::println);*/
		
		/*docRepo.showDoctorByAddrsAndSpecialize("pune", "Gastroenterologist").forEach(System.out::println);
		
		System.out.println("===========================================");
		
		docRepo.showDoctorByfee(18000.0, 25000.0).forEach(row->{
			for(Object val:row)
			{
				System.out.print(val+"   ");
			}
			System.out.println();
		});
		
		System.out.println("==================================================");
		docRepo.showDoctorByChar("S%").forEach(System.out::println);*/
		
		int count=docRepo.sameAddrsDoctors("pune");
		System.out.println(count);
		System.out.println("=========================================");
		Object[] result=(Object[]) docRepo.fetchAgregationData();
		for(Object val:result) {
			System.out.println(val);
			
			
		}
	}

}
