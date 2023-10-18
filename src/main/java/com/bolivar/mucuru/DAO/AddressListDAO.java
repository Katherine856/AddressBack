package com.bolivar.mucuru.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressListDAO {

	@JsonProperty("idCountry")
	private Integer idCountry;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("infoAddress")
	private String infoAddress;

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfoAddress() {
		return infoAddress;
	}

	public void setInfoAddress(String infoAddress) {
		this.infoAddress = infoAddress;
	}
	
	
}
