package Spiel;

public class ConsoleGame extends Game {
	
	public ConsoleGame(Bord bord) {
		super(bord);
	}
	
	public void doGame(Player player1, Player player2) {
		this.setRedPlayer(player1);
		this.setYellowPlayer(player2);
		int randomBeginn = java.util.concurrent.ThreadLocalRandom.current().nextInt(1,3);
		switch(randomBeginn) {
		case 1:
			this.setCurrentPlayer(player1);
			break;
		case 2:
			this.setCurrentPlayer(player2);
			break;
		}
		for(int i = 0;i<=41;i++) {
			if(this.getCurrentPlayer() == this.getRedPlayer()) {
				this.getRedPlayer().doTurn();
				this.swapPlayer();
				this.getBord().toString();
				if(this.getBord().testVictory() == Winner.RED 
						|| this.getBord().testVictory() == Winner.TIE) {
					System.out.println("Winner is: " + this.getBord().testVictory());
					break;
				}
				
			}else {
				this.getYellowPlayer().doTurn();
				this.swapPlayer();
				this.getBord().toString();
				if(this.getBord().testVictory() == Winner.YELLOW 
						|| this.getBord().testVictory() == Winner.TIE) {
					System.out.println("Winner is: " + this.getBord().testVictory());
					break;
				}
			}
		}
	}
}
