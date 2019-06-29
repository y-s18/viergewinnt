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
		int inputInt = 0;
		try {
			input = consoleReader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			inputInt = Integer.parseInt(input);
			if(inputInt >0 && inputInt <8) {
				super.doDrop(inputInt-1);
			}else {
				System.out.println("Invaild Input!");
				System.out.println();
			}
		}catch(NumberFormatException e) {
			System.out.println("Invalid Input, Please try again!");
		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}

		}
	}

