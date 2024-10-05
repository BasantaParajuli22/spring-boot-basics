package com.example.springTrainning2.todotask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;


public class Todo {
	
	private static int nextID = 1;
	private int id;
	private String title;
	private Date datee;
	private LocalDateTime createddate;


	
	//when creating a object of this class u need pass string as title
	public Todo(String title) {
		id = nextID;
		this.title = title;
		nextID++;
		datee = new Date();
		
		createddate = LocalDateTime.now();
	}
	
	//Thymeleaf automatically calls the appropriate getter methods
	// when you use expressions like ${todo.id} or ${todo.title}.
	public int getId() {
		return id;
	}
    // Getter for Title
	public String getTitle() {
        return title;
    }
	public Date getDatee() {
		return datee;
	}

	
	public LocalDateTime getcreateddate() {
		return createddate;
	}
	
	public String getTimeAgo() {
		Duration duration = Duration.between(createddate, LocalDateTime.now());
		
		long seconds = duration.getSeconds();
		
		    if (seconds < 60) {
	            return seconds + " seconds ago";
	        } else if (seconds < 3600) {
	            return (seconds / 60) + " minutes ago";
	        } else if (seconds < 86400) {
	            return (seconds / 3600) + " hours ago";
	        } else {
	            return (seconds / 86400) + " days ago";
	        }
		}




}


 