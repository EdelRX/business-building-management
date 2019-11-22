package com.csim.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csim.business.requests.BusinessBuildRequest;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("business-manager")
@Slf4j
public class BusinessController {
	
	@PostMapping("business-build")
	public void build(@RequestBody BusinessBuildRequest businessBuildRequest) {
		
		log.info("Adding business of type {},{}",businessBuildRequest.getType(),businessBuildRequest.getSubType());
		
		
	}

}
