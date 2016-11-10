package start;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez clické sur D/G pour effectuée un deplacement");
		String str = sc.nextLine();
		System.out.println( ""+str);
		if(str=="D"){
			System.out.println("touche bien saisi -D ");
		}
		if(str=="G"){
			System.out.println("touche bien saisi -G ");
		}else {
			System.out.println("reesai :");
		}
			
		}

}
