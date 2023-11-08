package fourInLine;

public class BlueTurn extends Turn{

	public void playAt(int column, FourInLine game) {
		int row = game.isSquareEmpty(column);
		game.board.get(row).set(column, 'b');
		
	}

}
