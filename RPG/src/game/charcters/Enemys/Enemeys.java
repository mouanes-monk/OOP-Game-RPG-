package game.charcters.Enemys;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Visuals.Gamepannel;
import game.charcters.Charcters;
import game.charcters.Player.Player;

public abstract class   Enemeys extends Charcters{int deffensestate;
int ddg,ap,ad;
	public Enemeys(String name2, int aD2, int aP2, int def2, int dodge2,int HP) {
		super(name2, aD2, aP2, def2, dodge2,HP);
		// TODO Auto-generated constructor stub
	}
	public Enemeys(Gamepannel gbp ) {}
	  public void attack(Player player) {int damage = AD - player.getdeff();
	  if(!player.dodge()) {
	     player.takesdmg(damage);
	     System.out.println("u attacked "+player.getname()+" and reduced his hp to "+player.getHP());
	  }else System.out.println("the attack has been dodged");
	    	}
	  public  int deffense() { deffensestate= getDef()+getDef()*50/100;
	  System.out.println("the Goblin increased his Def to "+deffensestate);
  	return  deffensestate;
  }public int getdefstate() {
  return deffensestate ;}
  public void  returnstats() {deffensestate= getDef();
  ddg=Dodge;
  ad=AD;
  ap=AP;
	  }
	
	
	
public int	getHP(){
	return HP;
}
public String	getname(){
	return name;}
public int	getDef(){
	return Def;}
public int takesdmg(int damage) {
	this.HP=getHP()-damage;
	return getHP();
	
}public void getpimage() {
	 
}
public void draw(Graphics2D g2) {

}
}
