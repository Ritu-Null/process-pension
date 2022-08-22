package com.digitalhonors.processpension.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalhonors.processpension.model.PensionerDetail;

@FeignClient(value="feignServiceUtil",url="${NETWORK_URI:http://localhost:8080/pension-management/pensioner}")
public interface FeignServiceUtil {
	
	@GetMapping("/home")
	String isRunning();

	@GetMapping("/isValid")
	PensionerDetail searchAadhar(@RequestParam("aadharNumber") double aadharNumber);
	
	@GetMapping("/calculatePension")
	List<Object> fetchAllowanceAndSalary(@RequestParam("aadharNumber") double aadharNumber);
	

} 