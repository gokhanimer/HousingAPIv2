package com.restapps.HousingAPI.controller;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.service.ListingService;

@RunWith(SpringRunner.class)
@WebMvcTest
class HousingAPIListingControllerTests {

	@Autowired
    MockMvc mockMvc;
	
	private Listing listing;
    private List<Listing> listingList;

    @InjectMocks
    ListingController listingController;

    @MockBean
    ListingService listingService;
	
	
}
