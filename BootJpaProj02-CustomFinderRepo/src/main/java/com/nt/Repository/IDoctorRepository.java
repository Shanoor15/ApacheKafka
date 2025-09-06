package com.nt.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nt.Entity.Doctor;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {

	public List<Doctor> findByDnameEquals(String name);
	public List<Doctor> findByDnameStartingWith(String initname);
	public Iterable<Doctor> findByDnameLike(String name);
	public Iterable<Doctor> findByFeeBetween(Double min,Double max);
	public Iterable<Doctor> findByDnameStartingWithAndFeeBetween(String initname,double min,double max);
	public Iterable<Doctor> findByFeeBetweenOrderByDnameAsc(Double min,Double max);
}
