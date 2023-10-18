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
@Table(name="COUNTRY")
public class Country {
	
	@Id
	@Column(name="K_ID")
	private Integer idCountry;
	
	@Column(name="NAME", nullable = false, length = 50)
	private String nameCountry;
	
	@Column(name="FORMAT", nullable = false, length = 400)
	private String format;
	
	@Column(name="IMAGE", nullable = false, length = 100)
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Geographicaldivision> geographicalDivision;

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Geographicaldivision> getGeographicalDivision() {
		return geographicalDivision;
	}

	public void setGeographicalDivision(Set<Geographicaldivision> geographicalDivision) {
		this.geographicalDivision = geographicalDivision;
	}
	
}
