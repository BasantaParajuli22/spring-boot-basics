package com.example.springTrainning2.todotask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserIdGenerator {
	
	public static String sampleSpace = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public static List<String> ids = new ArrayList<>();
	
	public static String generateId() {
		boolean isUnique = false;
		String alphaid = "";
		Random random = new Random();
		
		while(!isUnique) {//first generates id and checks if it is unique ends while loop
			alphaid = "";
			for(int i=0;i<20;i++) {
				int index = random.nextInt(sampleSpace.length());
				char randomChar = sampleSpace.charAt(index);
				alphaid = alphaid + randomChar;
			}
			//after random alpha id is generated checking if it is unique
			if(!ids.contains(alphaid)) {
				 isUnique = true;
				 ids.add(alphaid);
			}
			System.out.println("Generated ID (Attempt): " + alphaid);
		}
	 
	System.out.println(alphaid);	
	return alphaid;
	}


	public static String getUserId() {
		return generateId();
	}
}
