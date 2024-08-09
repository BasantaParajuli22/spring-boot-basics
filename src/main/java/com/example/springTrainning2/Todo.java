package com.example.springTrainning2;

public class Todo {
	
	private static int nextID = 1;
	private int id;
	private String title;
	
	//when creating a object of this class u need pass string as title
	public Todo(String title) {
		id = nextID;
		this.title = title;
		nextID++;
	}
	
//Thymeleaf automatically calls the appropriate getter methods
// when you use expressions like ${todo.id} or ${todo.title}.
	
	//getter for id and setter is auto
	public int getId() {
		return id;
	}
	
    // Getter for Title
	public String getTitle() {
        return title;
    }
    // Setter for Title (optional)
    public void setTitle(String title) {
        this.title = title;
    }
}
 