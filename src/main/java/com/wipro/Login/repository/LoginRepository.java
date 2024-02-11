package com.wipro.Login.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.Login.model.UserLogin;

public interface LoginRepository extends CrudRepository<UserLogin, Integer> {

}
