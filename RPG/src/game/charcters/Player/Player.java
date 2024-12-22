package game.charcters.Player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Visuals.Gamepannel;
import Visuals.keys;
import game.sound;
import game.charcters.Charcters;
import game.charcters.Enemys.Enemeys;

public  class Player extends Charcters{
	int exp =0;
	int lvl =1;
	int deffensestate;
	int ddg,ad,ap;
	int dodge;
	public int hp;
	
	//visuals
	  Gamepannel gbp;
	  keys keyp;
	    private String animationState = "standing"; 
	  public Rectangle sa;
	  public boolean cop;
	  public int x ;
		public int y ;
		int s;
		int state=0;
	public	int screenx,screeny;
		
		public BufferedImage up1 ,up2,down1,down2,left1 ,left2,right1,right2,player,player1,player2,profile,ani1,ani2,ani3;
		public String dir;
		public int sc=0;
		public int sn=1;
		public int at=1;
		
		
		
		   public Player(String name, int AD, int AP, int Def, int dodge, int hp) {
		        this.name = name;
		        this.AD = AD;
		        this.AP = AP;
		        this.Def = Def;
		        this.dodge = dodge;
		        this.hp = hp;
		    }
	

     public void attack(Enemeys enemy) {int damage = AD - enemy.getdefstate();
     state=1;
     if(!enemy.dodge()) {
     enemy.takesdmg(damage);
     System.out.println("u dealt "+damage);
     System.out.println("u attacked "+enemy.getname()+" and reduced his hp to "+enemy.getHP());
    
     }else System.out.println("the attack has been dodged");
    	
    }
     public void  returnstats() {deffensestate= getDef();
     ddg=Dodge;
     ad=AD;
     ap=AP;
	  }
    public int deffense() {deffensestate= getDef()+getDef()*50/100;
    System.out.println("Player chose to Defend!"+deffensestate);
    	return  deffensestate;
    }
    public int getdeff() {
    	return deffensestate;
    }

	public boolean dodge() {
		// TODO Auto-generated method stub
		return false;
	}
	public void dodgeab() {
		ddg=Dodge + Dodge*10/100;
	}
    
    
    
    
    public void technic1() {
		// TODO Auto-generated method stub
		
	}
	
	public void technic2() {
		// TODO Auto-generated method stub
		
	}
	public void technic3() {
		// TODO Auto-generated method stub
		
	}
	

  
   
    
    public int	getHP(){
    	return HP;
    }
    public int	getDef(){
    	return Def;}
    public int takesdmg(int damage) {
    	this.HP=getHP()-damage;
    	return getHP();}
    public String	getname(){
    	return name;}
    public int	getAD(){
    	return AD;}
    public int	getAP(){
    	return AP;}
    public void	addAD(int wAD){AD=getAD()+wAD;
    	}
    public void	addAP(int wAP){AD=getAP()+wAP;
	}


	public void technic1(Enemeys enemy) {
		// TODO Auto-generated method stub
		
	}
	
	public Player(Gamepannel gbp , keys keyp) {
		super("KONG", 10, 0, 5, 5,20);
		this.gbp=gbp;
		this.keyp=keyp;
		
		
		position(); 
		screenx= (gbp.screenc/2)-(gbp.tilesize/2) ;
		screeny=gbp.screenr/2 -(gbp.tilesize/2);
		
		sa=  new Rectangle();
		sa.x=8;
		sa.y=16;
		sa.width=32;
		sa.height=32;
	}
	
	public void position() {
		 x = 150;
		 y =150;
		 
		 s= 4;
		 dir="down";
	}
	public void getpimage() {
	    try {
	        if (up1 == null) up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
	        if (up2 == null) up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
	        if (down1 == null) down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
	        if (down2 == null) down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
	        if (left1 == null) left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
	        if (left2 == null) left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
	        if (right1 == null) right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
	        if (right2 == null) right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
	        player=ImageIO.read(getClass().getResourceAsStream("/player/player4.png"));
	        player1=ImageIO.read(getClass().getResourceAsStream("/player/player411.png"));
	        player2=ImageIO.read(getClass().getResourceAsStream("/player/player42.png"));
	        profile=ImageIO.read(getClass().getResourceAsStream("/player/profile.png"));
	        ani1=ImageIO.read(getClass().getResourceAsStream("/player/ani1.png"));
	        ani2=ImageIO.read(getClass().getResourceAsStream("/player/ani2.png"));
	        ani3=ImageIO.read(getClass().getResourceAsStream("/player/ani3.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	public void update() {
		if(keyp.up==true||keyp.dp==true||keyp.lp==true||keyp.rp==true) {
		if(keyp.up==true) {
			dir="up";
		
			
		}else if(keyp.dp==true) {
			
			dir="down";
		}else if(keyp.rp==true) {
			
			dir="right";
		}else if(keyp.lp==true) {
		dir="left";}
		cop = false;
		gbp.c.checktile(this);
		if(cop==false) {
			switch(dir) {
			case "up":
				y= y-s;
				break;
			case"down":
				y=y+s;
				break;
			case"right":
				x=x+s;
				break;
			case"left":
				x=x-s;
				break;
			}
		}
		sc++;
		if(sc>12) {
			if(sn==1) {
				sn=2; 
			}else if (sn==2) {
				sn=3;
			}if (sn==3) {
				sn=1;
			}
			sc=0;
		}
	}}
	public void updtaef() {
	    sc++; // Increment frame counter
	 
	    if (sc > 40) { // Change frame every 12 ticks
	        switch (animationState) {
	        
                
	            case "standing":
	            
	                if (sn == 1) {
	                    sn = 2;
	                } else if (sn == 2) {
	                    sn = 3;
	                } else if (sn == 3) {
	                    sn = 1;
	                }
	                break;

	            case "attacking":
	            	
	                if (at == 1) {  
	                	sc+=40;
	                    at = 2;
	                } else if (at == 2) {sc+=40;
	                	at = 3;
	                	
	               
	                } else if (at == 3) {sc+=30;
	                    at = 1;
	                	
	                   
	                    animationState = "standing"; 
	                  System.out.println("wow");
	                }
	                break;
	        }
	        sc = 0; // Reset frame counter
	    }
	}
		
	
	public void draw(Graphics2D g2) {
		getpimage();
		BufferedImage image =null;
		
		switch(dir) {
		case"up":
			if(sn==1) {
				image=up1;	
			}
			if(sn==2) {
				image=up2;	
			}
		
			break;
		case"down":
			if(sn==1) {
				image=down1;	
			}
			if(sn==2) {
				image=down2;	
			}
			break;
		case"left":
			if(sn==1) {
				image=left1;	
			}
			if(sn==2) {
				image=left2;	
			}
			break;
		case"right":
			if(sn==1) {
				image=right1;	
			}if(sn==2) {
				image=right2;	
			}
		break;
		}
		g2.drawImage(image,screenx,screeny,gbp.tilesize,gbp.tilesize,null);
	}

    public void drawf(Graphics2D g2) {
    	getpimage();
    	int x=85;
    	int y=550;
    	int v = x;
		BufferedImage image =null;
       
        
		
		switch(animationState) {
		
		case "standing":
	       x=v;
			if(sn==1) {
				
				image=player;	
			}
			if(sn==2) {
				image=player1;	
			
				
			}
			if(sn==3) {
				image=player2;	
			
			}
		
		break;
		case "attacking":
			x+=40;
			if(at==1) {
				image=ani1;	
			
			}
			if(at==2) {
				image=ani2;	
				
			
				
			}
			if(at==3) {
				image=ani3;	
				
				System.out.println("attk3");
				state=0;
				
			}
		
		
		}
    	g2.drawImage(image,x,y,gbp.tilesizef,gbp.tilesizef,null);
    	
    	
  
		
    }

    public void setAnimationState(String state) {
        this.animationState = state;
    }


	
	
	@Override
	public int defense() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Object getAnimationState() {
		
		return animationState;
	}


	
	


}
