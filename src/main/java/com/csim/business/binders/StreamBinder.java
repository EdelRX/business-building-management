package com.csim.business.binders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface StreamBinder {

	String INPUT = "input";

	@Input(StreamBinder.INPUT)
	SubscribableChannel input();
}
