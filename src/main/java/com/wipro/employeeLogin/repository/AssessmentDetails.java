package com.wipro.employeeLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wipro.employeeLogin.model.AssessmentRegistration;

public interface AssessmentDetails extends JpaRepository<AssessmentRegistration,Integer> {

}
