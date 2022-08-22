package com.digitalhonors.processpension.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail {

	private String bankName;
	private double accountNumber;
	private String bankType;
	private int pensionerId;
	private double aadharNumber;
	private String name;
	private Date dob;
	private String pan;
	private Double salaryEarned;
	private Double allowance;
	private String pensionType;
	 

}
