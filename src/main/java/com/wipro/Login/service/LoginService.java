package com.wipro.Login.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.wipro.Login.model.UserLogin;
import com.wipro.Login.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository rep;
	@Autowired
	private DiscoveryClient dc;
	@Autowired
	private LoadBalancerClient loadbalancer;

	public UserLogin searchUserDetails(int userId) {
		UserLogin user = null;
		Optional<UserLogin> Logindetails = rep.findById(userId);
		if(Logindetails.isPresent())
		user = Logindetails.get();
		return user;
	}

	@Value("${pivotal.adminlogin.name}")
	String adminlogin;

	public RedirectView ConnectToAdmin() {
		//List<ServiceInstance> instances = dc.getInstances(adminlogin);
		//URI uri = instances.get(0).getUri();
		ServiceInstance instance = loadbalancer.choose(adminlogin);
		URI uri = instance.getUri();
		String url = uri.toString();
		RedirectView rv = new RedirectView();
		rv.setUrl(url);
		return rv;
	}

	@Value("${pivotal.emplogin.name}")
	String emplogin;

	public RedirectView ConnectToEmployee() {
		List<ServiceInstance> instances = dc.getInstances(emplogin);
		URI uri = instances.get(0).getUri();
		String url = uri.toString();
		RedirectView rv = new RedirectView();
		rv.setUrl(url);
		return rv;
	}

}
