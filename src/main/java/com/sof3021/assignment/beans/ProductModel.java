package com.sof3021.assignment.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private String name;
	private String price;
	private String date;
	private int quantity;
	private String image;
	
}
