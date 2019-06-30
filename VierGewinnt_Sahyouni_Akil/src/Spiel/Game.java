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
 * Diese Klasse repraesentiert eine abstrakte Klasse Game
 *
 */
public abstract class Game {
	private Bord bord;
	private Player redPlayer;
	private Player yellowPlayer;
	private Player currentPlayer;
	
	public Game(Bord bord) {
		this.bord = bord;
	}
	
	/**
	 * Diese Methode wechselt den aktuellen Spieler.
	 */
	protected void swapPlayer() {
		if(currentPlayer==redPlayer) {
			currentPlayer = yellowPlayer;
		}else {
			currentPlayer = redPlayer;
		}
	}
	/** abstrakte Methode wird von der erbenden Klasse ueberschrieben */
	public abstract void doGame(Player player1, Player player2);
	
	/**Getter und Setter */
	public Bord getBord() {return bord;}
	public void setRedPlayer(Player redPlayer) {this.redPlayer = redPlayer;}
	public Player getRedPlayer() {return redPlayer;}
	public void setYellowPlayer(Player yellowPlayer) {this.yellowPlayer = yellowPlayer;}
	public Player getYellowPlayer() {return yellowPlayer;}
	public void setCurrentPlayer(Player currentPlayer) {this.currentPlayer = currentPlayer;}
	public Player getCurrentPlayer() {return currentPlayer;}
	
	
}
