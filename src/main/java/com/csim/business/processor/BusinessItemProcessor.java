package com.csim.business.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.csim.business.model.BusinessModel;
import com.csim.business.model.Location;
import com.csim.business.requests.BusinessBuildRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BusinessItemProcessor implements ItemProcessor<BusinessBuildRequest, BusinessModel> {

	@Override
	public BusinessModel process(BusinessBuildRequest item) throws Exception {
		
		log.info("Transforming BusinessModel into TransformedBusinessModel...");
		
		BusinessModel transformedBusinessModel = new BusinessModel();
		if (!item.getType().isEmpty()) {
			transformedBusinessModel.setType(item.getType().concat("_VERIFIED"));
		}
		if (!item.getSubType().isEmpty()) {
			transformedBusinessModel.setSubType(item.getSubType().concat("_VERIFIED"));
		}
		transformedBusinessModel.setBudget(item.getBudget());
		Location location = new Location();
		location.setXCoord(item.getHorizontalCoord());
		location.setYCoord(item.getVerticalCoord());
		
		transformedBusinessModel.setLocation(location);
		
		return transformedBusinessModel;
	}

}
