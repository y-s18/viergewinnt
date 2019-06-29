package Spiel;
import java.io.*;
import exceptions.*;
import Spiel.Token.Color;
public class ConsolePlayer extends Player {
	
	
	public ConsolePlayer(Color color, Bord bord) {
		super(color, bord);
	}
	
	public void doTurn() {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = consoleReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int inputInt = Integer.parseInt(input);
		try {
			super.doDrop(inputInt-1);
		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}
}
