package com.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	// fake user list
	// this is for testing but in real-life we are going to use database
	// for this purpose
	
	List<User> list = List.of(
			
			new User(1L,"Name 1","12345678"),
			new User(2L,"Name 2","999999999"),
			new User(3L,"Name 3","666666666")
			
			
			);

	@Override
	public User getUser(Long id) {
		return this.list.stream().filter(user -> user.getUserId().equals(id))
				.findAny()
				.orElse(null);
	}
	

}
