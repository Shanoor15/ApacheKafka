package com.nt.service;

import java.util.List;

import com.nt.Entity.Doctor;

public interface IDoctorMgmtService {

	public String registerDoctor(Doctor doctor);
	public long countDoctors();
	public String registerDoctorsGroup(Iterable<Doctor> doctor);
	public String checkDoctorAvailabilityById(int id);
	public Iterable showAllDoctors();
	public Iterable showAllDoctorsByIds(Iterable<Integer> ids);
	public Doctor showDoctorById(int Id);
	public String fetchDoctorById(int Id);
	public String updateDoctorFeeById(int Id,double hikePercentage);
	public String updateDoctor(Doctor doctor);
	public String removeDoctorById(int Id);
	public void removeDoctorById1(int id);
	public String removeAllDoctors();
	public String removeDoctorsByIds(List<Integer> ids);
}
