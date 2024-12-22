package swords;

import Wepons.weapons;
import game.charcters.Player.Player;

public class Normalsword extends weapons {


	public Normalsword() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addweapon(Player player) {
		player.addAD(25);
		System.out.println("u are using a sword now ");
	}

}
