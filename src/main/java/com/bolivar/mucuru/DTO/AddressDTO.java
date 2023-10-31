package com.bolivar.mucuru.DTO;

import java.util.List;

import com.bolivar.mucuru.entity.Geographicaldivision;
import com.bolivar.mucuru.entity.Product_Service;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {

	@JsonProperty("idAddress")
	private Integer idAddress;
	
	@JsonProperty("geographicalDivision")
	private Geographicaldivision geographicalDivision;
	
	@JsonProperty("infoAddress")
	private String infoAddress;
	
	@JsonProperty("latitude")
	private Integer latitude ;
	
	@JsonProperty("longitude")
	private Integer longitude ;
	
	@JsonProperty("residential")
	private String residential;
	
	@JsonProperty("building")
	private String building;
	
	@JsonProperty("tower")
	private String tower;
	
	@JsonProperty("floor")
	private Integer floor;
	
	@JsonProperty("apartment")
	private Integer apartment;
	
	@JsonProperty("product_service")
	private List<Product_Service> product_service;
	
	public Integer getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}
	public Geographicaldivision getGeographicalDivision() {
		return geographicalDivision;
	}
	public void setGeographicalDivision(Geographicaldivision geographicalDivision) {
		this.geographicalDivision = geographicalDivision;
	}
	public String getInfoAddress() {
		return infoAddress;
	}
	public void setInfoAddress(String infoAddress) {
		this.infoAddress = infoAddress;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public String getResidential() {
		return residential;
	}
	public void setResidential(String residential) {
		this.residential = residential;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getApartment() {
		return apartment;
	}
	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}
	public List<Product_Service> getProduct_service() {
		return product_service;
	}
	public void setProduct_service(List<Product_Service> product_service) {
		this.product_service = product_service;
	}
	
}
