package com.nt.Service;

import com.nt.Entity.Doctor;

public interface IDoctorService {

public String registerDoctor(Doctor doctor);
public Doctor showDoctorById(int id);
public String modifyDoctorById(int id,double hikepercentage);

}
