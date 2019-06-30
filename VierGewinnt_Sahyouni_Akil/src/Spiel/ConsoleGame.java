package Spiel;
import Spiel.Token.Color;
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
 * Diese Klasse repraesentiert eine Konsole von Game und ist eine Unterklasse von der Klasse Game
 *
 */
public class ConsoleGame extends Game {
	
	public ConsoleGame(Bord bord) {
		super(bord);
	}
	/**
	 * Diese Methode waehlt aus, einen Spieler zu beginnen. 
	 * Dann fragt die Methode solange abwechselnd die Spieler nach einem Zug Mithilfe der Methode (doTurn),
	 * bis es einen Sieger oder ein Unentschieden in der Spielpartie gibt.
	 * Nach jedem Zug wird das Spielbrett auf der Konsole ausgegeben.
	 * 
	 * @param player1, braucht ein Objekt vom Typ Player
	 * @param player2, braucht ein Objekt vom Typ Player
	 */
	public void doGame(Player player1, Player player2) {
		if(player1.getColor() == Color.RED) {
			this.setRedPlayer(player1);
		}else{
			this.setYellowPlayer(player1);
		}if(player2.getColor() == Color.RED) {
			this.setRedPlayer(player2);
		}else{
			this.setYellowPlayer(player2);
		}
		int randomBeginn = java.util.concurrent.ThreadLocalRandom.current().nextInt(1,3);
		switch(randomBeginn) {
		case 1:
			this.setCurrentPlayer(player1);
			break;
		case 2:
			this.setCurrentPlayer(player2);
			break;
		}
		this.getBord().toString();
		do {
			if(this.getCurrentPlayer() == this.getRedPlayer()) {
				System.out.println("Spieler X, was ist dein nächster Zug?");
				System.out.print("Eingabe: ");
				int prevNumOfRedTokens = this.getBord().countRedTokens();
				this.getRedPlayer().doTurn();
				int currNumOfRedTokens = this.getBord().countRedTokens();
				if(currNumOfRedTokens != prevNumOfRedTokens) {
					this.swapPlayer();
					this.getBord().toString();
				}else {
					continue;
				}
				if(this.getBord().testVictory() == Winner.RED 
						|| this.getBord().testVictory() == Winner.TIE) {
					System.out.println("Winner is: " + this.getBord().testVictory());
					break;
				}
			}if(this.getCurrentPlayer() == this.getYellowPlayer()) {
				System.out.println("Spieler O, was ist dein nächster Zug?");
				System.out.print("Eingabe: ");
				int prevNumOfYellowTokens = this.getBord().countYellowTokens();
				this.getYellowPlayer().doTurn();
				int currNumOfYellowTokens = this.getBord().countYellowTokens();
				if(currNumOfYellowTokens !=prevNumOfYellowTokens) {
					this.swapPlayer();
					this.getBord().toString();
				}else {
					continue;
				}
				if(this.getBord().testVictory() == Winner.YELLOW 
						|| this.getBord().testVictory() == Winner.TIE) {
					System.out.println("Winner is: " + this.getBord().testVictory());
					break;
				}
			}
		}while(this.getBord().testVictory() != Winner.YELLOW
				&& this.getBord().testVictory() != Winner.RED
				&& this.getBord().testVictory() != Winner.TIE);
	}
}
