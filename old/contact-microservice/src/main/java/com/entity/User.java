package com.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {
	
	private Long userId;
	private String name;
	private String phone;
	
	private List<Contact> contacts = new ArrayList<Contact>();

	public User(Long userId, String name, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}
	
	
	
}
