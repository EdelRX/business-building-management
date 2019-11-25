package com.csim.business.listeners;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.csim.business.binders.StreamBinder;
import com.csim.business.controller.BusinessController;
import com.csim.business.reader.BusinessItemReader;
import com.csim.business.requests.BusinessBuildRequest;
import com.csim.business.service.BusinessService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaStreamListener {

	@Autowired
	BusinessService businessService;
	
	@Autowired
    JobLauncher jobLauncher;
	
	@Autowired
	Job job;

	@StreamListener(StreamBinder.INPUT)
	public void process(String event) {

		log.info("Running job...");
		try {
			jobLauncher.run(job, new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
