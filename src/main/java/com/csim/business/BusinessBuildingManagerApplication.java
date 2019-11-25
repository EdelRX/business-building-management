package com.csim.business;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import com.csim.business.binders.StreamBinder;
import com.csim.business.model.BusinessModel;
import com.csim.business.processor.BusinessItemProcessor;
import com.csim.business.reader.BusinessItemReader;
import com.csim.business.requests.BusinessBuildRequest;
import com.csim.business.writer.BusinessItemWriter;

@SpringBootApplication
@EnableBinding(StreamBinder.class)
@EnableBatchProcessing
public class BusinessBuildingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessBuildingManagerApplication.class, args);
	}
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Bean
    public Job job(@Qualifier("step1") Step step1) {
        return jobBuilderFactory.get("myJob").start(step1).build();
    }
    
    @Bean
    protected Step step1(BusinessItemReader reader,
                         BusinessItemProcessor processor,
                         BusinessItemWriter writer) {
        return stepBuilderFactory.get("step1")
            .<BusinessBuildRequest, BusinessModel> chunk(100)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .allowStartIfComplete(true)
            .build();
    }
   
}
