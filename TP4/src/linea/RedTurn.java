package linea;

public class RedTurn extends GameOn{

	
	public GameState playRed(int column, Linea game) {
		int row = game.isSquareEmpty(column);
		game.board.get(column).set(row, 'r');	
		return new BlueTurn();
	}
		
	public GameState playBlue(int column, Linea game) {
		throw new Error ("Not blue's turn");
	}
	

	protected String whoPlaysNow() {
		return "Red";
	}
	
	
	protected String lastPlayed() {
		return "Blue";
	}

}