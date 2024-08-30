package com.example.springTrainning2.login;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springTrainning2.todotask.UserIdGenerator;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * cookie.setMaxAge(0); is used to delete the cookie immediately.
 * cookie.setPath("/"); is explicitly set both when creating and deleting the cookie to ensure consistency.
 * cookie.setHttpOnly(true); is added to the cookie creation to make it inaccessible to JavaScript, which is a good security practice.
 * 
 */

@Controller
public class LoginController {

	 ArrayList<loginClass> todoList = new ArrayList<>();   

	@GetMapping("/login")
	public String login(){
		return "log/login";
	}

	@GetMapping("/login/fail")
	public String loginFail(){
		return"log/login";
	}

	@GetMapping("/login/me")
	public String setCookie(Model model, HttpServletRequest req, HttpServletResponse resp,
			@RequestParam("username")String username,
			@RequestParam("password")String password ) {
//		loginClass list = new loginClass(username); 
		
//		 boolean userExists = todoList.stream().anyMatch(todo -> todo.getUsername().equals(username));
//	if(todo -> todo.getUsername().equals(username)){
		 
		//only if the username and password matches it creates cookie
		if("basanta1".equals(username) && "password".equals(password)) {
			System.out.println("Same username found");
		
			Cookie[] cookies = req.getCookies();
			String userid = null;

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
			if (userid == null) {//if there is no cookie generating name for it
				userid = "id:" + UserIdGenerator.generateId();           
				Cookie cookie = new Cookie("id", userid);// Create a new cookie with the name "id" and the value as generated userid
				
				cookie.setPath("/"); // Ensure path is correct
				cookie.setHttpOnly(true); // Make cookie HttpOnly for security
				resp.addCookie(cookie);
				
				model.addAttribute("userid", userid);
			} 
			
		  return "redirect:/login/addwithCookie";
		//if username and password not match then fails to login
		}else {
			return "log/loginfail";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse resp, HttpServletRequest req) {
		Cookie[] cook = req.getCookies();
		
		if(cook != null) {
			for(Cookie cookie :cook) {
				if(cookie.getName().equals("id")) {
					cookie.setValue(null);//setting cookie value to null
					cookie.setMaxAge(0);//deleting cookie
					
					cookie.setPath("/");
					resp.addCookie(cookie);
					System.out.println("deleted cookie " + cookie.getValue());
					break;
				}
			}
		}
		
		return "redirect:/login";
	}

}
