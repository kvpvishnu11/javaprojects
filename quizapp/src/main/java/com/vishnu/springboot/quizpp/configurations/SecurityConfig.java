package com.vishnu.springboot.quizpp.configurations;

/*
 
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {
	
	
	// Method - To store usernames in the data base table
		
		@Bean
		public UserDetailsManager getUsersFromDB(DataSource dataSource) {
			
			UserDetailsManager 	userDetailsManager = new JdbcUserDetailsManager(dataSource);
			return userDetailsManager;
		}
	
	
	/* 
	// Method 1 - To save users directly here in Java Code
	
	@Bean
	public InMemoryUserDetailsManager getUserDetails() {
		
		UserDetails user1 = User.builder().username("user1").password("{noop}1234").roles("ADMIN").build();
		UserDetails user2 =  User.builder().username("user2").password("{noop}2234").roles("ADMIN").build();
		UserDetails user3 =  User.builder().username("user3").password("{noop}3334").roles("ADMIN").build();
		
		 
		
		
		InMemoryUserDetailsManager obj1 = new InMemoryUserDetailsManager(user1,user2,user3);
		
		return obj1;
	}
	
	 

}*/
