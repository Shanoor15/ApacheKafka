package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Doctor;
import com.nt.Repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("DoctorMgmtServiceImpl.registerDoctor():Proxy Class:: "+docRepo.getClass()+"..........."+Arrays.toString(docRepo.getClass().getInterfaces()));
		System.out.println("12 methods of Proxy class::"+Arrays.toString(docRepo.getClass().getDeclaredMethods()));
		Doctor saveDoctor=docRepo.save(doctor);
		int idVal=saveDoctor.getDid();
		return "Doctor is save with the id value" + idVal;
	}

	@Override
	public long countDoctors() {
		long con=docRepo.count();
		return con;
	}

	@Override
	public String registerDoctorsGroup(Iterable<Doctor> doctor) {
		//save the objs
		Iterable<Doctor> it=docRepo.saveAll(doctor);
		//collect id values of the save Doctors
		List<Integer> list=new ArrayList<>();
		//acessing the id's
		it.forEach(doc->{
			list.add(doc.getDid());
		});
		return list.size()+"no.of doctors saved/inserted with Id values::"+list;
	}

	@Override
	public String checkDoctorAvailabilityById(int id) {
		boolean flag=docRepo.existsById(id);
		return flag?"Doctor is Found":"Doctor is NotFound";
	}

	@Override
	public Iterable showAllDoctors() {
		Iterable it=docRepo.findAll();
		return it;
	}

	@Override
	public Iterable showAllDoctorsByIds(Iterable<Integer> ids) {
		return docRepo.findAllById(ids);
	}

	/*@Override
	public Doctor showDoctorById(int Id) {
		Optional<Doctor> opt=docRepo.findById(Id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Invalid Id");
	}*/
	
	//(OR)
	
	/*@Override
	public Doctor showDoctorById(int Id) {
		return docRepo.findById(Id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}*/
	
	@Override
	public Doctor showDoctorById(int Id) {
		return docRepo.findById(Id).orElse(new Doctor(0,"Duty Doctor","local","Emergency",1000.0));
	}
	@Override
	public String fetchDoctorById(int Id) {
		Optional<Doctor> opt=docRepo.findById(Id);
		if(opt.isPresent())
			return "Doctor is Found"+opt.get();
		else
			return "Doctor is NotFound";
	}

	@Override
	public String updateDoctorFeeById(int Id, double hikePercentage) {
		//check object is present by given Id
		Optional<Doctor> opt=docRepo.findById(Id);
		if(opt.isPresent()) {
			//get Entity obj
			Doctor doctor=opt.get();
			//update the fee with give hilepercentage
			doctor.setFee(doctor.getFee() + (doctor.getFee()*hikePercentage/100.0));
			//update obj
			docRepo.save(doctor);
			return doctor.getDid()+"  Doctor is Found and Updated ";
		}
		return "Doctor is NotFound and Updated";
	}

	@Override
	public String updateDoctor(Doctor doctor) {
		docRepo.save(doctor);
		return "Doctor saved/updated";
	}

	@Override
	public String removeDoctorById(int Id) {
		//Check the object availability
		boolean flag=docRepo.existsById(Id);
		if(flag)
		{
			docRepo.deleteById(Id);
			return Id+"Doctor is Found and Deleted";
		}
		return Id+"Doctor is Not Found and Not Deleted";
	}

	@Override
	public void removeDoctorById1(int id) {
		docRepo.deleteById(id);
	}

	@Override
	public String removeAllDoctors() {
		long count=docRepo.count();
		docRepo.deleteAll();
		return count+"  no.of records are found and deleted";
	}

	@Override
	public String removeDoctorsByIds(List<Integer> ids) {
		//load the objects by Ids
		Iterable<Doctor> it=docRepo.findAllById(ids);
		//get count of loaded objects
		long count=StreamSupport.stream(it.spliterator(), false).count();
		//delete the records
		docRepo.deleteAllById(ids);
		return count+"  no. of records found and deleted";
	}
}

