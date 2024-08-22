package com.example.springTrainning2.todotask.Login;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springTrainning2.todotask.UserIdGenerator;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	 ArrayList<loginClass> todoList = new ArrayList<>();   

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/login/fail")
	public String loginFail(){
		return"login";
	}

	@GetMapping("/login/me")
	public String setCookie(Model model, HttpServletRequest req, HttpServletResponse resp,@RequestParam("username")String username ) {
//		loginClass list = new loginClass(username); 
		
		 boolean userExists = todoList.stream().anyMatch(todo -> todo.getUsername().equals(username));
//	if(todo -> todo.getUsername().equals(username)){
		 
		 if(userExists) {
		System.out.println("Same username found");
	
		Cookie[] cookies = req.getCookies();
		String userid = null;
		
		if (cookies == null) {//if there is no cookie generating name for it
			userid = "id" + UserIdGenerator.generateId();           
			Cookie cookie = new Cookie("id", userid);// Create a new cookie with the name "id" and the value as generated userid
			resp.addCookie(cookie);
		} 
	
		if(cookies != null) {//if there is already a sett cookie
			for(Cookie cookie : cookies) {//compares every cookie with id
				if(cookie.getName().equals("id")) {
					userid = cookie.getValue();
					
					model.addAttribute("userid", userid);
					System.out.println("Existing cookie found with ID: " + userid);
					break;
				}
			}
		}
		return "login";
	}else {
		return "loginfail";
	}
	}

}
