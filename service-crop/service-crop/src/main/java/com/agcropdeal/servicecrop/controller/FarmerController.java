package com.agcropdeal.servicecrop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agcropdeal.servicecrop.models.Farmer;
import com.agcropdeal.servicecrop.repo.FarmerRepo;

@RestController
public class FarmerController {
	@Autowired
	private FarmerRepo frepo;
	@RequestMapping(value="/farmers")
	public List<Farmer> getAllFarmers() {
		  return frepo.findAll();
	  }
	@RequestMapping(value="/farmer/{id}")
	  public Optional<Farmer> getFarmer(@PathVariable String id) {
		return frepo.findById(id);
	  }
	@RequestMapping(value="/addfarmer",method=RequestMethod.POST)
	  public void addFarmer(@RequestBody Farmer far) {
		  frepo.insert(far);
	  }
	 @RequestMapping(value="/farmer/{id}",method=RequestMethod.PUT)
	  public void updateFarmer(@PathVariable String id, @RequestBody Farmer far) {
		  frepo.save(far);
	  }
	 @RequestMapping(value="/farmer/{id}",method=RequestMethod.DELETE)
	  public void deleteFarmer(@PathVariable String id) {
	    frepo.deleteById(id);
	  }

}
