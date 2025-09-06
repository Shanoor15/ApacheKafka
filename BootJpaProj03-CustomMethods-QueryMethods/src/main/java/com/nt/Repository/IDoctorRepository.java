package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.Entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	//@Query("from Doctor where expert IN (?1,?2,?3) order by expert")
	//@Query("from Doctor where expert IN (?,?,?) order by expert")-->JDBC style parameters (?) are not supported for JPA queries
	@Query("from Doctor where expert IN (:sp1,:sp2,:sp3) order by expert")
	public List<Doctor> showDoctorSpecialization(String sp1,String sp2,String sp3);
	
	//Bulk SelectQuery
	@Query("From Doctor where addrs=:city AND expert=:sp")
	public List<Doctor> showDoctorByAddrsAndSpecialize(String city,String sp);
	
	//scalar Select Query(multiple col)
	@Query("select dname,fee,expert from Doctor where fee>=:min AND fee<=:max order by fee")
	public List<Object[]> showDoctorByfee(double min,double max);
	
	//scalar Select Query(single col)
	@Query("select dname from Doctor where dname LIKE :chars")
	public List<String> showDoctorByChar(String chars);
	
	//Aggregation Function
	@Query("SELECT count(d) from Doctor as d where d.dname=:name")
	public int sameAddrsDoctors(String name);
	@Query("SELECT count(d),max(d.fee),min(d.fee),avg(d.fee),sum(d.fee) from Doctor as d")
	public Object fetchAgregationData();
	
	
}

