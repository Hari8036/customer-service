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
@Table(name="PURCHASE")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="PURCHASEID")
	private Long purchaseId;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="QUANTITY")
	private double quantity;
	

	@ManyToOne
	//@JoinColumn(name = "CUSTOMER_ID")
	@JoinTable(name="Delivery_Table",joinColumns = {@JoinColumn(name="PURCHASEID")},inverseJoinColumns = 
	{@JoinColumn(name="CUSTOMER_ID")})
	@JsonBackReference
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public Purchase(Long purchaseId, double price, double quantity, Customer customer) {
		super();
		this.purchaseId = purchaseId;
		this.price = price;
		this.quantity = quantity;
		this.customer = customer;
	}
	public Purchase() {
		super();
	}
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", price=" + price + ", quantity=" + quantity + ", customer="
				+ customer + "]";
	}
	
}



