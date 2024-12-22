package Visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.sound;
import game.charcters.Enemys.Enemeys;
import game.charcters.Enemys.Goblins;
import game.charcters.Player.Player;
import game.charcters.Player.collichecker;
import map.mapmanger;

public class Gamepannel extends JPanel implements Runnable {
	final int originaltiles = 16 ;
	final int originaltilesf = 48 ;
	final int scale=3;
	public int tilesizef=originaltilesf *4;
	public int  tilesize =originaltiles*scale;
	public int maxscreenc=16;
	public int maxscreenr=12;
	public int screenc=tilesize*maxscreenc; //768
	public int screenr=tilesize*maxscreenr;//576
	
	public int maxworldc=32;
	public int maxworldr=24;
	public int worldc=tilesize*maxworldc; 
	public int worldr=tilesize*maxworldr;
	
	
	//player mvt
	int x=100;
	int y=100;
	int s=5; 
	 // calc fps
	int fps=60;
	
	Thread gt;
	private volatile boolean running = true;
	public Goblins goblin = new Goblins(this);
	public mapmanger tile = new mapmanger(this);
	keys key=new keys();
	public Player p = new Player(this,key);
	public collichecker c=new collichecker(this);
	
	
	
	 
	
	
	public Gamepannel(){
	
		this.setPreferredSize(new Dimension(screenc,screenr));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(key);  
		this.setFocusable(true);
		this.requestFocusInWindow();
		

	
	}

	public void  setupGame() {
		
	}
public void startgamethread() {
	gt=new Thread(this);
	gt.start(); 
	 System.out.println("Game started.");

}

	@Override
	public void run() {
	    
	    while (running) { 
	    	  
	        double drawintr = 1000000000 / fps;
	        double drawtime = drawintr + System.nanoTime();
	        update();
	        repaint();
	       
	        try {
	            long remaint = (long) (drawtime - System.nanoTime());
	            remaint = remaint / 1000000;
	            if (remaint < 0) {
	                remaint = 0;
	            }
	            Thread.sleep(remaint);
	            drawtime += drawintr;
	        } catch (InterruptedException e) {
	            System.out.println("Game thread interrupted.");
	            Thread.currentThread().interrupt(); // Reset interrupt status
	            break;  // Exit the loop if interrupted
	        }
	    }

	    System.out.println("Game thread finished.");  // Add this line to confirm the game loop finished
	}
	public void update() {
		
		p.update();
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		tile.draw(g2);
		p.draw(g2);
	
		g2.dispose();
	}
	public void transitionToBattle() {
	    System.out.println("Will start the transition");

	    if (!p.cop) {
	        return; // No collision, no transition
	    }

	    // Stop the current game thread
	    running = false;  
	    key.setActive(false);
	    System.out.println("Setting running to false");

	    if (gt != null) {
	        try {
	            System.out.println("Waiting for game thread to finish...");
	            gt.join(1000); // Wait for up to 1 second
	            if (gt.isAlive()) {
	                System.out.println("Game thread did not finish in time. Forcing shutdown.");
	                gt.interrupt();
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Game thread interrupted while waiting to join.");
	        } finally {
	            gt = null;
	        }
	    }


	    // Now handle the UI transition
	    javax.swing.JFrame frame = (javax.swing.JFrame) this.getTopLevelAncestor();
	    if (frame == null) {
	        System.out.println("Error: Top level ancestor (JFrame) is null.");
	        return;
	    }

	    // Create the battle panel, passing Player and Goblin directly
	    battlePanel bp = new battlePanel(this);
	    System.out.println("Battle panel created.");

	    // Switch to the battle panel
	    javax.swing.SwingUtilities.invokeLater(() -> {
	        System.out.println("Switching to battle panel...");
	        frame.setContentPane(bp);  // Replace the current content pane
	        frame.pack(); // Resize frame for new panel dimensions
	        frame.validate(); // Revalidate layout
	        frame.repaint(); // Ensure the frame is redrawn
	    });

	    // Start the battle panel's game thread
	    bp.startgamethread();
	}
	}

