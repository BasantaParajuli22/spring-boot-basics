package com.example.springTrainning2.word;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @GetMapping
 * Purpose: Handles HTTP GET requests.
 *  It is used to retrieve data from the server. 
 * Typically, it is used for reading or querying resources.
 * Common Use Cases:
 * Displaying a web page.
 * Fetching data from a server.
 * Retrieving a resource by its ID.
 * 
 * 
 *@PostMapping:
 *Purpose: Handles HTTP POST requests.
 * It is used when a client sends data to the server, 
 * typically for creating or updating resources.
 * Common Use Cases:
 * Submitting form data.
 * Creating new records in a database.
 * Processing data sent in the request body.
 */


@Controller
public class WordController {
	
	//to see the results
    @GetMapping("/showform")
    public String showForm() {
        return "word"; // This should correspond to the 'word.html'
    }
    
    //To handle users submitted post, form
    @PostMapping("/Wordcheck")
    //requesting parameter input 
    public String Word(@RequestParam("input") String input, Model model){
        String processedinput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedInput = new StringBuilder(processedinput).reverse().toString();

        Boolean isPalindrome = processedinput.equals(reversedInput);

        if(isPalindrome == true){
            model.addAttribute("checkResult", "Yes it is palindrome");
        }else{
            model.addAttribute("checkResult", "No it is not palindrome");
        }
        return "word";
    }
}