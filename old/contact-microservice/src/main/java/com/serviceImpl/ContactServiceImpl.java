package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.entity.Contact;
import com.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService {
	
	// fake data for contacts
	
	List<Contact> list = List.of(
			
			new Contact(11L,"1@email.com","user 1",1L),
			new Contact(12L,"2@email.com","user 2",2L),
			new Contact(13L,"3@email.com","user 3",3L)
			
			
			);

	
	// this method will collect all the contact of user and make them
	// as list and send back
	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId))
				.collect(Collectors.toList());
	}

}
