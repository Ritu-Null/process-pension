package com.digitalhonors.processpension.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.digitalhonors.processpension.model.PensionDetail;
import com.digitalhonors.processpension.model.PensionerDetail;
import com.digitalhonors.processpension.service.ProcessPensionService;
import com.digitalhonors.processpension.util.FeignServiceUtil;


@RestController
@RequestMapping("/process")
@CrossOrigin("http://localhost:4200")
public class ProcessPensionController {
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProcessPensionController.class);

	@Autowired
	private FeignServiceUtil feignServiceUtil;

	@Autowired
	private ProcessPensionService processPensionService;
    
	

	@GetMapping("/status")
	public String serverStatus() {
		return feignServiceUtil.isRunning();
	}

 


	@GetMapping("/isValid")
	public ResponseEntity<Object> isValidDetail(@RequestParam("aadharNumber") double aadharNumber) {
		logger.info("Checking if "+aadharNumber+" is a valid aadhar number.");

		ResponseEntity<Object> entity=null;
		try {
		PensionerDetail pensionerDetail = feignServiceUtil.searchAadhar(aadharNumber);
		double salaryEarned=pensionerDetail.getSalaryEarned();
		double allowance=pensionerDetail.getAllowance();
		String pensionType=pensionerDetail.getPensionType();
		String bankType=pensionerDetail.getBankType();
		logger.info("Calculating pension for aadhar number: "+aadharNumber);
		PensionDetail pensionDetail =processPensionService.calculatePension(aadharNumber,salaryEarned,allowance,pensionType, bankType);
		logger.info("Saving calculated pension for aadhar number: "+aadharNumber);
		processPensionService.saveOrUpdatePension(pensionDetail);
		entity= new ResponseEntity<Object>(pensionDetail,HttpStatus.OK);
		}
		catch (Exception e) {
			logger.warn("Not data available with the aadhar number: "+ e.getMessage());
			entity = new ResponseEntity<Object>("Invalid pensioner detail provided, please provide valid detail.",HttpStatus.NOT_FOUND);
		}
	  
		return entity;
	}

}
