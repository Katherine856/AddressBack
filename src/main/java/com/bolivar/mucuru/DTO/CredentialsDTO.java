package com.bolivar.mucuru.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsDTO {
	
	@JsonProperty("idUser")
	private Integer idUser = null;

	@JsonProperty("password")
	private String password = null;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
