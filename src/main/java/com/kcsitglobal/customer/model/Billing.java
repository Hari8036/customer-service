package com.kcsitglobal.customer.model;

import java.util.Date;

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
@Table(name = "BILLING")
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "BILLNO")
	private Long billno;

	@Column(name = "BILLINGDATE")
	private Date billingDate;

	@ManyToOne
	// @JoinColumn(name = "CUSTOMER_ID")
	@JoinTable(name = "Delivery_Table", joinColumns = { @JoinColumn(name = "BILLNO") }, inverseJoinColumns = {
			@JoinColumn(name = "CUSTOMER_ID") })
	@JsonBackReference
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public Long getBillno() {
		return billno;
	}

	public void setBillno(Long billno) {
		this.billno = billno;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	@Override
	public String toString() {
		return "Billing [billno=" + billno + ", billingDate=" + billingDate + "]";
	}

	public Billing() {
		super();
	}

	
	
}
