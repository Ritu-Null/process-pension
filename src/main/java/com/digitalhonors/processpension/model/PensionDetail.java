package com.digitalhonors.processpension.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="pension_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PensionDetail {
	
@Id
@Column(name="aadhar_number")
private double aadharNumber;	

@Column(name="pension_amount")
private double pensionAmount;

@Column(name="service_charge")
private double bankServiceCharge;

}
