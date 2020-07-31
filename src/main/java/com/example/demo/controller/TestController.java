package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
	
	@RequestMapping(value = "/fetch/{message}", method = RequestMethod.GET)
	public String fetch(@PathVariable String message) {
		return "Hi!!! Got a message ::: "+ message;
	}

}
