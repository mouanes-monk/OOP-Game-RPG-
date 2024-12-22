package game.charcters.Enemys;

import java.util.Random;

public class Ghouls extends Enemeys{
	int HP=50;
	int AD=20; //attack damage
	int AP=0; // ability damage
	String name;
	int Def=5; // defense
	int Dodge=40;
	public Ghouls() {
		super("Ghouls", 20, 0, 5, 40,50);
		
		// TODO Auto-generated constructor stub
	}

   public void attack() {
  	
  }
   public int defense() {
		int deffensestate= getDef()+getDef()*50/100;
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
