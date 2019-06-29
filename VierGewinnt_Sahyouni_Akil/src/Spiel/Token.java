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
 * Diese Klasse repraesentiert ein Token und ist eine Unterklasse von GameObjekt
 *
 */
public class Token extends GameObjekt{
	
	public enum Color{
		RED, YELLOW
	}
	
	private Color color;
	
	public Token() {}
	public Token(Color color) {
		this.color = color;
	}
	/** Getter */
	public Color getColor(){
		return color;
	}
	/**
	 * Diese Methode wandelt die Farbe des Tokens in String um.
	 * 
	 * @return strToken, ein String Wert
	 */
	public String toString() {
		String strToken = "";
		if(this.color == null) {
			strToken = " ";
		}else if(this.color == Color.RED) {
			strToken = "X";
		}else if(this.color == Color.YELLOW) {
			strToken = "O";
		}
		//return this.color == RED : "X" : "O";
		return strToken;
	}
}
