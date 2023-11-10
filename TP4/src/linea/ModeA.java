package linea;

public class ModeA extends GameMode {
	
public ModeA() {
	super('A');
}

@Override
protected boolean win(Linea fourInLine) {
	return fourInLine.winHorizontally() || fourInLine.winVertically() ;
}

@Override
public char getMode() {
	return key;
}




}
