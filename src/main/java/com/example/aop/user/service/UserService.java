package com.example.aop.user.service;

import com.example.aop.user.domain.User;

import java.util.List;

public interface UserService {

	List<User> getUsers();

	void update(User user) throws Exception;
}
