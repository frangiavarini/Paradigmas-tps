package fourInLine;

public class RedTurn extends Turn{

	@Override
	public void playAt(int column, FourInLine game) {
		int row = game.isSquareEmpty(column);
		game.board.get(row).set(column, 'r');
		
	}

}
