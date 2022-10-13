package com.restapps.HousingAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Agent {
	
	@Id
	int agentId;
	String agentName;
	int agentPhone;
	String agentEmail;
	String firmName;
	String city;
	
	
	public Agent() {
	}

	public Agent(int agentId, String agentName, int agentPhone, String agentEmail, String firmName, String city) {
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentPhone = agentPhone;
		this.agentEmail = agentEmail;
		this.firmName = firmName;
		this.city = city;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public int getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(int agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", agentPhone=" + agentPhone + ", agentEmail="
				+ agentEmail + ", firmName=" + firmName + ", city=" + city + "]";
	}
	
	
	
	
	
	

}
