package com.agcropdeal.servicecrop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agcropdeal.servicecrop.exception.ResourceNotFoundException;
import com.agcropdeal.servicecrop.models.Crop;
import com.agcropdeal.servicecrop.repo.CropRepo;

@RestController
@RequestMapping(value="/api")
@CrossOrigin( "http://localhost:3000")
public class CropController {
	@Autowired
	private CropRepo repo;
	@RequestMapping(value="/crop")
	public List<Crop> getAllCrop() {
		  return repo.findAll();
	  }
	@RequestMapping(value="/crop/{id}")
	  public ResponseEntity<Crop> getCrop(@PathVariable String id) {
		Crop crop=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Crop not exist with id :" + id));
		return ResponseEntity.ok(crop);
	  }
	@GetMapping("/crops/{farmerId}")
	public List<Crop> getByUserid(@PathVariable(value="farmerId") String farmerId) {
		return repo.findByFarmerId(farmerId);
		}
	
	
	@RequestMapping(value="/crop",method=RequestMethod.POST)
	  public Crop addCrop(@RequestBody Crop crop) {
		 Random random = new Random();
	        crop.setId((crop.getCropName() + crop.getPrice() +
	           crop.getQuant()+crop.getCategory()) + random.nextInt(1000));
		  return repo.save(crop);
	  }
	 @RequestMapping(value="/crop/{id}",method=RequestMethod.PUT)
	  public ResponseEntity<Crop> updateCrop(@PathVariable String id, @RequestBody Crop cropDetails) {
		  Crop crop=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException
                  ("Crop not exist with id :" + id));
		  crop.setCropName(cropDetails.getCropName());
		  crop.setPrice(cropDetails.getPrice());
		  crop.setQuant(cropDetails.getQuant());
		  crop.setCategory(cropDetails.getCategory());
		  Crop crop1=repo.save(crop);
		  return ResponseEntity.ok(crop1);
		  
	  }
	 @RequestMapping(value="/crop/{id}",method=RequestMethod.DELETE)
	  public  ResponseEntity<Map<String, Boolean>> deleteCrop(@PathVariable String id) {
		 Crop crop=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException
                 ("Crop not exist with id :" + id));
	    repo.delete(crop);
	    Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	  }
}
