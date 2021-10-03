package com.agcropdeal.servicecrop.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agcropdeal.servicecrop.models.Farmer;

public interface FarmerRepo extends MongoRepository<Farmer,String> {

}
