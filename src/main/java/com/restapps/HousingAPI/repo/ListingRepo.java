package com.restapps.HousingAPI.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restapps.HousingAPI.model.Listing;

@Repository
public interface ListingRepo extends MongoRepository<Listing,Integer>{

}
