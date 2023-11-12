	package linea;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.stream.IntStream;
	import java.util.ArrayList;
	
public class Linea {
		public  List<List<Character>> board;
		private int height;
		private int width;
		public GameMode gameMode;
		public boolean redTurn;
		public GameState gameState;
	
		    
		public Linea (int columns, int rows, char gameMode) {
		
		   if (rows < 4 || columns < 4) throw new Error("Not a possible board");
	        height = rows;
	        width = columns;
	        this.gameMode = GameMode.setGameMode(gameMode);
	        redTurn = true;
	        gameState = new RedTurn();

	        board = IntStream.range(0, columns)
	                .mapToObj(i -> IntStream.range(0, rows)
	                        .mapToObj(j -> ' ')
	                        .collect(Collectors.toCollection(ArrayList::new)))
	                .collect(Collectors.toCollection(ArrayList::new));
		
	}
			
	public boolean endGame() {
		return gameMode.win(this) || notEmptySpaces();
	}
	
	public String lastPlayed() {
		return gameState.lastPlayed();
	}
	
	public boolean notEmptySpaces() {
	    return board.stream()
	            .flatMap(List::stream)
	            .noneMatch(square -> square == ' ');
	}
		        
	public int isSquareEmpty(int column) {
		int row = IntStream.range(0, height)
		        .filter(i -> board.get(column).get(i) == ' ')
		        .findFirst()
		        .orElseThrow(() -> new Error("This column is full"));

		return row;
	}
		    
	public Linea playRedAt(int column) {
		if(!endGame()) {
			if(column <= width) {
				gameState=gameState.playRed(column-1, this);
		       
		    } else {
		    	throw new Error("Inexistent column");
		    }
		}
		else{
			gameState=new GameOver();
		}
		return this;
	}
		    
	
	
	public Linea playBlueAt(int column) {
		if(!endGame()) {
			if (column <= width) {
				gameState = gameState.playBlue(column-1, this);
				
			} else {
				throw new Error("Inexistent column");
			}
		} else {
			gameState=new GameOver();
		}
		return this;
	}

		
	private boolean sameGamePieceVertically(int x, int y) {
		char square = board.get(x).get(y);
		return square != ' ' &&
				square == board.get(x).get(y+1) &&
				square == board.get(x).get(y+2) &&
				square == board.get(x).get(y+3);  
	}
			
	private boolean sameGamePieceHorizontally(int x, int y) {
		char square = board.get(x).get(y);
		return square != ' ' &&
				square == board.get(x+1).get(y) &&
				square == board.get(x+2).get(y) &&
				square == board.get(x+3).get(y);
	}
	
	private boolean sameGamePieceDiagonalWay1(int x, int y) {
		char square =board.get(x).get(y);
		return square != ' ' &&
				square == board.get(x + 1).get(y + 1) &&
				square == board.get(x + 2).get(y + 2) &&
				square == board.get(x + 3).get(y + 3);
	}
		    
	private boolean sameGamePieceDiagonalWay2(int x, int y) {
		char square = board.get(x).get(y + 3);
		return square != ' ' &&
				square == board.get(x + 1).get(y + 2) &&
				square == board.get(x + 2).get(y + 1) &&
				square == board.get(x + 3).get(y);
	}
		   
	boolean winDiagonally() {
	    return IntStream.range(0, width - 3)
	            .anyMatch(x -> IntStream.range(0, height - 3)
	                    .anyMatch(y -> sameGamePieceDiagonalWay1(x, y) || sameGamePieceDiagonalWay2(x, y)));
	}    
	
	boolean winVertically() {
	    return IntStream.range(0, width)
	            .anyMatch(x -> IntStream.range(0, height - 3)
	                    .anyMatch(y -> sameGamePieceVertically(x, y)));
	}
		    
	boolean winHorizontally() {
	    return IntStream.range(0, height)
	            .anyMatch(y -> IntStream.range(0, width - 3)
	                    .anyMatch(x -> sameGamePieceHorizontally(x, y)));
	}

	public String whosNext() {
		return gameState.whoPlaysNow();
	}
	
	public String show() {
	    StringBuilder display = new StringBuilder();
	
	   
	    for (int i = height - 1; i >= 0; i--) {
	        
	        for (int j = 0; j < width; j++) {
	            char square = board.get(j).get(i);  
	
	           
	            char displayChar;
	            if (square == 'r') {
	                displayChar = 'X';
	            } else if (square == 'b') {
	                displayChar = 'O';
	            } else {
	                displayChar = ' ';
	            }
	
	            
	            display.append(displayChar).append(" ");
	        }
	       
	        display.append("\n");
	    }
	
	 
	    for (int j = 1; j <= width; j++) {
	        display.append(j).append(" ");
	    }
	    display.append("\n");

	    if (endGame()) {
	        if (gameMode.win(this)) {
	            display.append(lastPlayed()).append(" Wins").append("!\n");
	        } else {
	            display.append("¡Es un empate!\n");
	        }
	    }
	
	    return display.toString();
	}

	public char getMode() {
		return gameMode.getMode();
	}




}