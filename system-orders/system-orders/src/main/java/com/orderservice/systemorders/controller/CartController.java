package com.orderservice.systemorders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.orderservice.systemorders.model.Cart;
import com.orderservice.systemorders.repository.CartRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/apicart")
public class CartController {
  @Autowired
  CartRepository repo;
  @RequestMapping("/getall")
  public List<Cart> getCart(){
	  return repo.findAll();
  }
  @GetMapping("/carts/{dealerId}")
	public List<Cart> getByUserid(@PathVariable(value="dealerId") String dealerId) {
		return repo.findByDealerId(dealerId);
		}
  @RequestMapping(value="/addtocart",method=RequestMethod.POST)
  public void addOrders(@RequestBody Cart cart) {
	  repo.insert(cart);
  }

  @RequestMapping(value="/deletecart",method=RequestMethod.DELETE)
  public void deleteorders() {
    repo.deleteAll();
  }
  @RequestMapping(value="/cart/{id}",method=RequestMethod.DELETE)
  public void deleteCartDetails(@PathVariable String id) {
    repo.deleteById(id);
  }

  

}
