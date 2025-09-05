package com.nt.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="JPA_DOCTOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {
@Column(name="DOCTOR_ID")
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
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
@Transient
	private Double fee;
}
