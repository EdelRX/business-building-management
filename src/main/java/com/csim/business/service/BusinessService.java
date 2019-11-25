package com.csim.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csim.business.model.BusinessModel;
import com.csim.business.model.Location;
import com.csim.business.repositories.BusinessRepository;
import com.csim.business.requests.BusinessBuildRequest;

@Service
public class BusinessService {
	
	@Autowired
	BusinessRepository businessRepository;

	public boolean buildBusiness(BusinessBuildRequest businessBuildRequest) {
		
		boolean result;
		
		try {		
		BusinessModel businessModel = new BusinessModel();
		
		businessModel.setType(businessBuildRequest.getType());
		businessModel.setSubType(businessBuildRequest.getSubType());
		businessModel.setBudget(businessBuildRequest.getBudget());
		
		Location location = new Location();
		
		location.setXCoord(businessBuildRequest.getHorizontalCoord());
		location.setYCoord(businessBuildRequest.getVerticalCoord());
		
		businessModel.setLocation(location);
		
		businessRepository.save(businessModel);
		
		result = true;
		
		}catch(Exception e) {
			result = false;
		}
		
		return result;
		
	}
}
