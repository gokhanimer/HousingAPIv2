package com.restapps.HousingAPI.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapps.HousingAPI.exception.ListingCommonException;
import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.repo.ListingRepo;

@Service
public class ListingServiceImpl implements ListingService{

	
	@Autowired
	ListingRepo repo;
	
	
	@Override
	public Listing addListing(Listing listing) throws ListingCommonException {
		Optional<Listing> opt = repo.findById(listing.getListingId());
		if(opt.isPresent()) {
			throw new ListingCommonException("Listing already exists");
			
		} else {
			repo.save(listing);
			return listing;
		}
	}

	@Override
	public boolean deleteListing(int listingId) throws ListingCommonException {
		Optional<Listing> opt = repo.findById(listingId);
		if(opt.isPresent()) {
			repo.deleteById(listingId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Listing updateListing(Listing listing) throws ListingCommonException {
		Optional<Listing> opt = repo.findById(listing.getListingId());
		if(opt.isPresent()) {
			repo.save(listing);
			return listing;	
		} 
		
		return null;
	}

	@Override
	public List<Listing> viewAllListings() {
		return repo.findAll();
	}

}
