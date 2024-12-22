package game;import game.charcters.Player.Assassin;

import game.charcters.Player.Player;
import swords.Normalsword;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import Visuals.Gamepannel;
import game.charcters.Charcters;
import game.charcters.Enemys.Enemeys;
import game.charcters.Enemys.Goblins;
import game.charcters.Player.Player;
public class game {

	public static void main(String[] args) {
		 
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Final hope");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Gamepannel gp=new Gamepannel();
		sound sound = new sound();
		window.add(gp);
		window.pack();
		gp.startgamethread();
		
		 sound.setFile("/sound/theme.wav");  // Use the correct relative path
	        sound.loop(); 

		
		
		
Player kong=new Assassin();
Normalsword sword = new Normalsword();
sword.addweapon(kong);
System.out.println("your hp is "+kong.getHP()+""+kong.getAD());


fighting fight =new fighting();

	fight.battle(kong, gp.goblin);

}}
