package com.example.springTrainning2;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class todoControl2 {

	//array list with todo class type
	public ArrayList <Todo> todolist = new ArrayList<>();
	
	// Display the to-do list
	@GetMapping("/newtodo")
    public String showtodos(Model model) {
		// When you add a Todo object to the model in your controller,
		//Spring uses these getter methods to make the fields available to the view layer (Thymeleaf in this case).
		model.addAttribute("todos",todolist); // Add the current todos to the model
        return "newtodo"; // This refers to form.html
    }
  
	// Add a new task via URL (e.g.,/newtodo/add/title)
    @GetMapping("/newtodo/add/{title}")
	    public String add(@PathVariable("title") String title, Model model) {
    	
    		Todo newtodo = new Todo(title); // Create a new todo item
    		todolist.add(newtodo); // Add the new todo to the list
	    	model.addAttribute("todos",todolist);
	    	return "newtodo"; 			
	  }	

    // deleting task using id
	@GetMapping("/newtodo/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
		
		//removing if todolist array which contains the same id as url
		//The method takes a Predicate functional interface as an argument.
		//arraytodo: This is a variable representing each item in the todolist during iteration.
		todolist.removeIf(arraytodo-> arraytodo.getId() == id);
		
    	model.addAttribute("todos",todolist);//update the todos to the list
    	return "newtodo"; 			
  }	
    
}


