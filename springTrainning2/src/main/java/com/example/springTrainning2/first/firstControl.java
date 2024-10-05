package com.example.springTrainning2.first;

import java.util.Date;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @RestController: This annotation is a specialized version of @Controller and 
 * is used to create RESTful web services. 
 * It combines @Controller and @ResponseBody annotations,
 *  which means that methods in this class will
 *  return data directly in the response body,
 *  rather than resolving to a view.
 */

@RestController
public class firstControl {
   //// @GetMapping("/") : This maps HTTP GET requests to the root URL (/) to this method.
   @GetMapping("/")
   public String home() {
       return "welcome to something";
   }

   @GetMapping("/time")
   public String time() {
       return "the time is " + new Date().toString();
   }

   @GetMapping("/hello")
   public ResponseEntity<String> hello() {
       HttpHeaders headers = new HttpHeaders();
       headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE);
       return new ResponseEntity<>("<h1>Hello</h1>", headers, HttpStatus.OK);
   }
   
   @GetMapping("/dice")
   public String dice(){
   	String[] dices = {"1","2","3","4","5","6"};
   	Random random = new Random();
   	int index = random.nextInt(dices.length);
   	return dices[index];
   }
 
   
   
}
