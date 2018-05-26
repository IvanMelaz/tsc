package it.tsc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, WebRequest webRequest) {
		return "Greetings from Spring Boot!";
	}

}
