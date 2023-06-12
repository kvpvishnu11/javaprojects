package mysimplegame;

public class Player2 extends Player1{
	
	private int health;
	private boolean armour;
	
	Player2(int health, boolean armour, String name, String weapon){
		super(name,weapon,health);
		this.health=health;
		this.armour=armour;
	}
	public void damagebyGun1() {
		if(armour) {
			this.health-=20;
			if(this.health<=0)this.health=0;
			System.out.println("Armour is on. Got hit by "+getWeapon()+".Health is reduced by 20.New health is : "+this.health);
			
		}if(!armour) {
			this.health-=30;
			if(this.health<=0)this.health=0;
			System.out.println("Armour is off. Got hit by "+getWeapon()+".Health is reduced by 30.New health is : "+this.health);
			
		}
		if(this.health==0) {
			System.out.println(getName()+ " is dead");
		}
	}
	
	

}
