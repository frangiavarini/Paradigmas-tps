package fourInLine;

public class ModeB extends GameMode{

	@Override
	protected boolean win(FourInLine fourInLine) {
		
		return fourInLine.winDiagonally();
	}

	@Override
	public String getMode() {
		// TODO Auto-generated method stub
		return "B";
	}

}
