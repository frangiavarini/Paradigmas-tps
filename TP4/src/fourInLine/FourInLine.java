package fourInLine;
import java.util.List;
import java.util.ArrayList;

public class FourInLine {
		
		public  List<List<Character>> board;
	    private int height;
	    private int width;
	    public GameMode gameMode;
	    public boolean redTurn;
	    public Turn turn;
	    
	    
	    public FourInLine(int rows, int columns, GameMode gamemode) {
	        if (rows < 4 || columns < 4) throw new RuntimeException("Not posible board available");
		       height = rows;
		       width = columns;
		       gameMode= gamemode;
		       redTurn = true;
		       turn = new RedTurn();
		       board = new ArrayList<>(columns);
		      
		      for (int i = 0; i < columns; i++) {
		    	    List<Character> column = new ArrayList<>(rows);
		    	    for (int j = 0; j < rows; j++) {
		    	        column.add(' ');
		    	    }
		    	    this.board.add(column);   //streams??
		       }
	  		} 
	    
	   
	    
	  // add show
	    

	    public boolean endGame() {
	        return gameMode.win(this) || notEmptySpaces();
	    }
	    
	    
	    public boolean notEmptySpaces() {
	        for (List<Character> row : board) {
	            for (char square : row) {
	                if (square == ' ') {   //streams??
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
	                row = i;
	            }
	        }
	        
	        if (row == -1) {
	            throw new RuntimeException("This column is full");
	        }
	        
	        return row;
	    }

	    
	    public void playBlueAt(int column) {
	    	 if(!endGame()) {
	    		 turn.playBlue(column,this);
	    		 turn = new RedTurn();
	    	 }
	    	 
	    	 else {
	    		 throw new RuntimeException("END GAME");
	    	 }
	    	 
	    }
	   
	    
	    public void playRedAt(int column) {
	    	 if(!endGame()) {
	    		 turn.playRed(column,this);
	    		 turn = new BlueTurn();
	    	 }
	    	 
	    	 else {
	    		 throw new RuntimeException("END GAME");
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
		     for (int x = 0; x < height - 3; x++) {  //streams?
		         for (int y = 0; y < width- 3; y++) {
		             if (sameGamePieceDiagonalWay1(x, y) || sameGamePieceDiagonalWay2(x, y)) {
		                 return true;
		            	}
		        	}
		    	}
		    	return false;
			}

	    
	    boolean winVertically() {
		    for (int x = 0; x < width; x++) {
		        for (int y = 0; y < height - 3; y++) {   //streams??
		            if (sameGamePieceVertically(x, y)) {
		                return true;
		            	}
		        	}
		    	}
		    	return false;
			}
	    
	    boolean winHorizontally() {   
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width - 3; x++ ) {  //streams??
	                if (sameGamePieceHorizontally(x, y)) {
	                    return true;
	                	}
	            	}
	        	}
	        	return false;
	    	}
	    
	   
// red won missing?
	    
// blue won missing?

   
	    
}
