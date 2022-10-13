package com.restapps.HousingAPI.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapps.HousingAPI.exception.AgentCommonException;
import com.restapps.HousingAPI.model.Agent;
import com.restapps.HousingAPI.repo.AgentRepo;

@Service
public class AgentServiceImpl implements AgentService{

	
	@Autowired
	AgentRepo repo;
	
	@Override
	public Agent addAgent(Agent agent) throws AgentCommonException {
		Optional<Agent> optAgent = repo.findById(agent.getAgentId());
		if(optAgent.isEmpty()) {
			repo.save(agent);
			return agent;
		}
		throw new AgentCommonException("Agent already exists");
	}

	

	@Override
	public boolean deleteAgent(int agentId) throws AgentCommonException {
		Optional<Agent> optAgent = repo.findById(agentId);
		
		if(optAgent.isEmpty()) {
			throw new AgentCommonException("The agent is not availible");
		}
		repo.delete(optAgent.get());
		return true;
	}

	

	@Override
	public Agent updateAgent(Agent agent) throws AgentCommonException {
		Optional<Agent> optAgent = repo.findById(agent.getAgentId());
		if(optAgent.isPresent()) {
			repo.save(agent);
			return agent;
		}
		return null;
		
	}

	@Override
	public List<Agent> viewAllAgents() {
		return repo.findAll();
	}


}
