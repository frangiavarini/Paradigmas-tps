	package linea;
	import java.util.List;
	import java.util.ArrayList;
	
	public class Linea {
	public  List<List<Character>> board;
	private int height;
	private int width;
	public GameMode gameMode;
	public boolean redTurn;
	public GameState gameState;
	
		    
	public Linea (int columns, int rows, char gameMode) {
		if (rows < 4 || columns < 4) throw new RuntimeException("Not posible board available");
			height = rows;
			width = columns;
			this.gameMode = GameMode.setGameMode(gameMode);
			redTurn = true;
			gameState = new RedTurn();
			board = new ArrayList<>(columns);
			for (int i = 0; i < columns; i++) {
				List<Character> column = new ArrayList<>(rows);
			    for (int j = 0; j < rows; j++) {
			    	column.add(' ');
			    }
			    this.board.add(column);  
			}  
	}  
	
	public boolean endGame() {
		return gameMode.win(this) || notEmptySpaces();
	}
	
	public String lastPlayed() {
		return gameState.lastPlayed();
	}
	public boolean notEmptySpaces() {
		for (List<Character> row : board) {
			for (char square : row) {
				if (square == ' ') {   
					return false; 
		        }
		    }
		}
		return true; 
	}
		        
	public int isSquareEmpty(int column) {
		int row = -1;
		for (int i = 0; i < height; i++) {
			if (board.get(column).get(i) == ' ') {
				return i;
		    }
		}
		if (row == -1) {
			throw new Error ("This column is full");
		}   
		return row;
	}
		    
	public void playRedAt(int column) {
		if(!endGame()) {
			if(column < width) {
				gameState=gameState.playRed(column, this);
		       
		    } else {
		    	throw new Error("Inexistent column");
		    }
		}
		else{
			gameState=new GameOver();
		}
	}
		    
	
	
	public void playBlueAt(int column) {
		if(!endGame()) {
			if (column < width) {
				gameState = gameState.playBlue(column, this);
				
			} else {
				throw new Error("Inexistent column");
			}
		} else {
			gameState=new GameOver();
		}
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
		for (int x = 0; x < width - 3; x++) {  
			for (int y = 0; y < height - 3; y++) {
				if (sameGamePieceDiagonalWay1(x, y) || sameGamePieceDiagonalWay2(x, y)) {
					return true;
				}
			}
		}
		return false;
	}
		    
	boolean winVertically() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height - 3 ; y++) {   
				if (sameGamePieceVertically(x, y)) {
					return true;
				}
			}
		}
		return false;
	}
		    
	boolean winHorizontally() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width - 3; x++) {  
				if (sameGamePieceHorizontally(x, y)) {
					return true;
				}
			}
		}
		return false;
	}

	public String whosNext() {
		return gameState.whoPlaysNow();
	}
	
	public String show() {
	    StringBuilder display = new StringBuilder();
	
	    // Iterate over each row in reverse order to display the board from bottom to top
	    for (int i = height - 1; i >= 0; i--) {
	        // Iterate over each column
	        for (int j = 0; j < width; j++) {
	            char square = board.get(j).get(i);  // Get the character at position (j, i)
	
	            // Determine the display character based on the content of the square
	            char displayChar;
	            if (square == 'r') {
	                displayChar = 'X';
	            } else if (square == 'b') {
	                displayChar = 'O';
	            } else {
	                displayChar = ' ';
	            }
	
	            // Append the character to the StringBuilder
	            display.append(displayChar).append(" ");
	        }
	        // Move to the next line after appending each row
	        display.append("\n");
	    }
	
	    // Append column numbers at the bottom
	    for (int j = 0; j < width; j++) {
	        display.append(j).append(" ");
	    }
	    display.append("\n");
	
	    // Check if the game has ended and display the result
	    if (endGame()) {
	        if (gameMode.win(this)) {
	            display.append(lastPlayed()).append(" Wins").append("!\n");
	        } else {
	            display.append("¡Es un empate!\n");
	        }
	    }
	
	    return display.toString();
	}



}
