package com.entity;

import lombok.Data;

@Data
public class Contact {
	
	private Long id;
	private String email;
	private String contactName;
	private Long userId;
	public Contact(Long id, String email, String contactName, Long userId) {
		super();
		this.id = id;
		this.email = email;
		this.contactName = contactName;
		this.userId = userId;
	}
	
	
	
}
