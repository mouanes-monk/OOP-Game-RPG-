package map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Visuals.Gamepannel;
import Visuals.battlePanel;
import game.charcters.Enemys.Goblins;

public class mapmanger {
Gamepannel gp;
public map[] tile;
public map[] arena;
public int maptilenumb [][];
public map ene;
public battlePanel gpf;
public mapmanger(Gamepannel gp) {
	this.gp=gp;
	
	tile = new map[20];
	arena = new map[20];
	maptilenumb =new int[gp.maxworldc][gp.maxworldr];

	loadmap();
	 
}
public mapmanger(battlePanel gpf) {
	this.gpf=gpf;
	arena = new map[20];
	 tile = new map[20]; // Initialize the tile array
	
	


	 
}
public void loadmap() {
	try {
		
		InputStream is =getClass().getResourceAsStream("/maps/map.txt");	
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		int j =0;
		int i=0;
		int x=0;
		int y =0;
		while (i<gp.maxworldc && j <gp.maxworldr) {
			
			String line=br.readLine();
			while (i<gp.maxworldc) {
				String numbers []  = line.split("");
		int num = Integer.parseInt(numbers[i]);
		maptilenumb[i][j]=num;
		i++;
			}
			if(i==gp.maxworldc) {
				i=0;
				j++;
			}
		
		}
		br.close()	;
}catch(Exception e) {
		 
	}
	
		
	}
public void loadenemeys() throws IOException {
	
	ene = new map();
	 ene.image = Goblins.goblin; 
	 ene.co=true;

    
    
}
public void getimage() {
	try {
		tile[0]=new map();
		tile[0].image = ImageIO.read(getClass().getResourceAsStream("/env/grass.png"));
		
		tile[1]=new map();
		tile[1].image = ImageIO.read(getClass().getResourceAsStream("/env/dirt.png"));
		
		tile[2]=new map();
		
		tile[2].image = ImageIO.read(getClass().getResourceAsStream("/env/water.png"));
		tile[2].co = true;
		
		tile[3]=new map();
		tile[3].image = ImageIO.read(getClass().getResourceAsStream("/env/sollr.png"));

		tile[4]=new map();
		tile[4].image = ImageIO.read(getClass().getResourceAsStream("/env/solr.png"));
		
		tile[5]=new map();
		tile[5].image = ImageIO.read(getClass().getResourceAsStream("/env/soll.png"));

		tile[6]=new map();
		tile[6].image = ImageIO.read(getClass().getResourceAsStream("/env/sold.png"));
		
		tile[7]=new map();
		tile[7].image = ImageIO.read(getClass().getResourceAsStream("/env/tree.png"));
		tile[7].co = true;
		tile[8]=new map();
		tile[8].image = ImageIO.read(getClass().getResourceAsStream("/env/bridgeup.png"));
		
		tile[9]=new map();
		tile[9].image = ImageIO.read(getClass().getResourceAsStream("/env/bridgehoriz.png"));
		 try {
		        arena[0] = new map();
		        arena[0].image = ImageIO.read(getClass().getResourceAsStream("/env/arena2.png"));
		       
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
	}catch (IOException e) {
        e.printStackTrace();
        
    }
	
}

public void drawf(Graphics2D g2) {
	getimage();
	 if (arena[0] != null) { // Ensure arena image is loaded
	        g2.drawImage(arena[0].image, 0, 0, gpf.getWidth(), gpf.getHeight(), null);
	    } else {
	        System.err.println("Arena image not loaded!");
	    }

}

public void draw(Graphics2D g2) {
     gp.goblin.getimage();
	try {
		loadenemeys();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	loadmap();
	getimage();
	int j =0;
	int i=0;
	int x=0;
	int y =0;
	while (i<gp.maxworldc && j <gp.maxworldr) {
	int tilen=maptilenumb[i][j];
	  int worldx=i* gp.tilesize;
	  int worldy=j*gp.tilesize;
	  int screenx=worldx -gp.p.x + gp.p.screenx;
	  int screeny=worldy -gp.p.y + gp.p.screeny;
		g2.drawImage(tile[tilen].image, screenx, screeny,gp.tilesize,gp.tilesize,null);
		 int goblinScreenX = gp.goblin.x - gp.p.x + gp.p.screenx;
		 int goblinScreenY = gp.goblin.y - gp.p.y + gp.p.screeny;
		  g2.drawImage(gp.goblin.goblin, goblinScreenX, goblinScreenY, gp.tilesize, gp.tilesize, null);
		i++;
		
		if(i==gp.maxworldc) {
			i=0;
			
			
			j++;
			
		
		}
		
		
	}
	
}
}
