package com.example.aop.user.service;

import com.example.aop.user.domain.User;
import com.example.aop.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> getUsers() {
		long start = System.currentTimeMillis();
		List<User> users = repository.findAll();
		long end = System.currentTimeMillis();

		System.out.println("수행 시간 : "+ (end - start));
		return users;
	}
}
