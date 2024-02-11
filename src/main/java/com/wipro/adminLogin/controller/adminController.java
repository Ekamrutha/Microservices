package com.wipro.adminLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.adminLogin.service.adminService;

@Controller
public class adminController {
	@Autowired
	private adminService as;

	@GetMapping("/")
	public String degaultPage() {
		return "index";
	}

	@GetMapping("/viewAll")
	public ModelAndView ViewAllDetails() {
		return as.getList();
	}
}
