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
 * Diese Klasse repraesentiert eine Zelle und ist eine Unterklasse von GameObjekt
 *
 */
public class Cell extends GameObjekt {
	private Token token;
	
	/**
	 * Diese Methode wandelt das Token der Zelle in String um 
	 * 
	 * @return strCell, ein String Wert
	 */
	public String toString() {
		String strCell = "";
		if(this.token == null) {
			strCell = "[ ]";
		}else{
			strCell = "[" + this.token.toString() + "]";
		}
		return strCell;
	}
	
	/** Getter und Setter */
	public Token getToken() {return token;}
	public void setToken(Token token) {this.token = token;}
}
