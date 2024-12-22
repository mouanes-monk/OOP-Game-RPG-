package Visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.fighting;
import game.charcters.Enemys.Goblins;
import game.charcters.Player.Player;
import map.mapmanger;

public class battlePanel extends JPanel implements Runnable{
	  private Player player;
	    private Goblins goblin;
	    CharacterHUD hud;
		Thread gt;
		 
	    public mapmanger tile = new mapmanger(this);
	    playerturn pturn ;
	    fighting fight = new fighting();
	    private enum BattleState { PLAYER_TURN, ENEMY_TURN, BATTLE_OVER }
	    private BattleState battleState;

    public battlePanel(Gamepannel previousPanel) {
    	System.out.println("Battle panel initialized.");

        this.player = previousPanel.p;
        this.goblin = previousPanel.goblin;
       hud=new CharacterHUD(player.profile);
        player.returnstats();
        keys key=new keys();
        this.addKeyListener(key); 
          pturn =new playerturn(player, goblin,key);
          this.setLayout(null); 
          this.add(pturn);
          hud.setBounds(10, 10, 220, 100);
          this.add(hud);
          pturn.setBounds(250, 550, 200, 100);
          this.setOpaque(false);
        this.setBackground(Color.DARK_GRAY); // Set background for battle screen
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(1024, 768)); // Larger resolution
        this.setBackground(java.awt.Color.BLACK); 
        tile.getimage();
        battleState = BattleState.PLAYER_TURN;
       
       
    }
    public void startgamethread() {
    	gt=new Thread(this);
    	gt.start(); 

    }
    public void run() {

    	  while (player.getHP() > 0 && goblin.getHP() > 0) {
			
			double drawintr=1000000000/60;
			double drawtime=drawintr+System.nanoTime();
			update();
			repaint();
			hud.updateStats(player.getHP(),player.getdeff());
			
			
			
			
			try {long remaint=(long) (drawtime-System.nanoTime());
			 remaint=remaint/1000000;
			 if(remaint<0) {remaint=0;}
				Thread.sleep(remaint);
				drawtime += drawintr; 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); 
				e.printStackTrace();
			}}
		}
		public void update(){
			player.updtaef();
			goblin.updatef();
	
			
			 switch (battleState) {
	            case PLAYER_TURN:
	            	
	                playerTurn();
	                break;

	            case ENEMY_TURN:
	           	 System.out.println("goblin attacked");
	                enemyTurn();
	                
	                break;

	            case BATTLE_OVER:
	                // End the battle and return to the main game
	                System.out.println("Battle is over!");
	                stopBattle();
	                break;
	        }
		
		}
		 private void stopBattle() {
		        gt = null;
		        // You can add logic here to transition back to the main game
		    }
		private void playerTurn() {
		
			
               pturn.update();
               
           
		    if (goblin.getHP() <= 0) {
		        System.out.println("The " + goblin.getname() + " has been eliminated!");
		        battleState = BattleState.BATTLE_OVER;
		    } else { if(pturn.moveChosen==true) {  
		 
                pturn.moveChosen = false;
            	
		        battleState = BattleState.ENEMY_TURN;
		  }
		    }
			
		}

		private void enemyTurn() {
	
		    fight.enemierturn(player, goblin); // Call the method from the `fighting` class
		    if (player.getHP() <= 0) {
		        System.out.println("You lost!");
		        battleState = BattleState.BATTLE_OVER;
		    } else {
		        battleState = BattleState.PLAYER_TURN;
		    }}


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

       
        tile.drawf(g2);
        player.drawf(g2);
        goblin.drawf(g2);

    }
}


