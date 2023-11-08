package fourInLine;

public class ModeC extends GameMode{

	@Override
	protected boolean win(FourInLine fourInLine) {
		
		return fourInLine.winHorizontally() || fourInLine.winVertically() || fourInLine.winDiagonally();
	}

	@Override
	public String getMode() {
		// TODO Auto-generated method stub
		return "C";
	}

}
