package com.crescendo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.model.Business;
import com.crescendo.service.IBusinessService;

@RestController
@RequestMapping("/api")
public class BusinessController {

	@Autowired
	IBusinessService businessService;

	@GetMapping("/businesses")
	public ResponseEntity<List<Business>> getAllBusinesses() {
		return new ResponseEntity<>(businessService.getAllBusiness(), HttpStatus.OK);
	}

	@GetMapping("/businesses/query")
	public ResponseEntity<List<Business>> getAllBusinessesByParams(
			@RequestParam(name = "businessName", required = false) String businessName,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "sortBy", required = false) String sortBy) {
		return new ResponseEntity<>(businessService.getAllBusinessByParams(businessName, address, sortBy),
				HttpStatus.OK);
	}

	@GetMapping("/businesses/{id}")
	public ResponseEntity<Business> getBusinessById(@PathVariable int id) {
		return new ResponseEntity<>(businessService.getBusinessById(id), HttpStatus.OK);
	}

	@PostMapping("/businesses")
	public ResponseEntity<Business> createBusiness(@RequestBody Business business) {
		return new ResponseEntity<>(businessService.addBusiness(business), HttpStatus.CREATED);
	}

	@PutMapping("/businesses/{id}")
	public ResponseEntity<Business> updateBusiness(@RequestBody Business business, @PathVariable int id) {
		return new ResponseEntity<>(businessService.updateBusiness(business, id), HttpStatus.OK);
	}

	@DeleteMapping("/businesses/{id}")
	public ResponseEntity<HttpStatus> deleteBusiness(@PathVariable int id) {
		businessService.deleteBusinessById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
