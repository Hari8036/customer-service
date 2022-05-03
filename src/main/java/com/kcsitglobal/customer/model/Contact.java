package com.kcsitglobal.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CONTACT")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="Address")
	private String Address;
	
	@ManyToOne
	// @JoinColumn(name = "CUSTOMER_ID")
	@JoinTable(name = "Delivery_Table", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CUSTOMER_ID") })
	@JsonBackReference
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Contact(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
	}

	public Contact() {
		super();
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", Address=" + Address + "]";
	}
	

}
