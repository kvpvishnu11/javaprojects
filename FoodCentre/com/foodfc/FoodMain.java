package com.foodfc;
import java.util.*;
import java.sql.*;
import java.lang.*;
import java.text.NumberFormat;
class myErrHandle extends RuntimeException{
	
	myErrHandle(String s){
		super(s);
	}
}
public class FoodMain {
	 

	public static void main(String[] args) {
		
		String customername;
		String mobileno;
		char option='\0';
		String itemname;
		int quant;
		double total=0.0;
		double price=0.0;
		double cost=0;
		
	 
		// Fetch the menu values from data base table 
		ArrayList<FoodItem> f1 = new ArrayList<FoodItem>();
		
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Person";
		String root="root";
		String pwd = "150030441@klU";
		try {
		Class.forName(dbdriver);
		Connection con1 = DriverManager.getConnection(url,root,pwd);
		
		Statement st1 = con1.createStatement();
		
		ResultSet rs = st1.executeQuery("select *from FoodItem");
		
		while(rs.next()) {
		 
		f1.add(new FoodItem(rs.getString(1), rs.getDouble(2), rs.getBoolean(3)));

		
		 
		}
		
		con1.close();
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		//System.out.println("Data printed in Array list\n");
		
		

//		f1.add(new FoodItem("Dosa",30.0,true));
//		f1.add(new FoodItem("Bonda",20.0,true));
//		f1.add(new FoodItem("Idly",10.0,true));
//		f1.add(new FoodItem("EggDosa",45.0,true));
//		f1.add(new FoodItem("Poori",20.0,true));
//		f1.add(new FoodItem("Chapati",25.0,true));
//		f1.add(new FoodItem("Pulka",15.0,true));
//		f1.add(new FoodItem("Vada",15.0,true));
		
		System.out.println("\n--------------------Vishnu Food Centre Menu -----------------------\n");
		System.out.println("\tItem   		Price  		 Available ");
		
		
		ArrayList<FoodItem> f2 = new ArrayList<FoodItem>();
		for(FoodItem i : f1) {
			
			i.displayMenu();
		}
		
		 
		
		System.out.println("\t---------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tCustomer name :");
		customername= sc.nextLine();
		System.out.print("\n\tMobile no :");
		mobileno=sc.nextLine();
		//sc.nextLine();
		System.out.println("\n\tPlease select the items you would like to order...\n");
		
		while(option!='n') {
			boolean found = false;
			ListIterator<FoodItem> l1 = f1.listIterator();
			System.out.print("\tItem: ");
			
			itemname= sc.nextLine();
			System.out.print("\tQuantity: ");
			try {
		        quant = Integer.parseInt(sc.nextLine());
		        if (quant <= 0 || quant >= 11) {
		            throw new myErrHandle("\n\t You can select a max quantity of 10\n");
		        }
		    } catch (NumberFormatException | myErrHandle e) {
		        System.out.println(e.getMessage());
		        System.out.println("\tPlease enter a valid quantity");
		        continue;
		    }
		//	 sc.nextLine(); 
			//System.out.println("\t---------------------\n");
			while(l1.hasNext()) {
				FoodItem o1 = l1.next();
				String item1 = o1.getItemname();
				
				if(itemname.equals(item1)) {
					price=o1.getItemPrice();
					total = quant * price;
					found=true;
					//System.out.println("price:" +total);
					
				}
				
				
			}
			if(!found) {
				System.out.println("\t"+itemname+" is not in the Menu.. \n");
				
				continue;
				
				
			}
			
			
			f2.add(new FoodItem(itemname,quant,total));
			
			System.out.print("\tWould like to add more items ? Press any key to continue or 'n' to exit..\n");
			option=sc.next().charAt(0);  
			sc.nextLine();
		}
		System.out.println("\t************* Vishnu Food Centre Invoice ************\n");
		System.out.println("\t Name: "+customername+ " 	Mobile No: "+mobileno);
		System.out.println("\t---------------------------------------------");
		System.out.println("\t Items Ordered ");
		System.out.println("\t---------------------------------------------");
		System.out.println("\tItem   		Quantity  	Price");
		for(FoodItem i:f2) {
			i.displaySelectedItems();
			cost=cost + i.total;
		}
		
		Locale Ind = new Locale("pa","IN");
		NumberFormat NI = NumberFormat.getCurrencyInstance(Ind);
		String s1 = NI.format(cost);
		System.out.println("\t---------------------------------------------");
		System.out.println("\t                     	Total : "+s1);
		System.out.println("\t---------------------------------------------\n");
		System.out.println("\tThank you for dining. Visit again!!!");
		
	}

}
