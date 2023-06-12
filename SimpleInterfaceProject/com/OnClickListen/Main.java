package com.OnClickListen;

public class Main {

	public static void main(String[] args) {
		
		Button blogin = new Button();
		
			blogin.setOnClickListener(new OnClickListener(){
				
				public void onClick() {
					System.out.println("User is logged in");
				}
			
		});

			Button blogout = new Button();
			
			blogout.setOnClickListener(new OnClickListener(){
				
				public void onClick() {
					System.out.println("User is logged out");
				}
			
		});
			
	}

}
