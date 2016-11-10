package start;

import java.util.Scanner;
import model.SpaceInvaders;
import model.World;

public class Main {

	private static Scanner sc;

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

		System.out.println("Veuillez cliqué sur D/G pour effectuée un deplacement Droite / Gauche");
		System.out.println("	ou Q pour quitter");
		
		
		boolean repeter=true;
		
		while(repeter == true ){

			sc = new Scanner(System.in);
			String str = sc.nextLine();

				if( str.contentEquals("D") ){
					spaceInvaders.turnRight();
				}
				
				if( str.contentEquals("G") ){
					spaceInvaders.turnLeft();
				}
				
				if(str.contentEquals("Q")){
					System.out.println("Je quitte");
					repeter = false;
				}else {
					System.out.println("\n");
					System.out.println("Veuillez cliqué sur D/G pour effectuée un deplacement Droite / Gauche");
					System.out.println("------------------------ ou Q pour quitter---------------------------\n");
				}
				
				
		}
	
	
	}
}


	

