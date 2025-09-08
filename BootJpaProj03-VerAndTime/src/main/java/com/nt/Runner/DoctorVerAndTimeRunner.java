package com.nt.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Doctor;
import com.nt.Service.IDoctorService;

@Component
public class DoctorVerAndTimeRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService docService;
	@Override
	public void run(String... args) throws Exception {
		try {
			Doctor doctor=new Doctor("Suresh","delhi","cardio",1000.0);
			String msg=docService.registerDoctor(doctor);
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}
		
		/*try {
			Doctor doc=docService.showDoctorById(2);
			System.out.println(doc);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			String msg=docService.modifyDoctorById(52, 10.0);
			System.out.println(msg);
			Doctor doc=docService.showDoctorById(52);
			System.out.println("update count::"+doc.getUpdateCount()+"inserted on "+doc.getRegisterOn()+",lastlyupdate On  "+doc.getLastlyupdateOn());
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/

	}

}
