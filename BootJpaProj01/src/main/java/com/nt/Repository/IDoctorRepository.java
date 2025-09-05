package com.nt.Repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.Entity.Doctor;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {

	
}
