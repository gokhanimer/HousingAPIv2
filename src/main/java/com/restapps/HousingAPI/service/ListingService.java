package com.restapps.HousingAPI.service;

import java.util.List;


import com.restapps.HousingAPI.exception.ListingCommonException;
import com.restapps.HousingAPI.model.Listing;

public interface ListingService {

	public Listing addListing(Listing listing) throws ListingCommonException; 
	
	public boolean deleteListing(int listingId) throws ListingCommonException;
	
	public Listing updateListing(Listing listing) throws ListingCommonException;
	
	public List<Listing> viewAllListings();
	
}
