package start;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Veuillez clické sur 1/2 pour effectuée un deplacement 1=droite / 2=gauche");
		System.out.println("	ou Q pour quitter");
		
		
		boolean repeter=true;
		
		while(repeter==true){

			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
				if(str == 1 ){
					System.out.println("touche bien saisi -D ");
				}
				
				if(str == 2){
					System.out.println("touche bien saisi -G ");
					
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
