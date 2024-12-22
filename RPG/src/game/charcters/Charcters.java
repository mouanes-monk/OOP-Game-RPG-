package game.charcters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Visuals.Gamepannel;
import Visuals.keys;
import game.charcters.Enemys.Enemeys;

public abstract class Charcters {
	protected int HP;
	protected int AD; //attack damage
	protected int AP ; // ability damage
	protected String name;
	protected int Def; // defense
	protected int Dodge;
	Gamepannel gbp;
	keys keyp;
public Charcters(String name, int AD, int AP, int Def, int Dodge,int HP) {
	this.name = name;
    this.AD = AD;
    this.AP = AP;
    this.Def = Def;
    this.Dodge = Dodge;
    this.HP = HP;
    Gamepannel gbp;
	  keys keyp;
	  Rectangle sa;
	  boolean cop;
	  int x ;
		int y ;
		int s;
	int screenx;
	int screeny;
		
		
		String dir;
          int sc=0;
		int sn=1;
		
	}

    public void attack() {
    	
    }
    public abstract int defense();
    	
    
  
    public abstract boolean dodge();
    public abstract void technic1() ;
    public abstract void technic2();
	

    public abstract void technic3() ;
	

    public int getHP() {return this.HP;}

	public void technic1(Enemeys enemy) {
		// TODO Auto-generated method stub
		
	}

	public Charcters() {
		
	}
}
