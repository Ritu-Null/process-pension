package com.digitalhonors.processpension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.digitalhonors.processpension.model.PensionDetail;
import com.digitalhonors.processpension.repository.ProcessRepository;

@Service
public class ProcessPensionService {

	@Autowired
	ProcessRepository processRepository;
	
	public PensionDetail calculatePension(double aadharNumber, double salaryEarned, double allowance, String pensionType,
			String bankType) {
		/*
		 * Self pension: 80% of the last salary earned + allowances Family pension: 50%
		 * of the last salary earned + allowances Public banks – INR 500 Private banks –
		 * INR 550
		 */
		
		double pensionAmount=0;
		double bankServiceCharge=0;
		
		double totalAmount=salaryEarned+allowance;
		if(pensionType.equalsIgnoreCase("self")) 
			 pensionAmount=(totalAmount*80)/100;
		else if(pensionType.equalsIgnoreCase("family")) 
			 pensionAmount=(totalAmount*50)/100;
		
		
		if(bankType.equalsIgnoreCase("public"))
			bankServiceCharge=500;
		else if(bankType.equalsIgnoreCase("private"))
			bankServiceCharge=550;
		
		return new PensionDetail(aadharNumber, pensionAmount, bankServiceCharge);
		
	}

	public void saveOrUpdatePension(PensionDetail pensionDetail)   	{  
		
	processRepository.save(pensionDetail);  	
		
	} 

}
