package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
//can consider this as an Repository example
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(1, "Eve", new Date()));
		users.add(new User(1, "Jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> userIterator=users.iterator();
		while(userIterator.hasNext()) {
			User user=userIterator.next();
			if (user.getId() == id) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
