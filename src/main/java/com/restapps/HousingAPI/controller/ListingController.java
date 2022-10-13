package com.restapps.HousingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapps.HousingAPI.exception.ListingCommonException;
import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.service.ListingService;

@CrossOrigin
@RestController
@RequestMapping("Listings/")
public class ListingController {

	@Autowired
	ListingService service;
	
    @PostMapping("/addListing")
    public ResponseEntity<?> saveListing(@RequestBody Listing listing){
        Listing result;
        try{
        	result = service.addListing(listing);
            return new ResponseEntity<Listing>(result, HttpStatus.CREATED);
        }catch(ListingCommonException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getListings")
    public ResponseEntity<?> getRestaurants(){
        List<Listing> listings = service.viewAllListings();
        return new ResponseEntity<List<Listing>>(listings, HttpStatus.OK);
    }

    @DeleteMapping("/deleteListing/{listingId}")
    public ResponseEntity<?> delete(@PathVariable("listingId") int lid) throws ListingCommonException {
        boolean result = service.deleteListing(lid);
        if(result){
            return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateListing")
    public ResponseEntity<?> updateListing(@RequestBody Listing updListing){
    	Listing resp;
        try{
        	resp = service.updateListing(updListing);
            return new ResponseEntity<Listing>(resp, HttpStatus.ACCEPTED);
        }catch(ListingCommonException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
