package com.example.springTrainning2.todotask;



import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ServerTodo{
		public ArrayList <TodoClass> todolist = new ArrayList<>();

		// Display the todo list
		@GetMapping("/{identifier}/displaytodo")
	    public String showtodos(@PathVariable("identifier")String identifier,
				Model model) {
			
			// Filter the list to show only tasks matching the identifier
			ArrayList <TodoClass> filteredlist = (ArrayList<TodoClass>) todolist.stream()
				.filter(todo->todo.getidentifier() .equals( identifier))
				.collect(Collectors.toList());
						
			model.addAttribute("todos", filteredlist);
			model.addAttribute("indentifier", identifier);//for html display puposes we need identifier
	        return "usernametodo"; 
	    }

		//to add new task using form
		@GetMapping("/{identifier}/newtodo-forms")
		public String addTaskForm(@RequestParam("addtask") String addtask,
				@PathVariable("identifier")String identifier,
				Model model) {	
			TodoClass newtodo = new TodoClass(addtask, identifier);
	        todolist.add(newtodo);
		    return "redirect:/{identifier}/displaytodo";// Redirect to the display page after adding
		}
		
	    // deleting task using id
		@GetMapping("/{identifier}/newtodo-forms/delete/{id}")
	    public String delete(@PathVariable("identifier") String identifier,
	    			@PathVariable("id") int id,
	    			Model model) {
			todolist.removeIf(arraytodo-> arraytodo.getId() == id);
			
	    	return "redirect:/{identifier}/displaytodo"; 			
		}
	    
}

