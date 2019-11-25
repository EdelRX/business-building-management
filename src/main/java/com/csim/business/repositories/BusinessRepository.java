package com.csim.business.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csim.business.model.BusinessModel;

@Repository
public interface BusinessRepository extends MongoRepository<BusinessModel,Long>{

}
