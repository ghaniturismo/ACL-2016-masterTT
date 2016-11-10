package start;

import java.util.Scanner;

import model.SpaceInvaders;
import model.World;

import com.sun.org.apache.bcel.internal.generic.RETURN;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		World w = new World();
		SpaceInvaders space = w.getSpace();
		float longueur = w.getWorld_width();
		float hauteur = w.getWorld_height();
		
		System.out.println("La carte fait : " + longueur+ "-" + hauteur);
		System.out.println("La position de la fusée : " + space.getX() + "-" + space.getY());

		System.out.println("Veuillez clické sur 1/2 pour effectuée un deplacement 1=droite / 2=gauche");
		System.out.println("	ou Q pour quitter");
		
		
		boolean repeter=true;
		
		while(repeter==true){

			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
				if(str == 1 ){
					float tmp = space.getX() + 1;
					System.out.println(tmp);
					if(longueur > tmp ){
					space.setX(tmp);
					System.out.println("La position de la fusée : " + space.getX() + "-" + space.getY());
					}else{
						System.out.println("impossible :  depassement de la fenetre \n");
					}
				}
				
				if(str == 2){
					float tmp = space.getX() - 1;
					if(tmp>=0){
					space.setX(tmp);
					System.out.println("La position de la fusée : " + space.getX() + "-" + space.getY());
					}else{
						System.out.println("impossible :  depassement de la fenetre \n");
					}
					
				}
				System.out.println("----------------- :");
				System.out.println("Veuillez clické sur 1/2 pour effectuée un deplacement 1=droite / 2=gauche");
				System.out.println("	ou Q pour quitter");
				
				
				if(str == 3){
					System.out.println("Je quitte");
					repeter = false;
				}
				
		}
	
	
	}
}


	

