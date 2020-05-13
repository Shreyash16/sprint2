package com.capgemini.onlinetestmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.onlinetestmanagement.dao.Questionsdao;
import com.capgemini.onlinetestmanagement.entity.Questions;


@SpringBootApplication
public class OnlineTestManagementApplication  {

	 @Autowired
		private Questionsdao questionsdao;
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		
	}
	
	
	  

}

	

