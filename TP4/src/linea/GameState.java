package linea;

public abstract class GameState {
	
	public  abstract GameState playRed(int column, Linea game);
	public abstract GameState playBlue(int column, Linea game);
	protected abstract String whoPlaysNow();
	protected abstract String lastPlayed();
}
