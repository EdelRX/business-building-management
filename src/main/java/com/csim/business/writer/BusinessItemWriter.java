package com.csim.business.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csim.business.model.BusinessModel;
import com.csim.business.repositories.BusinessRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BusinessItemWriter implements ItemWriter<BusinessModel>{
	
	@Autowired
	BusinessRepository businessRepository;

	@Override
	public void write(List<? extends BusinessModel> items) throws Exception {
		log.info("Entering business item writer...");
		for(BusinessModel businessModel : items) {
			businessRepository.save(businessModel);
		}
	}

}
