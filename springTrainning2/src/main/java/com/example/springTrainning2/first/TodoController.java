package com.example.springTrainning2.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

//using arraylist and string class to make todo list

	public List <String> todolist = new ArrayList<>(List.of("Spring Traininig","Spring boot-JPA","basanta"));
    @GetMapping("/showtodoo")
    public String showtodos(Model model) {
        model.addAttribute("todos", todolist); // Update the model with the new list
        return "form"; // This refers to form.html which is in resources/templates/form.html
    }
    
    //adding new task through url by localhost:8080/add/sometask
    @GetMapping("/add/{newtodo}")
    public String add(@PathVariable("newtodo") String newtodo, Model model) {
    	todolist.add(newtodo);
    	model.addAttribute("todos",todolist); // Update the model with the new list
    	return "form"; 			
  }
    //adding new task through url by localhost:8080/delete/sometask
    @GetMapping("/delete/{todelete}")
    public String delete(@PathVariable("todelete") String todelete, Model model) {
    	todolist.remove(todelete);
    	model.addAttribute("todos",todolist);
    	return "form"; 			
  }
    
    
}
