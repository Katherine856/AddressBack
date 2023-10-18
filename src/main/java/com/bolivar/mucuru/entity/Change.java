package com.bolivar.mucuru.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CHANGE_ADDRESS")
public class Change {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="K_ID")
	private Integer idChange;
	
	@Column(name="PREVIOUS_CHANGE", nullable = false, length = 400)
	private String previousAddress;
	
	@Column(name="DATE_CHANGE", nullable = false)
	private Date dateChange;
	
	@Column(name="TYPE_CHANGE", nullable = false, length = 50)
	private String typeChange;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_USER")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_ADDRESS")
	private Address address;

	public Integer getIdChange() {
		return idChange;
	}

	public void setIdChange(Integer idChange) {
		this.idChange = idChange;
	}

	public String getPreviousAddress() {
		return previousAddress;
	}

	public void setPreviousAddress(String previousAddress) {
		this.previousAddress = previousAddress;
	}

	public Date getDateChange() {
		return dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public String getTypeChange() {
		return typeChange;
	}

	public void setTypeChange(String typeChange) {
		this.typeChange = typeChange;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
