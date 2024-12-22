package game.charcters.Player;

import Visuals.Gamepannel;
import game.charcters.Charcters;
import game.charcters.Enemys.Goblins;

public class collichecker {
	Gamepannel gp;
	public collichecker (Gamepannel gp) {
		this.gp=gp;
	}
	public void checktile(Player c) {
		int elx=c.x +c.sa.x;
		int erx=c.x +c.sa.x+c.sa.width;
		int ety=c.y +c.sa.y;
		int eby=c.y +c.sa.y+c.sa.height;
		
		int eli=elx/gp.tilesize;
		int eri=erx/gp.tilesize;
		int etj=ety/gp.tilesize;
		int ebj=eby/gp.tilesize;
		int t1,t2;
		  c.cop = false;
		switch(c.dir) {
		case "up":
			etj=(ety-c.s)/gp.tilesize;
			t1=gp.tile.maptilenumb[eli][etj];
			t2=gp.tile.maptilenumb[eri][etj];
			if(gp.tile.tile[t1].co == true ||gp.tile.tile[t2].co== true) {
			c.cop= true;	
			} if (checkCollisionWithGoblin(c,gp. goblin)) {
	             c.cop = true;  
	             gp.transitionToBattle();
	         }System.out.println("cop flag: " + c.cop);
			break;
		case"down":
			ebj=(eby-c.s)/gp.tilesize;
			t1=gp.tile.maptilenumb[eli][ebj];
			t2=gp.tile.maptilenumb[eri][ebj];
			if(gp.tile.tile[t1].co == true ||gp.tile.tile[t2].co== true) {
			c.cop= true;	
			}
			 if (checkCollisionWithGoblin(c,gp. goblin)) {
	             c.cop = true;  
	             gp.transitionToBattle();
	         }System.out.println("cop flag: " + c.cop);
			break;
		case"right":
			eri=(erx+c.s)/gp.tilesize;
			t1=gp.tile.maptilenumb[eri][etj];
			t2=gp.tile.maptilenumb[eri][ebj];
			if(gp.tile.tile[t1].co == true ||gp.tile.tile[t2].co== true) {
			c.cop= true;	
			
			}
			 if (checkCollisionWithGoblin(c,gp. goblin)) {
	             c.cop = true;  
	             gp.transitionToBattle();
	         }System.out.println("cop flag: " + c.cop);
			break;
		case"left":
			eli=(elx+c.s)/gp.tilesize;
			t1=gp.tile.maptilenumb[eli][etj];
			t2=gp.tile.maptilenumb[eli][ebj];
			if(gp.tile.tile[t1].co == true ||gp.tile.tile[t2].co== true) {
			c.cop= true;	
			}
			 if (checkCollisionWithGoblin(c,gp. goblin)) {
	             c.cop = true;  
	             gp.transitionToBattle();
	         }System.out.println("cop flag: " + c.cop);
			break;
		
		
		
		
		}
		
	}
	private boolean checkCollisionWithGoblin(Player c, Goblins goblin) {
        // Define bounding boxes for the player and the Goblin
        int playerX = c.x + c.sa.x;
        int playerY = c.y + c.sa.y;
        int playerWidth = c.sa.width;
        int playerHeight = c.sa.height;

        int goblinX = goblin.x;
        int goblinY = goblin.y;
        int goblinWidth = goblin.sa.width;  // Use Goblin's image width
        int goblinHeight = goblin.sa.height;  // Use Goblin's image height

        // Check if the player’s bounding box overlaps with the Goblin's bounding box
        return playerX < goblinX + goblinWidth &&
               playerX + playerWidth > goblinX &&
               playerY < goblinY + goblinHeight &&
               playerY + playerHeight > goblinY;
    }
}

	
	

