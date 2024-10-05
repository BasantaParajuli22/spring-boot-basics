package com.example.springTrainning2.todotask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieController{
    ArrayList<TodoClass> todoList = new ArrayList<>();

    @GetMapping("/cookie")
    public String getsetCookie(Model model, HttpServletRequest req, HttpServletResponse resp) {
    	
        model.addAttribute("todos", todoList);
        Cookie[] cookies = req.getCookies();
        String userid = null;
        
        if (cookies == null) {//if there is no cookie generating name for it
            String cookieValue = "id" + UserIdGenerator.getUserId();//calls UserIdGenerator to generate random alpha numeric id
            Cookie cookie = new Cookie("id", cookieValue);//setting cookie 
            resp.addCookie(cookie);
            
            model.addAttribute("cookieValue", "hello cookie value");
            System.out.println("New cookie created with ID: " + cookieValue);
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
        //filter the todo list and ensure that the tasks displayed belong to this specific user. 
        List<TodoClass> filteredList = new ArrayList<>();
        if (userid != null) {
        	for(TodoClass todo : todoList) {
        		if(todo.getUserId().equals(userid)) {
        			filteredList.add(todo);
        		}
        	}
        }

        model.addAttribute("filteredList", filteredList);
        return "cookie";
    }


}
