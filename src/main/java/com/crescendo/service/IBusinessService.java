package com.crescendo.service;

import java.util.List;

import com.crescendo.model.Business;

public interface IBusinessService {
	public List<Business> getAllBusiness();
	public List<Business> getAllBusinessByParams(String businessName, String address, String sortBy);
	public Business getBusinessById(int id );
	public Business addBusiness(Business business);
	public Business updateBusiness(Business business, int id);
	public void deleteBusinessById(int id);
}
