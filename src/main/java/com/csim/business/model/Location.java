package com.csim.business.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Location implements Serializable{

	private static final long serialVersionUID = 6830648192915727356L;
	
	private int xCoord;
	private int yCoord;
}

