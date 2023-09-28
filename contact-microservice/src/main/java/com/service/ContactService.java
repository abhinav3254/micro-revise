package com.service;

import java.util.List;

import com.entity.Contact;

public interface ContactService {

	public List<Contact> getContactsOfUser(Long userId);
	
}
