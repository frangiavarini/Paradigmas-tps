package fourInLine;

public class ModeA extends GameMode {

	@Override
	protected boolean win(FourInLine fourInLine) {
		return fourInLine.winHorizontally() || fourInLine.winVertically() ;
	}

	@Override
	public String getMode() {
		
		return "A";
	}

}
