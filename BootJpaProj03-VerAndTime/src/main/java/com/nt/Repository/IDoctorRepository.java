package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
