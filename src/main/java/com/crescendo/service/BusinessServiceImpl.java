package com.crescendo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.exception.ResourceNotFoundException;
import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements IBusinessService {
	@Autowired
	BusinessRepository businessRepository;
	
	@Override
	public List<Business> getAllBusiness() {
		return (List<Business>) businessRepository.findAll();
	}
	
	@Override
	public Business getBusinessById(int id ) {
		return businessRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Business ID Not found = " + id));
	}
	
	@Override
	public Business addBusiness(Business business) {
		return businessRepository.save(business);
	}

	@Override
	public Business updateBusiness(Business business, int id) {
		Business updateBusiness = businessRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Business ID Not found = " + id));
		updateBusiness.setBusinessName(business.getBusinessName());
		updateBusiness.setAddress(business.getAddress());
		updateBusiness.setPhone(business.getPhone());
		return businessRepository.save(updateBusiness);
	}

	@Override
	public void deleteBusinessById(int id) {
		businessRepository.deleteById(id);
	}
}
