package com.restapps.HousingAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Listing {
	
	@Id
	int listingId;
	
	String residentalType;	
	String address;
	String city;
	String status;
	int rooms;
	int indoorSize;
	int outdoorSize;
	boolean balcony;
	boolean elevator;
	
	int listingPrice;
	int monthlyFee;
	
	int agentId;

	
	public Listing() {
		
	}

	public Listing(int listingId, String residentalType, String address, String city, String status, int rooms,
			int indoorSize, int outdoorSize, boolean balcony, boolean elevator, int listingPrice, int monthlyFee,
			int agentId) {
		this.listingId = listingId;
		this.residentalType = residentalType;
		this.address = address;
		this.city = city;
		this.status = status;
		this.rooms = rooms;
		this.indoorSize = indoorSize;
		this.outdoorSize = outdoorSize;
		this.balcony = balcony;
		this.elevator = elevator;
		this.listingPrice = listingPrice;
		this.monthlyFee = monthlyFee;
		this.agentId = agentId;
	}



	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getResidentalType() {
		return residentalType;
	}

	public void setResidentalType(String residentalType) {
		this.residentalType = residentalType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getIndoorSize() {
		return indoorSize;
	}

	public void setIndoorSize(int indoorSize) {
		this.indoorSize = indoorSize;
	}

	public int getOutdoorSize() {
		return outdoorSize;
	}

	public void setOutdoorSize(int outdoorSize) {
		this.outdoorSize = outdoorSize;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public int getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(int listingPrice) {
		this.listingPrice = listingPrice;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Listing [listingId=" + listingId + ", residentalType=" + residentalType + ", address=" + address
				+ ", city=" + city + ", status=" + status + ", rooms=" + rooms + ", indoorSize=" + indoorSize
				+ ", outdoorSize=" + outdoorSize + ", balcony=" + balcony + ", elevator=" + elevator + ", listingPrice="
				+ listingPrice + ", monthlyFee=" + monthlyFee + ", agentId=" + agentId + "]";
	}


	
	
}
