package mysimplegame;

public class Main {
	
	public static void main(String[] args) {
		
		Player1 p1 = new Player1("Vishnu","Sword",200);
		 
		System.out.println(p1.getName());
		System.out.println(p1.getHealth());
		System.out.println(p1.getWeapon());
		p1.damagebyGun1();
		p1.damagebyGun1();
		p1.damagebyGun2();
		
		 Player2 p2 = new Player2(100,false,"PK","Japanese Sword");
		 System.out.println(p2.getWeapon());
		 System.out.println(p2.getName());
		 p2.damagebyGun1();
	}

}
