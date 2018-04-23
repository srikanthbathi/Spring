package com.bathi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Advertisement {

	@GetMapping
	public String getDefault() {
		return "OK!";
	}
	
}
