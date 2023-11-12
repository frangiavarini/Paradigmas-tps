package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class FourInLineTest {
	
    @Test 
    public void test01() {
    	Linea game = new Linea(6,6,'A');		
    	assertEquals('A',game.gameMode.getMode());
    }
    
    @Test
    public void test02BluePlaysAfterRed() {
		Linea game = new Linea(6,6, 'A');		
		game.playRedAt(0);
		assertEquals(game.whosNext(), "Blue");
    }
    
    @Test
    public void test03RedPlaysAfterBlue() {
		Linea game = new Linea(6,6,'A');		
		game.playRedAt(0);
		game.playBlueAt(0);
		assertEquals(game.whosNext(), "Red");
    }
    
    @Test
    public void test04BlueCantCheat() {
    	Linea game = new Linea(6,6,'A');		
		assertThrowsLike( () -> game.playBlueAt(0), "Not blue's turn");
    }
    
    @Test
    public void test05RedCantCheat() {
    	Linea game = new Linea(6,6,'A');		
		game.playRedAt(0);
		assertThrowsLike( () -> game.playRedAt(0), "Not red's turn");
    }
    
    @Test
    public void test06PlayRedAtWorksPropperly() {
    	Linea game = new Linea(6,6,'A');		
		game.playRedAt(0);
		assertEquals('r' , game.board.get(0).get(0));
    }
    
    @Test
    public void test06PlayBlueAtWorksPropperly() {
    	Linea game = new Linea(6,6,'A');		
		game.playRedAt(0);
		game.playBlueAt(0);
		assertEquals('b' , game.board.get(0).get(1));
    }
    
    @Test
    public void test07CantPlayBlueAtAFullColumn() {
    	Linea game = new Linea(4,4,'A');		
		game.playRedAt(0);
		game.playBlueAt(0);
		game.playRedAt(0);
		game.playBlueAt(0);
		assertThrowsLike(()-> game.playRedAt(0), "This column is full");
    }
    
    @Test
    public void test08CantPlayBlueAtAFullColumn() {
    	Linea game = new Linea(4,4,'A');		
		game.playRedAt(0);
		game.playBlueAt(0);
		game.playRedAt(0);
		game.playBlueAt(0);
		game.playRedAt(1);
		assertThrowsLike(()-> game.playBlueAt(0), "This column is full");
    }
    
    @Test
    public void test09CantPlayRedAtAnInexistentColumn() {
    	Linea game = new Linea(4,4,'A');	
		assertThrowsLike(()-> game.playRedAt(4), "Inexistent column");
    }
    
    @Test
    public void test10CantPlayBlueAtAnInexistentColumn() {
    	Linea game = new Linea(4,4,'A');	
		game.playRedAt(0);
		assertThrowsLike(()-> game.playBlueAt(4), "Inexistent column");
    }
    
    @Test 
    public void test11ModeCworksWithHorizontalWin() {
    	Linea game = new Linea(4,4,'C');	
		game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        gameFinished(game);
    }
    
    
    @Test 
    public void test12ModeCworksWithVerticalWin() {
    	Linea game = new Linea(4,4,'C');	
		game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        gameFinished(game);
    }
    
    @Test
    public void test13ModeCworksWithDiagonalWin() {
    	Linea game = new Linea(4,4,'C');	
    	game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(0);
        game.playBlueAt(3);
        game.playRedAt(3);
        gameFinished(game);
    }
    
    @Test
    public void testHorizontalWin(){
    	Linea game = new Linea(4, 4, 'C');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        gameFinished(game);
    }  
    
    @Test 
    public void testVerticalWin() {
    	Linea game = new Linea(4, 4, 'A');
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);

       
        gameFinished(game);
    }
    
    
    @Test 
    public void testGoingUpDiagonalWin() {
    	Linea game = new Linea(4, 4, 'B');
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(0);
        game.playBlueAt(3);
        game.playRedAt(3);
       
        gameFinished(game);
    }
    
    @Test 
    public void testGoingDownDiagonalWin() {
        Linea game = new Linea(4, 4, 'B');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
       
        gameFinished(game);
    }
    
    private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, assertThrows(Error.class, executable).getMessage());
	}
    
    private void gameFinished(Linea game) {
		assertTrue(game.endGame());
	}

}
