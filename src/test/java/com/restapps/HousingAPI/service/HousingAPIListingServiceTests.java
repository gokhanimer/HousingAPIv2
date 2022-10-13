package com.restapps.HousingAPI.service;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.repo.ListingRepo;

class HousingAPIListingServiceTests {

	@InjectMocks
	ListingServiceImpl listingService;
	
	private Listing listing;
	private List<Listing> listingList;
	
	@Mock
	ListingRepo repo;
	
}
