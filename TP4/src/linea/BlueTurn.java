package linea;

public class BlueTurn extends GameOn{

	
	public GameState playRed(int column, Linea game) {
		throw new Error ("Not red's turn");	
	}
	
	
	public GameState playBlue(int column, Linea game) {
		int row = game.isSquareEmpty(column);
		game.board.get(column).set(row, 'b');
		return new RedTurn();
	}
	
	
	protected String whoPlaysNow() {
		return "Blue";
	}
	
	
	protected String lastPlayed() {
		return "Red";
	}

}
