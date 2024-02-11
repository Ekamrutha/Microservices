package com.wipro.employeeLogin.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wipro.employeeLogin.model.AssessmentList;
import com.wipro.employeeLogin.model.AssessmentRegistration;
import com.wipro.employeeLogin.model.AssessmentType;
import com.wipro.employeeLogin.model.UserLogin;
import com.wipro.employeeLogin.model.userType;
import com.wipro.employeeLogin.service.AssessmentService;

@Controller
public class AssessmentController {
	@Autowired
	private AssessmentService s;

	@GetMapping("/")
	public String Mainpage() {
		return "index";
	}

	@GetMapping("/technical")
	public String firstpage() {
		return "technical";
	}

	@GetMapping("/behavioral")
	public String secondpage() {
		return "behavioral";
	}

	@PostMapping("/technical/status")
	public String save(@ModelAttribute("userId") int uid, @ModelAttribute("Assessment") AssessmentList a,
			@ModelAttribute("date") String dt) {
		AssessmentRegistration ar1 = null;
		LocalDate date = LocalDate.parse(dt);
		UserLogin user = s.findbyId(uid);
		if (user.getUserType() == userType.Employee) {
			AssessmentRegistration ar = new AssessmentRegistration(uid, AssessmentType.Technical, a, date);
			ar1 = s.Save(ar);
		}
		if (ar1 != null)
			return "success";
		else
			return "failure";

	}

	@PostMapping("/behavioral/status")
	public String saveobj(@ModelAttribute("userId") int uid, @ModelAttribute("Assessment") AssessmentList a,
			@RequestParam("date") String dt) {
		LocalDate date = LocalDate.parse(dt);
		AssessmentRegistration ar1 = null;
		AssessmentRegistration ar = new AssessmentRegistration(uid, AssessmentType.Behavioral, a, date);
		ar1 = s.Save(ar);
		if (ar1 != null)
			return "success";
		else
			return "failure";

	}

	@GetMapping("/findAll")
	@ResponseBody
	public List<AssessmentRegistration> getAllDetails() {
		return s.getDetails();
	}
}
