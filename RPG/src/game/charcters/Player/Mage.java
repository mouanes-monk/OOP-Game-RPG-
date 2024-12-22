package game.charcters.Player;

import java.util.Random;

public class Mage extends Player{
	int HP=70;
	int AD=5; //attack damage
	int AP=20; // ability damage
	String name;
	int Def=5; // defense
	int Dodge=10;
	public Mage() {
		super("mage", 5, 20, 5, 10,70);
		
	}
		// TODO Auto-generated constructor stub
	@Override
	public int defense() {
		int deffensestate= getDef()+getDef()*40/100;
    	return  deffensestate;
	}
	@Override
	public boolean dodge() {
		Random rnd = new Random();
		  ddg=Dodge;
		int rnnd=rnd.nextInt(101);
		if(rnnd < ddg) {return true;
			
		}return false;

		
	}
	public void dodgeab() {
		ddg=Dodge+Dodge*20/100;
	}

	@Override
	public void technic1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void technic2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void technic3() {
		// TODO Auto-generated method stub
		
	}
	}

