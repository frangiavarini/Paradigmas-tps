package linea;

public class ModeB extends GameMode{

	public ModeB() {
		super('B');
	}
	
	
	protected boolean win(Linea fourInLine) {
		return fourInLine.winDiagonally();
	}
	
	
	public char getMode() {
		return key;
	}

}
