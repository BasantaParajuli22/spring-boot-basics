package com.example.springTrainning2.login;


import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springTrainning2.todotask.TodoClass;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController{
	ArrayList<TodoClass> todoList = new ArrayList<>();

    @GetMapping("/login/addwithCookie")
    public String addwithCookie(Model model, HttpServletRequest req, HttpServletResponse resp) {
    	
        //model.addAttribute("todos", todoList);
        Cookie[] cookies = req.getCookies();
        String userid = null;
        
        if(cookies != null) {//if there is already a sett cookie
        	for(Cookie cookie : cookies) {
        		if(cookie.getName().equals("id")) {
        			userid = cookie.getValue();
        			
        			model.addAttribute("userid", userid);
                    System.out.println("Existing cookie found with ID: " + userid);
        			break;
        		}
        	}
        }
        
      //checking if there is no cookie with required userid, if not ->send them to login page
        if (userid == null) {
            System.out.println("No cookie found : ");
            return "log/loginfail";
            
        } 
        //filter the todo list and ensure that the tasks displayed belong to this specific user. 
        List<TodoClass> filteredList = new ArrayList<>();
        if (userid != null) {
        	
        	for(TodoClass todo : todoList) {
        		if(todo!=null) {
        			if(todo.getUserId().equals(userid)) {
        				filteredList.add(todo);
        			}
        		}
        	}
        }

        model.addAttribute("filteredList", filteredList);
        return "log/todoform";
    }
    
	
	
    @GetMapping("/login/addwithCookie/add")
    public String addtask(Model model, HttpServletRequest req, HttpServletResponse resp, @RequestParam("title")String title) {
    	  
        Cookie[] cookies = req.getCookies();
        String userid = null;
        

        if(cookies!=null) {
        	for(Cookie c: cookies) {
        		if(c.getName().equals("id")) //if
        		userid = c.getValue();
        		model.addAttribute("userid", userid);
        		break;
        	}
        }
        if (userid == null) {//if there is no cookie, send them to login page
            System.out.println("No cookie found : ");
            return "log/loginfail"; 
        } 
        //adding tasks to do//
        if(userid!= null && title!= null) {
        	TodoClass todo = new TodoClass(title,userid);
        	todoList.add(todo);
        	model.addAttribute("todos",todoList);
        }
        
        return "redirect:/login/addwithCookie";
    }
    
    @GetMapping("/login/addwithCookie/delete/{id}")
    public String deletetask(Model model, HttpServletRequest req, HttpServletResponse resp, @PathVariable("id") int id) {
    	    
        Cookie[] cookies = req.getCookies();
        String userid = null;
        if(cookies!=null) {//checking if same cookie
        	for(Cookie c: cookies) {
        		if(c.getName().equals("id"))
        		userid = c.getValue();
        		break;
        	}
        }
        if (userid == null) {//if there is no cookie, send them to login page
            System.out.println("No cookie found : ");
            return "log/loginfail"; 
        } 
        
        boolean removed = todoList.removeIf(deltodo -> deltodo.getId() == id);
        	if (!removed) {
        		System.out.println("No task found with ID: " + id);
        	}
        
        model.addAttribute("todos",todoList);
        return "redirect:/login/addwithCookie";
    }
    
}



