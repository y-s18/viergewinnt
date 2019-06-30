package Spiel;
import java.io.*;
import exceptions.*;
import Spiel.Token.Color;
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
 * Diese Klasse repraesentiert eine Konsole von Spieler und ist eine Unterklasse von der Klasse Player
 *
 */
public class ConsolePlayer extends Player {
	
	
	public ConsolePlayer(Color color, Bord bord) {
		super(color, bord);
	}
	/**
	 * Diese Methode fragt den Nutzer ueber Konsole nach einer Eingabe
	 */
	public void doTurn() {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int inputInt = 0;
		try {
			input = consoleReader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			inputInt = Integer.parseInt(input);
			if(inputInt >=0 && inputInt <7) {
				super.doDrop(inputInt);
			}else {
				System.out.println("Invaild Input!");
				System.out.println();
			}
		}catch(NumberFormatException e) {
			System.out.println("Invalid Input, Please try again!");
			System.out.println();
		}catch (ColumnFullException e) {
			System.out.println("Column Full!");
			System.out.println();
		}catch (IllegalMoveException e) {
			System.out.println("Illegal Move!");
			System.out.println();
		}
	}
}

