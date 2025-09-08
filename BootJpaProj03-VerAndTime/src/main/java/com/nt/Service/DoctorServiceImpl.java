package com.nt.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Doctor;
import com.nt.Repository.IDoctorRepository;
@Service("docService")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository docRepo;
	@Override
	public String registerDoctor(Doctor doctor) {
		doctor.setCreatedBy(System.getProperty("user.name"));
		doctor.setActive_SW("active");
		int idVal=docRepo.save(doctor).getDid();
		return "Doctor is saved with this id   "+idVal;
	}
	@Override
	public Doctor showDoctorById(int id) {
		Optional<Doctor> doctor=docRepo.findById(id);
		if(doctor.isPresent())
		{
			return doctor.get();
		}
		throw new IllegalArgumentException("invalid id");
	}
	@Override
	public String modifyDoctorById(int id, double hikepercentage) {
		Optional<Doctor> opt=docRepo.findById(id);
		if(opt.isPresent())
		{
			Doctor doctor=opt.get();
			doctor.setFee(doctor.getFee()+doctor.getFee()*hikepercentage/100.0);
			doctor.setUpdatedBy(System.getProperty("user.name"));
			docRepo.save(doctor);
			return id+"  doctor fee is updated";
		}
		return id+"  doctor is not found for updation";
	}

}
