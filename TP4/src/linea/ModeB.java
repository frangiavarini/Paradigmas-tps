package linea;

public class ModeB extends GameMode{

public ModeB() {
	super('B');
}

@Override
protected boolean win(Linea fourInLine) {
	return fourInLine.winDiagonally();
}

@Override
public char getMode() {
	return key;
}

}
