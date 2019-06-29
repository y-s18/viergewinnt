package Spiel;
import Spiel.Token.Color;
import exceptions.*;
public abstract class Player {
	private Color color;
	private Bord bord = new Bord();
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void setBord(Bord bord) {
		this.bord = bord;
	}

	public Color getColor() {
		return color;
	}

	public Bord getBord() {
		return bord;
	}

	public Player(Color color, Bord bord) {
		this.color = color;
		this.bord = bord;
	}
	
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
	
	public abstract void doTurn();
}
