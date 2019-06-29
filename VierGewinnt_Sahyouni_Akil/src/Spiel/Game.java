package Spiel;

import Spiel.Token.Color;

public abstract class Game {
	private Bord bord;
	private Player redPlayer = new ConsolePlayer(Color.RED, bord);
	private Player yellowPlayer = new ConsolePlayer(Color.YELLOW, bord);
	private Player currentPlayer;
	
	public Game(Bord bord) {
		this.bord = bord;
	}
	
	protected void swapPlayer() {
		if(currentPlayer==redPlayer) {
			currentPlayer = yellowPlayer;
		}else {
			currentPlayer = redPlayer;
		}
	}


}
