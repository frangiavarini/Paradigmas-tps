package linea;

	public class ModeC extends GameMode{
	
	public ModeC() {
		super('C');
	}
	
	@Override
	protected boolean win(Linea fourInLine) {
		return fourInLine.winHorizontally() || fourInLine.winVertically() || fourInLine.winDiagonally();
	}
	
	@Override
	public char getMode() {
		return key;
	}

}
