package com.foodfc;

public class FoodItem {

	double total;
	String Itemname;
	double ItemPrice;
	boolean Availabile;
	int quantity;
	
	
	FoodItem(String Itemname, double ItemPrice, boolean Available){
		this.Itemname=Itemname;
		this.ItemPrice=ItemPrice;
		this.Availabile=Available;
	}
	FoodItem(String Itemname, int quantity,double total){
		this.Itemname=Itemname;
		this.quantity=quantity;
		this.total=total;
	}
	public String getItemname() {
		return Itemname;
	}

	public void setItemname(String itemname) {
		Itemname = itemname;
	}

	public double getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(double itemPrice) {
		ItemPrice = itemPrice;
	}

	public boolean isAvailabile() {
		return Availabile;
	}

	public void setAvailabile(boolean availabile) {
		Availabile = availabile;
	}
	
	public void displayMenu() {
		
		System.out.println("\t---------------------------------------------");
		System.out.println("\t"+this.Itemname+"\t\t"+this.ItemPrice+"\t\t"+this.Availabile);
	}
	public void displaySelectedItems() {
		
		System.out.println("\t---------------------------------------------");
		System.out.println("\t"+this.Itemname+"\t\t"+this.quantity+"\t\t"+this.total);
	}
	
}
