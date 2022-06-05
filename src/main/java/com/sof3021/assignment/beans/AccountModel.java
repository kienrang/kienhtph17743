package com.sof3021.assignment.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private String fullname;
	private String email;
	private String password;
	private String photo;
	private int activated;
}
