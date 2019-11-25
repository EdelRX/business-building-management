package com.csim.business.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.csim.business.requests.BusinessBuildRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BusinessItemReader implements ItemReader<BusinessBuildRequest> {

	private BusinessBuildRequest businessBuildRequest; //Object to be read, must be set before reader execution

	private boolean batchJobState; //This variable will be handlded to avoid loop step run as: item read not null --> run step

	public void setBusinessBuildRequest(BusinessBuildRequest businessBuildRequest) {
		this.businessBuildRequest = businessBuildRequest;
	}
	
	public void setBatchJobState(boolean batchJobState) {
		this.batchJobState = batchJobState;
	}

	@Override
	public BusinessBuildRequest read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (!batchJobState) {
			log.info("Entering business item reader...");
			batchJobState = true;
			return businessBuildRequest;
		} else {
			return null;
		}
	}

}
