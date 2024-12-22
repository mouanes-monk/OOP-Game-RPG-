package Visuals;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keys implements KeyListener {
public boolean up,dp,lp,rp;
private boolean active = true;

public void setActive(boolean active) {
    this.active = active;
}
	@Override
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!active) {return; // Ignore input if inactive
        
	    }
		int k =e.getExtendedKeyCode();
		System.out.println("oakmdkaz");
	

		if(k==KeyEvent.VK_Z) {
			up = true;
			
		}
        if(k==KeyEvent.VK_S) {
			dp=true;
		}  
        if(k==KeyEvent.VK_Q) {
			lp=true;
		}
        if(k==KeyEvent.VK_D) {
			rp=true;
		}
		
		

		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!active) {return; // Ignore input if inactive
        
	    }
		int k =e.getExtendedKeyCode();
		if(k==KeyEvent.VK_Z) {
			up = false;
		}
        if(k==KeyEvent.VK_S) {
			dp=false;
		}  
        if(k==KeyEvent.VK_Q) {
			lp=false;
		}
        if(k==KeyEvent.VK_D) {
			rp=false;
		}
		
		

		
	}

}
