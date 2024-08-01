package com.example.springTrainning2;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class firstControl {
	@GetMapping("/")
	public String home() {
		return "welcome to something";
	}
	@GetMapping("/time")
	public String time() {
		return "the time is" + new Date().toString();
	}


	@GetMapping("/home1")
	public ResponseEntity<String> home1() {
	    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE);
	    return new ResponseEntity<>("<h1>Hello</h1>", headers, HttpStatus.OK);
	}

}