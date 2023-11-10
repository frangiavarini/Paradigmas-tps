package linea;

public abstract class Turn{
public  abstract void playRed(int column, Linea game);
public  abstract void playBlue(int column, Linea game);
protected abstract String whoPlaysNow();
protected abstract String lastPlayed();
}
