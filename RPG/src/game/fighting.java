package game;

import java.util.Random;
import java.util.Scanner;

import game.charcters.Charcters;
import game.charcters.Enemys.Enemeys;
import game.charcters.Player.Player;

public class fighting {Scanner sc = new Scanner(System.in);
Random rd=new Random();
 public int battle(Player player ,Enemeys enemie){
	 System.out.println("ur turn"+player.getHP());
	 System.out.println("goblin turn"+enemie.getHP());
	 while(player.getHP()>0 && enemie.getHP()>0) {
		 
		 playerturn(player,enemie);
		 
		 if(enemie.getHP()<0) {System.out.println("the "+enemie.getname()+"has been eliminated"); break;}
		 enemierturn(player,enemie);
		 if(player.getHP()<0) {System.out.println("u lost"); break;}
		
	 }
 return 0;}
 
 int battle(Player player ,Enemeys enemie,Enemeys enemie2){
	 while(player.getHP()>0 && enemie.getHP()>0 && enemie2.getHP()>0) {
		 playerturn(player,enemie);
		 
		 if(enemie.getHP()<0) {System.out.println("the "+enemie.getname()+"has been eliminated");}
		 if(enemie2.getHP()<0) {System.out.println("the "+enemie2.getname()+"has been eliminated");}
		 
		 enemierturn(player,enemie);
		 if(player.getHP()<0) {System.out.println("u lost"); 
		 
		 }
		 enemierturn(player,enemie2);
         if(player.getHP()<0) {System.out.println("u lost"); 
		 
		 }
	 }
	 return 0;}
 
 
 
 
 public void playerturn(Player player ,Enemeys enemie) {
	 System.out.println("your tourn , chose ur action :");
	 int x= sc.nextInt();
	 switch(x) {
	 case 1 : 
		 player.attack(enemie);
		 
		 break;
	 case 2 :
		 player.defense();
		 System.out.println("u bossted ur defeense to "+player.getDef());
		 
		 break ;
	 case 3:
		 player.dodgeab();
		 break ;
	 case 4: 
		 player.technic1(enemie);
		
	 
	 }
	 enemie.returnstats();
 }
 public void enemierturn(Player player ,Enemeys enemie) {
	int j= rd.nextInt(1)+1;
	 ;
	 switch(j) {
	 case 1 : 
	
		 enemie.attack(player);
		 break;
	 case 2 :
		 enemie.defense();
		 break ;
		
	 
	 }
	 player.returnstats();
 }
}

