package com.bolivar.mucuru.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="GEOGRAPHICALDIVISION")
public class Geographicaldivision {
	
	@Id
	@Column(name="K_ID", length = 10)
	private String idGeographicalDivision;
	
	@Column(name="NAME", nullable = false, length = 70)
	private String nameGeographicalDivision;
	
	@Column(name="TIMEZONE", nullable = false, length = 50)
	private String timeZone;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_COUNTRY")
	private Country country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "geographicalDivision", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Address> address;

	public String getIdGeographicalDivision() {
		return idGeographicalDivision;
	}

	public void setIdGeographicalDivision(String idGeographicalDivision) {
		this.idGeographicalDivision = idGeographicalDivision;
	}

	public String getNameGeographicalDivision() {
		return nameGeographicalDivision;
	}

	public void setNameGeographicalDivision(String nameGeographicalDivision) {
		this.nameGeographicalDivision = nameGeographicalDivision;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
}
