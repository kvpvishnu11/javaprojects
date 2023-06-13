package com.foodfc;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
public class PrepareMenu {

	public static void main(String[] args) {
		ArrayList<FoodItem> f3 = new ArrayList<FoodItem>();
		ArrayList<FoodItem> f4 = new ArrayList<FoodItem>();
		String item;
		double price;
		boolean available;
		
		
		
		// Database connection set up

		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Person";
		String root="root";
		String pwd = "150030441@klU";
		
		
		
		// Db Setup

		System.out.println("\tWelcome to Vishnu Food Centre \n");
		
		// Show current menu first 
		
		System.out.println("\n \t*** CURRENT MENU *****\n");
		
		try {
			Connection con2 = DriverManager.getConnection(url,root,pwd);
			
			Statement st2 = con2.createStatement();
			
			ResultSet rs = st2.executeQuery("select *from FoodItem");
			while(rs.next()) {
				 
				f4.add(new FoodItem(rs.getString(1), rs.getDouble(2), rs.getBoolean(3)));

				
				 
				}
			con2.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		

			System.out.println("\n--------------------Vishnu Food Centre Menu -----------------------\n");
			System.out.println("\tItem   		Price  		 Available ");
			
			
			
			for(FoodItem i : f4) {
				
				i.displayMenu();
			}
			
			 
			
			System.out.println("\t---------------------------------------------");
		
		//Current menu code above
		 
		System.out.println("\n\tWould you like to update today's Menu ? \n");
		
		System.out.println("\tEnter 'y' to update or Enter 'n' to exit..");
		Scanner sc = new Scanner(System.in);		 
		char op = sc.next().charAt(0);
		
		if(op == 'y') {
			System.out.println("\tYes, Go ahead and Update the table..");
			char op1='\0';
			
			do {
			System.out.print("\tItem: ");
			item=sc.next();
			System.out.print("\tPrice: ");
			  price = sc.nextDouble();
			System.out.print("\tAvailable: ");
			  available = sc.nextBoolean();
			  try {
					Class.forName(dbdriver);
					Connection con1 = DriverManager.getConnection(url,root,pwd);
					String query1 = "INSERT INTO FoodItem values(?,?,?)";
					PreparedStatement pst1 = con1.prepareStatement(query1);
					pst1.setString(1, item);
					pst1.setDouble(2, price);
					pst1.setBoolean(3, available);
					pst1.executeUpdate();
					
					pst1.close();
					}catch(Exception e) {
						System.out.println(e.getStackTrace());
					}
			  
			  System.out.println("\n\t"+item+" has been added.\n");
			System.out.println("\tWould you like to add more items ? (y/n)");
			 op1 = sc.next().charAt(0);
			}while(op1=='y');
			if(op1=='n') {
				System.out.println("\tThank you. The menu has been updated.");
				System.out.println("\t******* Updated Menu for Today ********");
				try {
				Connection con2 = DriverManager.getConnection(url,root,pwd);
				
				Statement st2 = con2.createStatement();
				
				ResultSet rs = st2.executeQuery("select *from FoodItem");
				while(rs.next()) {
					 
					f3.add(new FoodItem(rs.getString(1), rs.getDouble(2), rs.getBoolean(3)));

					
					 
					}
				con2.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			

				System.out.println("\n--------------------Vishnu Food Centre Menu -----------------------\n");
				System.out.println("\tItem   		Price  		 Available ");
				
				
				
				for(FoodItem i : f3) {
					
					i.displayMenu();
				}
				
				 
				
				System.out.println("\t---------------------------------------------");
			}
			
		}else if(op=='n') {
			System.out.println(" \tYou have selected the exit option..");
		}else {
			System.out.println("\tYou can only enter either y or n options..");
		}
	}

}
