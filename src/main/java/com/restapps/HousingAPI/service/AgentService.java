package com.restapps.HousingAPI.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restapps.HousingAPI.exception.AgentCommonException;
import com.restapps.HousingAPI.model.Agent;

public interface AgentService {

	public Agent addAgent(Agent agent) throws AgentCommonException; 
	
	public boolean deleteAgent(int agentId) throws AgentCommonException;
	
	public Agent updateAgent(Agent agent) throws AgentCommonException;
	
	public List<Agent> viewAllAgents();
	
	
}
