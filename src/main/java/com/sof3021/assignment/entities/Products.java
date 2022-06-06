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

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private int price;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "available")
	private int available;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;
	
//	@ManyToOne
//	@JoinColumn(name = "ordersDetail_id")
//	private OderDetails orderDetail_id;
	
}
