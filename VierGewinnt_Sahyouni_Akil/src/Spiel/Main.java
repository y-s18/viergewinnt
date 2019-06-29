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
	
	Bord bord = new Bord();
	Player redPlayer = new ConsolePlayer(Color.RED, bord);
	Player yellowPlayer = new ConsolePlayer(Color.YELLOW, bord);
	Game game = new ConsoleGame(bord);	
	game.doGame(redPlayer, yellowPlayer);
		
		
	}
}
