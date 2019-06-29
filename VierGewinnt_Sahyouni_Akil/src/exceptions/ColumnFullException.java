package exceptions;
/*
 * yamen.sahyouni@tu-clausthal.de 		/ mohamad.deyaa.akil@tu-clausthal.de
 * Vorname: Yamen  						/ Deyaa
 * Nachname: Sahyouni  					/ Akil
 * Matrikel-Nr.498773  					/ 498618
 *
 */
/**
 * @author Yamen Sahyouni, Deyaa Akil
 */
@SuppressWarnings("serial")
public class ColumnFullException extends Exception{
	public ColumnFullException() {
		super();
	}
	public ColumnFullException(String s) {
		super(s);
	}
}
