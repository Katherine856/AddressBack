package com.bolivar.mucuru.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_ADDRESS")
public class User {
	
	@Id
	@Column(name="K_ID")
	private Integer idUser;
	
	@Column(name="PASSWORD", nullable = false, length = 16)
	private String password;
	
	@Column(name="TYPE_USER", nullable = false, length = 20)
	private String typeUser;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Change> change;

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

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Set<Change> getChange() {
		return change;
	}

	public void setChange(Set<Change> change) {
		this.change = change;
	}
	
	
}
