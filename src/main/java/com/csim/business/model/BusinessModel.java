package com.csim.business.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="business-management")
public class BusinessModel implements Serializable{
	
	private static final long serialVersionUID = 4624873170431571521L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger id;
	
	private String type;
	private String subType;
	private Double budget;
	private Location location;
}
