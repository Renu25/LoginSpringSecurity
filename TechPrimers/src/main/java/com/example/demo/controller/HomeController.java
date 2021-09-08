package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HomeController {

	
	@GetMapping("/all")
	public String hello()
	{
		return "hello techprimers";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello()
	{
		return "Secured hello";
	}
	
	
}
