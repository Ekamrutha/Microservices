package com.wipro.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.wipro.Login.model.UserLogin;
import com.wipro.Login.model.userType;
import com.wipro.Login.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService s;

	@GetMapping("/")
	public String Login() {
		return "index";
	}

	@PostMapping("/status")
	public String loginStatus(@RequestParam("userId") int userId, @RequestParam("password") String password,
			@RequestParam("UserType") userType UserType) {
		UserLogin details = s.searchUserDetails(userId);
		if (details != null && details.getPassword().equals(password) && details.getUserType() == UserType
				&& UserType == userType.Admin)
			return "successPageAdmin";

		else if (details != null && details.getPassword().equals(password) && details.getUserType() == UserType
				&& UserType == userType.Employee)
			return "successPageEmployee";

		else
			return "failurePage";

	}

	@GetMapping("/ProceedAdmin")
	public RedirectView ConnectAdmin() {
		RedirectView connectToAdmin = s.ConnectToAdmin();
		return connectToAdmin;

	}

	@GetMapping("/ProceedEmployee")
	public RedirectView ConnectEmployee() {
		RedirectView connectToEmployee = s.ConnectToEmployee();
		return connectToEmployee;

	}

}
