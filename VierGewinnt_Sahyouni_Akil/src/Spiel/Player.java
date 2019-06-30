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
 * Diese Klasse repraesentiert eine abstrakte Klasse Spieler
 *
 */
public abstract class Player {
	private Color color;
	private Bord bord;
	
	/**
	 * Konstruktor Player
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @param bord, braucht ein Objekt vom Typ Bord
	 */
	public Player(Color color, Bord bord) {
		this.color = color;
		this.bord = bord;
	}
	/**
	 * Diese Methode platziert ein Token an der ersten freien Zelle, wobei von unten in der angegebenen Spalte gezaehlt wird
	 * 
	 * @param columnIndex, ist ein integer Wert, der die Nummer der Spalte ist
	 * @throws ColumnFullException, wenn es keinen Platz mehr in der angegebenen Spalte gibt
	 * @throws IllegalMoveException, wenn es schon ein Sieger gibt und versucht wird, noch ein Token einzuwerfen 
	 */
	protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException {
		if(this.bord.canDrop(columnIndex) == false) {
			throw new ColumnFullException("Column Full!");
		}
		if(this.color == Color.RED){
			this.bord.dropToken(this.bord.getToken(Color.RED), columnIndex);
		}if(this.color == Color.YELLOW) {
			this.bord.dropToken(this.bord.getToken(Color.YELLOW), columnIndex);
		}
	}
	/** abstrakte Methode wird von der erbenden Klasse ueberschrieben*/
	public abstract void doTurn();
	
	/**Getter */
	public Color getColor() {return color;}
	public Bord getBord() {return bord;}
}
