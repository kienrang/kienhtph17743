package com.sof3021.assignment.beans;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
	private String email;
	private String address;
	private List<Integer> product_id;
	private List<Integer> quantity;
}
