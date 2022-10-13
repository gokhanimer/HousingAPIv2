package com.restapps.HousingAPI.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restapps.HousingAPI.exception.AgentCommonException;
import com.restapps.HousingAPI.exception.ListingCommonException;
import com.restapps.HousingAPI.model.Agent;
import com.restapps.HousingAPI.model.Listing;
import com.restapps.HousingAPI.service.AgentService;

@CrossOrigin
@RestController
@RequestMapping("Agents/")
public class AgentController {
	
	@Autowired
	AgentService service;
	
    @PostMapping("/addAgent")
    public ResponseEntity<?> addAgent(@RequestBody Agent agent){
    	Agent result;
    	try {
			result = service.addAgent(agent);
			return new ResponseEntity<Agent>(result, HttpStatus.CREATED);
		} catch (AgentCommonException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
			}
    }
    
    @GetMapping("/getAgents")
    public ResponseEntity<?> getAgents(){
        List<Agent> agents = service.viewAllAgents();
        return new ResponseEntity<List<Agent>>(agents, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAgent/{agentId}")
    public ResponseEntity<?> deleteAgent(@PathVariable("listingId") int aid) throws AgentCommonException {
        boolean result = service.deleteAgent(aid);
        if(result){
            return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateAgent")
    public ResponseEntity<?> updateAgent(@RequestBody Agent updAgent){
    	Agent resp;
        try{
        	resp = service.updateAgent(updAgent);
            return new ResponseEntity<Agent>(resp, HttpStatus.ACCEPTED);
        }catch(AgentCommonException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
	



	

}
