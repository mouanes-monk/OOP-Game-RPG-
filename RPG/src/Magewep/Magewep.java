package Magewep;

import Wepons.weapons;
import game.charcters.Player.Player;

public class Magewep extends weapons {

	@Override
	public void addweapon(Player player) {
		player.addAP(20);
		System.out.println("u are using a  magical stick now ");
		
	}

}
