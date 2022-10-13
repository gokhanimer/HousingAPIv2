package com.restapps.HousingAPI.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapps.HousingAPI.exception.AgentCommonException;
import com.restapps.HousingAPI.model.Agent;
import com.restapps.HousingAPI.service.AgentService;

@RunWith(SpringRunner.class)
@WebMvcTest
class HousingAPIAgentControllerTests {

	@Autowired
    MockMvc mockMvc;
	
	private Agent agent;
    private List<Agent> agentList;

    @InjectMocks
    AgentController agentController;

    @MockBean
    AgentService agentService;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(agentController).build();
		
		agentList = new ArrayList<Agent>();
		agent = new Agent();
		agent.setAgentEmail("mike@realtor.com");
		agent.setAgentId(101);
		agent.setAgentName("Mike");
		agent.setAgentPhone(853454853);
		agent.setCity("Stockholm");
		agent.setFirmName("RealtorCo");		
		
	}
	
	@Test
	public void addAgentSucces() throws Exception {
		when(agentService.addAgent(agent)).thenReturn(agent);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/Agents/addAgent")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(agent)))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void addAgentFailure() throws Exception {
		when(agentService.addAgent(any())).thenThrow(AgentCommonException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/Agents/addAgent")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(agent)))
			.andExpect(MockMvcResultMatchers.status().isConflict())
			.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void deleteAgentSucces() throws Exception {
		when(agentService.deleteAgent(anyInt())).thenReturn(true);
		mockMvc.perform(
                MockMvcRequestBuilders.delete("/Agents/deleteAgent/101"))
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());
				
	}
	
	@Test
	public void deleteAgentFailure() throws Exception {
		when(agentService.deleteAgent(anyInt())).thenReturn(false);
		mockMvc.perform(
                MockMvcRequestBuilders.delete("/Agents/deleteAgent/102"))
		.andExpect(MockMvcResultMatchers.status().isNotFound())
        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void updateAgentSucces() throws Exception {
		when(agentService.updateAgent(agent)).thenReturn(agent);
		mockMvc.perform(MockMvcRequestBuilders.put("/Agents/updateAgent")
		.contentType(MediaType.APPLICATION_JSON)
		.content(toJson(agent)))
		.andExpect(MockMvcResultMatchers.status().isAccepted());
		
		
	}
	
	@Test
	public void updateAgentFailure() throws Exception {
		when(agentService.updateAgent(any())).thenThrow(AgentCommonException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/Agents/updateAgent")
		.contentType(MediaType.APPLICATION_JSON)
		.content(toJson(agent)))
		.andExpect(MockMvcResultMatchers.status().isConflict());
	}
	
	@Test
	public void retrieveAllAgentsSucces() throws Exception {
		
		 mockMvc.perform(
                 MockMvcRequestBuilders.get("/Agents/getAgents")
         )
         .andExpect(MockMvcResultMatchers.status().isOk());
		 
	}
	
	 public String toJson (Object obj) throws JsonProcessingException {
	        ObjectMapper objmap = new ObjectMapper();
	        return objmap.writeValueAsString(obj);
	    }
}
