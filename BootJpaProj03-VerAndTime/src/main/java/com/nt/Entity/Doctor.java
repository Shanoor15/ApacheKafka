package com.nt.Entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="DOCTOR_ver_time")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {
@Column(name="DOCTOR_ID")
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
/*@SequenceGenerator(name="gen1",sequenceName="CNO_DOCTOR",initialValue=100,allocationSize=1)
@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)*/
//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer did;
@Column(name="DOCTOR_DNAME",length=20)
@NonNull
	private String dname;
@Column(name="DOCTOR_ADDRS",length=20)
@NonNull
	private String addrs;
@Column(name="DOCTOR_EXPERT",length=20)
@NonNull
	private String expert;
@Column(name="DOCTOR_FEE")
@NonNull
//@Transient
	private Double fee;

//Metadata properties
@Version
private Integer updateCount;
@CreationTimestamp
@Column(updatable=false,insertable=true)
private LocalDateTime registerOn;
@UpdateTimestamp
@Column(updatable=true,insertable=false)
private LocalDateTime lastlyupdateOn;
@Column(length=30)
private String createdBy;
@Column(length=30)
private String updatedBy;
@Column(length=30)
private String active_SW;
}
