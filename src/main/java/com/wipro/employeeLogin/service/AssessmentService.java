package com.wipro.employeeLogin.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.wipro.employeeLogin.model.AssessmentList;
import com.wipro.employeeLogin.model.AssessmentRegistration;
import com.wipro.employeeLogin.model.AssessmentType;
import com.wipro.employeeLogin.model.UserLogin;
import com.wipro.employeeLogin.repository.AssessmentDetails;
import com.wipro.employeeLogin.repository.UserDetails;

@Service
public class AssessmentService {
	@Autowired
	private AssessmentDetails repo;
	@Autowired
	private CircuitBreakerFactory crb;
	@Autowired
	private UserDetails repository;

	public AssessmentRegistration Save(AssessmentRegistration a) {
		AssessmentRegistration ar = repo.save(a);
		return ar;

	}

	public UserLogin findbyId(int id) {
		UserLogin usr = null;
		Optional<UserLogin> findById = repository.findById(id);
		if (findById.isPresent())
			usr = findById.get();
		return usr;
	}

	public List<AssessmentRegistration> getDetails() {
		Iterable<AssessmentRegistration> Alldetails = repo.findAll();
		// return (List<AssessmentRegistration>) Alldetails;
		List<AssessmentRegistration> details = (List<AssessmentRegistration>) Alldetails;
		CircuitBreaker cb = crb.create("GetRegisteredDetailsCircuitBreaker");
		return (List<AssessmentRegistration>) cb.run(() -> details, throwable -> getdefaultList());
	}

	private List<AssessmentRegistration> getdefaultList() {
		List<AssessmentRegistration> dfl = new ArrayList<AssessmentRegistration>();
		dfl.add(new AssessmentRegistration(1002, AssessmentType.Behavioral, AssessmentList.stepPlus, LocalDate.now()));
		dfl.add(new AssessmentRegistration(1003, AssessmentType.Technical, AssessmentList.Angular, LocalDate.now()));
		dfl.add(new AssessmentRegistration(1005, AssessmentType.Technical, AssessmentList.Java, LocalDate.now()));
		return dfl;
	}
}
