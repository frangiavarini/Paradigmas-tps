package linea;

public class RedTurn extends GameOn{

	@Override
	public GameState playRed(int column, Linea game) {
		int row = game.isSquareEmpty(column);
		game.board.get(column).set(row, 'r');	
		return new BlueTurn();
	}
		
	public GameState playBlue(int column, Linea game) {
		throw new Error ("Not blue's turn");
	}
	
	@Override
	protected String whoPlaysNow() {
		return "Red";
	}
	
	@Override
	protected String lastPlayed() {
		return "Blue";
	}

}
