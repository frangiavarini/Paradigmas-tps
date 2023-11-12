package linea;

public class GameOver extends GameState{

	
	public GameState playRed(int column, Linea game) {
		throw new RuntimeException("Game already ended");
		
	}

	
	public GameState playBlue(int column, Linea game) {
		throw new RuntimeException("Game already ended");
		
	}

	
	protected String whoPlaysNow() {
		throw new RuntimeException("Game already ended");
	}

	
	protected String lastPlayed() {
		throw new RuntimeException("Game already ended");
	}

}