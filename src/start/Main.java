package start;

import java.util.Scanner;
import model.SpaceInvaders;
import model.World;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creation de notre monde
		World w = new World();
		
		SpaceInvaders spaceInvaders = w.getSpace();
		
		float longueur = w.getWorld_width();
		float hauteur = w.getWorld_height();
		
		System.out.println("La carte fait : " + longueur+ "-" + hauteur);
		System.out.println("La position de la fusée : " + spaceInvaders.getX() + "-" + spaceInvaders.getY());

		System.out.println("Veuillez cliqué sur 1/2 pour effectuée un deplacement 1=droite / 2=gauche");
		System.out.println("	ou Q pour quitter");
		
		
		boolean repeter=true;
		
		while(repeter == true ){

			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
				if(str == 1 ){
					spaceInvaders.turnRight();
				}
				
				if(str == 2){
					spaceInvaders.turnLeft();
					
				}
				System.out.println("----------------- :");
				System.out.println("Veuillez cliqué sur 1/2 pour effectuée un deplacement 1=droite / 2=gauche");
				System.out.println("	ou Q pour quitter");
				
				if(str == 3){
					System.out.println("Je quitte");
					repeter = false;
				}
				
		}
	
	
	}
}


	

