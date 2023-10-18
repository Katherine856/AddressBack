package com.bolivar.mucuru.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCT_SERVICE")
public class Product_Service {
	
	@Id
	@Column(name="K_ID")
	private Integer idProduct_Service;
	
	@Column(name="NAME", nullable = false, length = 50)
	private String nameProduct_Service;
	
	@Column(name="TYPE_PRODUCT_SERVICE", nullable = false, length = 15)
	private String typeProduct_Service;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "product_service")
	private List<Address> addresses;

	public Integer getIdProduct_Service() {
		return idProduct_Service;
	}

	public void setIdProduct_Service(Integer idProduct_Service) {
		this.idProduct_Service = idProduct_Service;
	}

	public String getNameProduct_Service() {
		return nameProduct_Service;
	}

	public void setNameProduct_Service(String nameProduct_Service) {
		this.nameProduct_Service = nameProduct_Service;
	}

	public String getTypeProduct_Service() {
		return typeProduct_Service;
	}

	public void setTypeProduct_Service(String typeProduct_Service) {
		this.typeProduct_Service = typeProduct_Service;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
