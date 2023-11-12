package linea;

public class ModeC extends GameMode{

	public ModeC() {
		super('C');
	}
	
	
	protected boolean win(Linea fourInLine) {
		return fourInLine.winHorizontally() || fourInLine.winVertically() || fourInLine.winDiagonally();
	}
	
	
	public char getMode() {
		return key;
	}

}
