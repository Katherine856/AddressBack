package com.bolivar.mucuru.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="K_ID")
	private Integer idAddress;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_GEOGRAPHICALDIVISION")
	private Geographicaldivision geographicalDivision;
	
	@Column(name="INFO_ADDRESS", nullable = false, length = 100)
	private String infoAddress;
	
	@Column(name="LATITUDE", nullable = false)
	private Integer latitude ;
	
	@Column(name="LONGITUDE", nullable = false)
	private Integer longitude ;
	
	@Column(name="RESIDENTIAL", length = 50)
	private String residential;
	
	@Column(name="BUILDING", length = 50)
	private String building;
	
	@Column(name="TOWER", length = 1)
	private String tower;
	
	@Column(name="FLOOR")
	private Integer floor;
	
	@Column(name="APARTMENT")
	private Integer apartment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Change> change;
	
	@JoinTable(name = "ADDRESS_PRODUCT_SERVICE", 
			joinColumns = @JoinColumn(name = "FK_ID_ADDRESS", nullable = false, referencedColumnName = "K_ID"),
			inverseJoinColumns = @JoinColumn(name = "FK_ID_PRODUCT_SERVICE", nullable = false, referencedColumnName = "K_ID"))
	@ManyToMany(cascade = CascadeType.PERSIST)
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

	public Set<Change> getChange() {
		return change;
	}

	public void setChange(Set<Change> change) {
		this.change = change;
	}

	public List<Product_Service> getProduct_service() {
		return product_service;
	}

	public void setProduct_service(List<Product_Service> product_service) {
		this.product_service = product_service;
	}

								
}
