package Spiel;

import Spiel.Token.Color;
import exceptions.*;
import java.util.*;
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
 * Diese Klasse repraesentiert ein Spielbrett und ist eine Unterklasse von GameObjekt
 *
 */
public class Bord extends GameObjekt {
	/** Array von Cells des Typs Cell */
	private Cell[][] cells;
	private ArrayList<Token> redTokens;
	private ArrayList<Token> yellowTokens;
	
	/** Standardkonstruktor legt ein leeres Spielbrett der Groesse 6 x 7 an */
	public Bord() {
		final int tokenMaxNum = 21;
		redTokens = new ArrayList <>(tokenMaxNum);
		yellowTokens = new ArrayList<>(tokenMaxNum);
		Token redToken = new Token(Color.RED);
		Token yellowToken = new Token(Color.YELLOW);
		for(int i = 0; i <= 20; i++) {	
			redTokens.add(redToken);
			yellowTokens.add(yellowToken);
		}
		cells = new Cell[6][7];
		for(int i =0; i<cells.length; i++) {
			for(int j =0; j< cells[i].length;j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	public Cell[][] getCells() {
		return cells;
	}
	/** gibt das Spielbett als String auf der Konsole aus. */
	public String toString() {
		
		for(int i =0; i<cells.length; i++) {
			for(int j =0; j< cells[i].length;j++) {
				if(cells[i][j] != null) {
					System.out.print(cells[i][j].toString());
				}
			}
			System.out.println();
		}
		System.out.println();
		return "";
	}
	/**
	 * Diese Methode versucht an der ersten freien Zelle ein Token zu platzieren, wobei von unten in der angegebenen Spalte gezaehlt wird.
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @param columnIndex, ist ein integer Wert, der die Nummer der Spalte ist
	 * @throws ColumnFullException, wenn es keinen Platz mehr in der angegebenen Spalte gibt
	 * @throws IllegalMoveException, wenn es schon ein Sieger gibt und versucht wird, noch ein Token einzuwerfen 
	 */
	public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
		
			for(int i = 5; i <cells.length && i>=0; i--) {
				if(cells[i][columnIndex].getToken() == null
						&& this.testVictory() != Winner.RED
						&& this.testVictory() != Winner.YELLOW) {
					cells[i][columnIndex].setToken(token);
					break;
				}else if(cells[0][columnIndex].getToken() != null){
					throw new ColumnFullException("Column Full!!");
				}else if(this.testVictory() == Winner.RED || this.testVictory() == Winner.YELLOW) {
					throw new IllegalMoveException("Illegal Move");
				}
			}
}
	/**
	 * Diese Methode prueft, ob es noch Platz in der angegebenen Spalte gibt
	 * @param columnIndex, ist ein integer Wert, der die Nummer der Spalte ist
	 * @return canDrop, ein boolean Wert
	 */
	public boolean canDrop(int columnIndex) {
		boolean canDrop = false;
			for(int i = 5; i < cells.length && i >=0;i--) {
				if(cells[i][columnIndex].getToken() != null) {
					canDrop = false;
				}else if(cells[i][columnIndex].getToken() == null) {
					canDrop = true;
					break;
				}
			}
		return canDrop;
	}
	/**
	 * Diese Methode prueft, ob 4 Tokens der selben Farbe in einer Reihe stehen.
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @return isRowVic, ein boolean Wert
	 */
	private boolean isRowVictory(Color color) {
		boolean isRowVic = false;
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0;j < cells[i].length && j+3< cells[i].length; j++) {
				if((cells[i][j].getToken() != null
						&& cells[i][j+1].getToken() != null 
						&& cells[i][j+2].getToken() != null
						&& cells[i][j+3].getToken() != null)
						&& (cells[i][j].getToken().getColor() == color
						&& cells[i][j+1].getToken().getColor() == color
						&& cells[i][j+2].getToken().getColor() == color 
						&& cells[i][j+3].getToken().getColor() == color)) {
					isRowVic = true;
				}
			}
		}
		return isRowVic;
	}
	/**
	 * Diese Methode prueft, ob 4 Tokens der selben Farbe in einer Spalte stehen.
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @return isColumnVic, ein boolean Wert
	 */
	private boolean isColumnVictory(Color color) {
		boolean isColumnVic = false;
		for(int i = 0; i < cells.length && i+3 < cells.length; i++) {
			for(int j = 0;j < cells[i].length; j++) {
				if((cells[i][j].getToken() != null
						&& cells[i+1][j].getToken() != null 
						&& cells[i+2][j].getToken() != null
						&& cells[i+3][j].getToken() != null)
						&& (cells[i][j].getToken().getColor() == color 
						&& cells[i+1][j].getToken().getColor() == color 
						&& cells[i+2][j].getToken().getColor() == color 
						&& cells[i+3][j].getToken().getColor() == color)) {
					isColumnVic = true;
				}
			}
		}
		return isColumnVic;
	}
	/**
	 * Diese Methode prueft, ob 4 Tokens der selben Farbe in einer Diagonale stehen.
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @return isDiagonalVic, ein boolean Wert
	 */
	public boolean isDiagonalVictory(Color color) {
		boolean isDiagonalVic = false;
		for(int i = 0; i < cells.length && i+3 < cells.length; i++) {
			for(int j = 0; j < cells[i].length && j+3 < cells[i].length; j++) {
				if((cells[i][j].getToken() != null
						&& cells[i+1][j+1].getToken() != null 
						&& cells[i+2][j+2].getToken() != null
						&& cells[i+3][j+3].getToken() != null)
						&& (cells[i][j].getToken().getColor() == color 
						&& cells[i+1][j+1].getToken().getColor() == color 
						&& cells[i+2][j+2].getToken().getColor() == color 
						&& cells[i+3][j+3].getToken().getColor() == color)) {
					 return isDiagonalVic = true;
				}
			}
			
		}
		for(int i = 0; i< cells.length && i-3 <cells.length;i++) {
			for(int j = 0; j<cells[i].length && j+3 <cells[i].length;j++) {
					if((i-3>=0 && cells[i][j].getToken()  != null
							&& cells[i-1][j+1].getToken() != null 
							&& cells[i-2][j+2].getToken() != null
							&& cells[i-3][j+3].getToken() != null)
							&& (cells[i][j].getToken().getColor() == color
							&& cells[i-1][j+1].getToken().getColor() == color
							&& cells[i-2][j+2].getToken().getColor() == color 
							&& cells[i-3][j+3].getToken().getColor() == color)) {
						return isDiagonalVic = true;
				}
			}
		}
		return isDiagonalVic;
	}
	/**
	 * Diese Methode prueft, ob ein Gleichstand aufgetreten ist.
	 * 
	 * @return isTie, ein boolean Wert
	 */
	private boolean isTie() {
		boolean isTie = false;
		if(redTokens.isEmpty() && yellowTokens.isEmpty() 
				&& (this.isRowVictory(Color.RED) == false
				&& this.isColumnVictory(Color.RED) == false
				&& this.isDiagonalVictory(Color.RED) == false
					&& this.isRowVictory(Color.YELLOW) == false
					&& this.isColumnVictory(Color.YELLOW) == false
					&& this.isDiagonalVictory(Color.YELLOW) == false)) {
			isTie = true;
		}
		return isTie;
	}
	/**
	 * Diese Methode prueft alle drei Siegbedingungen aller Farben.
	 * 
	 * @return winner, ein Objekt vom Enumerator Typ Winner.
	 */
	public Winner testVictory() {
		Winner winner = Winner.NONE;
		if(this.isRowVictory(Color.RED) == true || this.isColumnVictory(Color.RED) == true || this.isDiagonalVictory(Color.RED) == true) {
			 winner = Winner.RED;
		}else if(this.isRowVictory(Color.YELLOW) == true || this.isColumnVictory(Color.YELLOW) == true || this.isDiagonalVictory(Color.YELLOW) == true) {
			winner = Winner.YELLOW;
		}else if(this.isRowVictory(Color.RED) == false
				&& this.isColumnVictory(Color.RED) == false
				&& this.isDiagonalVictory(Color.RED) == false
					&& this.isRowVictory(Color.YELLOW) == false
					&& this.isColumnVictory(Color.YELLOW) == false
					&& this.isDiagonalVictory(Color.YELLOW) == false){
			 winner= Winner.NONE;
		}if(this.isTie()) {
			winner = Winner.TIE;
		}
		return winner;
	}
	/**
	 * Diese Methode entfernt einen Stein der angegebenen Farbe aus dem Tokenslager 
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @return token, das aus dem Lager entfernt wurde
	 */
	public Token getToken(Color color) {
		Token token = new Token();
		if(color == Color.RED) {
			token = redTokens.get(0);
			redTokens.remove(0);
		}if(color == Color.YELLOW) {
			token = yellowTokens.get(0);
			yellowTokens.remove(0);
			
		}
		return token;
	}
	/**
	 * Diese Methode prueft, ob es noch Steine mit der angegebenen Farbe im Tokenslager gibt
	 * 
	 * @param color, braucht ein Objekt vom Enumerator Typ Color
	 * @return hasToken, ein boolean Wert
	 */
	public boolean hasToken(Color color) {
		boolean hasToken = false;
		if(color == Color.RED) {
			hasToken = (!redTokens.isEmpty());
		}if(color == Color.YELLOW) {
			hasToken = (!yellowTokens.isEmpty());
		}
		return hasToken;
	}
}
