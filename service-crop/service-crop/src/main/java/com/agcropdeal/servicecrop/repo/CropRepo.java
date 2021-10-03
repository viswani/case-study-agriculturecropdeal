package com.agcropdeal.servicecrop.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.agcropdeal.servicecrop.models.Crop;

public interface CropRepo extends MongoRepository<Crop,String> {

	Optional<Crop> findByCategory(String category);
	List<Crop> findByFarmerId(String farmerId);

	
	
}
