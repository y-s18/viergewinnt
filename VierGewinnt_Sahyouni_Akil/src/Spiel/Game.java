package Spiel;

import Spiel.Token.Color;

public abstract class Game {
	private Bord bord;
	private Player redPlayer;
	private Player yellowPlayer;
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
	public Bord getBord() {
		return bord;
	}

	public void setRedPlayer(Player redPlayer) {
		this.redPlayer = redPlayer;
	}

	public void setYellowPlayer(Player yellowPlayer) {
		this.yellowPlayer = yellowPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public abstract void doGame(Player player1, Player player2);

	public Player getRedPlayer() {
		return redPlayer;
	}

	public Player getYellowPlayer() {
		return yellowPlayer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

}
