package com.example.springTrainning2;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller:
 * The @Controller annotation in Spring MVC is used to define a class
 *  as a web controller that handles HTTP requests.
 */

@Controller
public class indexControl {

//this is programmed for rolling dices using random and squential way
    @GetMapping("/random")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot with Thymeleaf!");
        
        String[] dices = {"One", "Two", "Three", "Four", "five", "Six"};
        Random random = new Random();
        int index = random.nextInt(dices.length);
        model.addAttribute("dice", dices[index]);
        
        return "index";
    }

    
    int index = 0;
    @GetMapping("/serial")
    public String dice(Model model) {
        String[] dices = {"1", "2", "3", "4", "5", "6"};
        int len = dices.length;
        if(index >= len) {//for looping
        	index = 0;
        }
        model.addAttribute("dice", dices[index]);
        index++;
        return "index";
    }
    
    
    
}
