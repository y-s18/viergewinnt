package Spiel;
/*
 * yamen.sahyouni@tu-clausthal.de 		/ mohamad.deyaa.akil@tu-clausthal.de
 * Vorname: Yamen  						/ Deyaa
 * Nachname: Sahyouni  					/ Akil
 * Matrikel-Nr.498773  					/ 498618
 *
 */
/**
 * 
 * @author Yamen Sahyouni, Deyaa Akil
 * 
 * Diese Klasse nutzt die Klasse Bord
 *
 */
import Spiel.Token.Color;
import exceptions.*;

public class Main {
	/**Einstiegsmethode, legt 4 Objekte vom Typ Bord an und arbeitet mit diesen */ 
	public static void main(String[] args) throws ColumnFullException, IllegalMoveException {
		
		Bord bord1 = new Bord();
		Bord bord2 = new Bord();
		Bord bord3 = new Bord();
		Bord bord4 = new Bord();
		
		bord1.dropToken(bord1.getToken(Color.YELLOW), 2);
		bord1.dropToken(bord1.getToken(Color.RED), 2);
		bord1.dropToken(bord1.getToken(Color.YELLOW), 4);
		bord1.dropToken(bord1.getToken(Color.YELLOW), 4);
		bord1.dropToken(bord1.getToken(Color.RED), 4);
		bord1.dropToken(bord1.getToken(Color.YELLOW), 5);
		bord1.dropToken(bord1.getToken(Color.RED), 5);
		bord1.dropToken(bord1.getToken(Color.RED), 6);
		bord1.dropToken(bord1.getToken(Color.RED), 6);
		bord1.dropToken(bord1.getToken(Color.RED), 6);
		bord1.dropToken(bord1.getToken(Color.YELLOW), 6);
		bord1.dropToken(bord1.getToken(Color.YELLOW), 3);
		
		bord1.toString();
		System.out.println("Winner is: " + bord1.testVictory());
		System.out.println();
		
		bord2.dropToken(bord2.getToken(Color.YELLOW), 0);
		bord2.dropToken(bord2.getToken(Color.RED), 1);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 2);
		bord2.dropToken(bord2.getToken(Color.RED), 2);
		bord2.dropToken(bord2.getToken(Color.RED), 3);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 5);
		bord2.dropToken(bord2.getToken(Color.RED), 5);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 6);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 6);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 6);
		bord2.dropToken(bord2.getToken(Color.YELLOW), 4);
		bord2.dropToken(bord2.getToken(Color.RED), 4);
		bord2.dropToken(bord2.getToken(Color.RED), 4);
		bord2.dropToken(bord2.getToken(Color.RED), 4);
		bord2.dropToken(bord2.getToken(Color.RED), 4);

		bord2.toString();
		System.out.println("Winner is: " + bord2.testVictory());
		System.out.println();
		
		for(int row = 0; row < bord4.getCells().length; row++) {
			for(int col= 0; col < bord4.getCells()[row].length; col++) {
				if(row % 2 == 0) {
					if(col == 3) {
						bord4.dropToken(bord4.getToken(Color.YELLOW), col);
						continue;
					}
					bord4.dropToken(bord4.getToken(Color.RED), col);
				}if(row % 2 != 0) {
					if(col == 3) {
						bord4.dropToken(bord4.getToken(Color.RED), col);
						continue;
					}
					bord4.dropToken(bord4.getToken(Color.YELLOW), col);
				}
			}
		}
		bord4.toString();
		System.out.println("Winner is: " + bord4.testVictory());
		System.out.println();
		
		/**
		 * Dieses Spielbrett wird immer eine IllegalMoveException werfen, da es zwei Sieger gibt,
		 * d.h es wird immer versucht, einen Stein nach einem Sieg einzuwerfen. Und das fuehrt zu dem Werfen der IllegalMoveException.
		 */
		bord3.dropToken(bord3.getToken(Color.YELLOW), 3);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 3);
		bord3.dropToken(bord3.getToken(Color.RED), 3);
		bord3.dropToken(bord3.getToken(Color.RED), 3);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 4);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 4);
		bord3.dropToken(bord3.getToken(Color.RED), 4);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 5);
		bord3.dropToken(bord3.getToken(Color.RED), 5);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 5);
		bord3.dropToken(bord3.getToken(Color.RED), 6);
		bord3.dropToken(bord3.getToken(Color.RED), 6);
		bord3.dropToken(bord3.getToken(Color.RED), 6);
		bord3.dropToken(bord3.getToken(Color.YELLOW), 6);
		
		bord3.toString();
		System.out.println("Winner is: " + bord3.testVictory());
		System.out.println();
		
		
	}
}
