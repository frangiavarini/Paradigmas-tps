package fourInLine;

public class BlueTurn extends Turn{

//	public void playAt(int column, FourInLine game) {
//		int row = game.isSquareEmpty(column);
//		game.board.get(row).set(column, 'b');
//		
//	}

	@Override
	public void playRed(int column, FourInLine game) {
		throw new RuntimeException("Not red's turn");
		
	}

	@Override
	public void playBlue(int column, FourInLine game) {
		int row = game.isSquareEmpty(column);
		game.board.get(column).set(row, 'b');
	
		
	}

}
