package com.csim.business.requests;

import java.io.Serializable;

import lombok.Data;

@Data
public class BusinessBuildRequest implements Serializable{
	
	private static final long serialVersionUID = -6376067619488297559L;
	
	private String type;
	private String subType;
	private Double budget;
	private int horizontalCoord;
	private int verticalCoord;
}
