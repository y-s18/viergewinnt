package Spiel;
import Spiel.Token.Color;
import exceptions.*;
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
public class GameMain_Console {
	/**
	* legt ein Objekt vom Typ Bord an.
	* legt zwei Objekte vom Typ ConsolePlayer an, die Farben und ein Spielbrett brauchen.
	* legt ein Objekt vom Typ ConsoleGame an, das ein Spielbrett braucht.
	* Die Methode doGame() aufrufen, die die zwei schon angelegte Spieler braucht.
	* 
	*/ 
	public static void main(String[] args) throws ColumnFullException, IllegalMoveException {
		
	Bord bord = new Bord();
	Player redPlayer = new ConsolePlayer(Color.RED, bord);
	Player yellowPlayer = new ConsolePlayer(Color.YELLOW, bord);
	Game game = new ConsoleGame(bord);	
	game.doGame(redPlayer, yellowPlayer);
			
	}
}
