package game.charcters.Player;

import java.util.Random;

public class Worrior extends Player {
	int HP=100;
	int AD=15; //attack damage
	int AP=0; // ability damage
	String name;
	int Def=20; // defense
	int Dodge=5;
	public Worrior() {
		super("swordman", 15, 0, 20, 5,100);
	
		
		// TODO Auto-generated constructor stub
	}
	public int defense() {
		int deffensestate= getDef()+getDef()*55/100;
    	return  deffensestate;}
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
