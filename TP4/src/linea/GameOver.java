package linea;

public class GameOver extends GameState{

	@Override
	public GameState playRed(int column, Linea game) {
		throw new RuntimeException("Game already ended");
		
	}

	@Override
	public GameState playBlue(int column, Linea game) {
		throw new RuntimeException("Game already ended");
		
	}

	@Override
	protected String whoPlaysNow() {
		throw new RuntimeException("Game already ended");
	}

	@Override
	protected String lastPlayed() {
		throw new RuntimeException("Game already ended");
	}

}
