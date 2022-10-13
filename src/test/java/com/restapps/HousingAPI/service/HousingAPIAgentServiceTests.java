package com.restapps.HousingAPI.service;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.restapps.HousingAPI.model.Agent;
import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.repo.AgentRepo;
import com.restapps.HousingAPI.repo.ListingRepo;

class HousingAPIAgentServiceTests {

	@InjectMocks
	AgentServiceImpl agentService;
	
	private Agent agent;
	private List<Agent> agentList;
	
	@Mock
	AgentRepo repo;
	
	
	
}
