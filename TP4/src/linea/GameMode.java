package linea;

import java.util.List;

public abstract class GameMode {
protected char key;
protected abstract boolean win(Linea fourInLine);
public char getMode(){
	return key;
}

public GameMode (char key) {
	this.key = key;
}
public boolean applies (char tipoDeJuego) {
	return key == tipoDeJuego;
}

public static GameMode setGameMode(char mode) {
	return List.of(new ModeA(), new ModeB(), new ModeC()).stream().filter(each -> each.applies(mode)).findFirst().orElseThrow(() -> new Error ("The requested mode does not exist"));
}

}
