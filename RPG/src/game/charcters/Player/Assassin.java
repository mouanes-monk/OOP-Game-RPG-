package game.charcters.Player;

import java.util.Random;

import game.charcters.Enemys.Enemeys;

public class Assassin extends Player{
	int HP=50;
	int AD=20; //attack damage
	int AP=0; // ability damage
	String name;
	int Def=5; // defense
	int Dodge=30;
	int ddg;
	public Assassin() {
		super("Assassin", 20, 5, 5, 5,30);
		
		// TODO Auto-generated constructor stub
	}

   

  public int defense() {
		int deffensestate= getDef()+getDef()*35/100;
  	return  deffensestate;}




public boolean dodge() {
	Random rnd = new Random();
	  ddg=Dodge;
	int rnnd=rnd.nextInt(101);
	if(rnnd < ddg) {return true;
		
	}return false;

	
}
public void dodgeab() {
	ddg=Dodge+Dodge*30/100;
}


@Override
public void technic1(Enemeys enemy) {
	int damage = (getAD() + (getAD()*50/100))- enemy.getdefstate();
	System.out.println("ad"+getAD());
    if(!enemy.dodge()) {
    enemy.takesdmg(damage);
    System.out.println("u dealt "+damage);
    System.out.println("u Slashed the "+enemy.getname()+" and reduced his hp to "+enemy.getHP());
   
    }else System.out.println("the ability has been dodged");
	
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


