package com.sof3021.assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_details")
@Data
public class OderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "orderDetails")
	private Orders orders;
	
	
	@ManyToOne()
	@JoinColumn(name = "oroderDetails")
	private Products products;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;
	
	
}
