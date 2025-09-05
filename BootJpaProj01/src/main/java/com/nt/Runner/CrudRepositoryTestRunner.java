package com.nt.Runner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;

	@Override
	public void run(String... args) throws Exception {
		// preparing doctor obj with data
		/*Doctor doc=new Doctor();
		doc.setDname("raja");
		doc.setAddrs("hyd");
		doc.setExpert("Cardio");
		doc.setFee(20000.0);
		
		 doc.setDname("sneha"); 
		 doc.setAddrs("delhi"); 
		 doc.setExpert("Neurology");
		 doc.setFee(25000.0);
		
		doc.setDname("arjun");
		doc.setAddrs("mumbai");
		doc.setExpert("Orthopedic");
		doc.setFee(18000.0);*/

		// invoking service methods
		/*try {
			String msg=docService.registerDoctor(doc);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			long count=docService.countDoctors();
			System.out.println("Doctors count ::"+count);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/

		/*try {
			Doctor doc1=new Doctor("ramesh","warangal","Cardio",30000.0);
			Doctor doc2 = new Doctor("sneha", "delhi", "Neurology", 28000.0);
			Doctor doc3 = new Doctor("arjun", "mumbai", "Orthopedic", 25000.0);
			Doctor doc4 = new Doctor("meera", "chennai", "Dermatology", 22000.0);
			Doctor doc5 = new Doctor("vishal", "bangalore", null, 27000.0);
			List<Doctor> list=List.of(doc1,doc2);
			String msg=docService.registerDoctorsGroup(list);
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/

		/*try {
			String msg=docService.checkDoctorAvailabilityById(12053);
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/

		/*try {
			Iterable<Doctor> list=docService.showAllDoctors();
			//list.forEach(System.out::println);
			list.forEach(doc->{
				System.out.println(doc);
			});
			StreamSupport.stream(list.spliterator(),true).forEach(System.out::println);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			//Iterable<Doctor> it=docService.showAllDoctorsByIds(List.of(1155,1204,1205,null,500));//not allows null's(ERROR)
			Iterable<Doctor> it=docService.showAllDoctorsByIds(Arrays.asList(1155,1204,1205,null,500));
			it.forEach(System.out::println);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			Doctor doctor=docService.showDoctorById(11555);
			System.out.println("doctor details:"+doctor);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			String msg=docService.fetchDoctorById(1155);
			System.out.println("================================================================");
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			String msg=docService.updateDoctorFeeById(1253, 10.0);
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			Doctor doctor=new Doctor(1119,"syedSyed","pune","cardio",10000.0);
			String msg=docService.updateDoctor(doctor);
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
		
		/*try {
			String msg=docService.removeDoctorById(1119);
			System.out.println(msg);
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}*/
		
		/*try {
			docService.removeDoctorById1(1116);
			System.out.println("");
		}*/
		
		try {
			String msg=docService.removeAllDoctors();
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}
		
		/*try {
			String msg=docService.removeDoctorsByIds(List.of(101,102,1123,3445));
			System.out.println(msg);
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}*/
	}

}
