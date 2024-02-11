package com.wipro.employeeLogin.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.employeeLogin.model.UserLogin;

public interface UserDetails extends CrudRepository<UserLogin, Integer> {

}
