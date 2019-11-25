package com.csim.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csim.business.requests.BusinessBuildRequest;
import com.csim.business.service.BusinessService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("business-manager")
@Slf4j
public class BusinessController {
	
	@Autowired 
	BusinessService businessService;
	
	@PostMapping("business-build")
	public ResponseEntity<String> build(@RequestBody BusinessBuildRequest businessBuildRequest) {
		
		log.info("Adding business of type {},{}",businessBuildRequest.getType(),businessBuildRequest.getSubType());
		boolean result = businessService.buildBusiness(businessBuildRequest);
		
		if(result) {
			log.info("Added business of type {},{}",businessBuildRequest.getType(),businessBuildRequest.getSubType());
			return new ResponseEntity<>("Correctly added business", 
				      HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error adding business", 
				      HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
