package com.sof3021.assignment.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "available")
	private int available;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Categories category;
	
	@OneToMany(mappedBy = "products")
	private List<OderDetails> oroderDetails;
}
