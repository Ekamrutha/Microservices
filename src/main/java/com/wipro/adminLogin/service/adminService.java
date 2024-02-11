package com.wipro.adminLogin.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.adminLogin.model.AssessmentRegistration;

@Service
public class adminService {
	@Autowired
	RestTemplate rt;
	@Autowired
	private DiscoveryClient dc;

	@Value("${pivotal.emplogin.name}")
	String emplogin;

	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		List<ServiceInstance> instances = dc.getInstances(emplogin);
		URI uri = instances.get(0).getUri();
		String url = uri.toString() + "/findAll";
		List<AssessmentRegistration> result = rt.getForObject(url, List.class);
		mv.addObject("AssessmentRegistration", result);
		mv.setViewName("registeredDetails");
		return mv;

	}
}
