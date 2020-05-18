package com.microservices.customerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws InterruptedException {
		//Thread.sleep(10000);
		return "Inside Customer service";
	}
	
}
