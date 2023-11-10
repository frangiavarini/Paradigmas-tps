package fourInLine;

public class RedTurn extends Turn{

//	@Override
//	public void playAt(int column, FourInLine game) {
//		int row = game.isSquareEmpty(column);
//		game.board.get(row).set(column, 'r');
//		
//	}

	@Override
	public void playRed(int column, FourInLine game) {
		int row = game.isSquareEmpty(column);
		game.board.get(column).set(row, 'r');
	}

	@Override
	public void playBlue(int column, FourInLine game) {
		throw new RuntimeException("Not blue's turn");
		
	}

}
