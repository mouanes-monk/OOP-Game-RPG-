package assawep;

import Wepons.weapons;
import game.charcters.Player.Player;

public class Knife  extends weapons{

	@Override
	public void addweapon(Player player) {
		player.addAD(25);
		System.out.println("u are using a knife now ");
	}

}
