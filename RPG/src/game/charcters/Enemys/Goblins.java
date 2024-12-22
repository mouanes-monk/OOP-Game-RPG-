package game.charcters.Enemys;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Visuals.Gamepannel;
import Visuals.keys;

public class Goblins extends Enemeys {public int HP=50;
int AD=20; //attack damage
int AP=0; // ability damage
String name;
int Def=5; // defense
int Dodge=40;

public static int x;
public static int y;
public static BufferedImage goblin,goblinf,goblinf1;
public BufferedImage goblin1;
Gamepannel gbp;
public Rectangle sa;
int sn=1;
int sc=0;


public Goblins(Gamepannel gbp ) {
	super("Goblin", 10, 0, 5, 5,20);
this.gbp=gbp;
sa=  new Rectangle();
sa.x=8;
sa.y=16;
sa.width=32;
sa.height=32;
	position(); 
  
	
	// TODO Auto-generated constructor stub
}

public void position()
{   x= 200;
y=200;
	
}
public void attack() {
	
}
public int defense() {
	int deffensestate= getDef()+getDef()*30/100;
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
public void getimage() {
	  try {
	        // Load images for the goblin
	        goblin = ImageIO.read(getClass().getResourceAsStream("/goblin/goblin.png"));
	        
	        goblin1 = ImageIO.read(getClass().getResourceAsStream("/goblin/goblin1.png"));
	        goblinf = ImageIO.read(getClass().getResourceAsStream("/goblin/goblinf1.png"));
	        goblinf1 = ImageIO.read(getClass().getResourceAsStream("/goblin/goblinf2.png"));
	     
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
}
public void updatef() {

	sc++;
	if(sc>30) {
		if(sn==1) {
			sn=2; 
		}else if (sn==2) {
			sn=3;
		}if (sn==3) {
			sn=1;
		}
		sc=0;
	}
}
public void drawf(Graphics2D g2) {
	getpimage();
	BufferedImage image =null;
	
	

		if(sn==1) {
			image=goblinf;	
		}
		if(sn==2) {
			image=goblinf1;	
		
			
		}
		if(sn==3) {
			image=goblin;	
			System.out.println("image3");
		}
	
	
	

	
	g2.drawImage(image,720,550,gbp.tilesizef+20,gbp.tilesizef+20,null);
	
	


}

}
