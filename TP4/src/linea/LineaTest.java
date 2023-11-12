package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LineaTest {
	

    @Test 
    public void test01settingModeWorks() {
    	assertEquals(gameA6x6().getMode(), 'A');
    }
    @Test
    public void test02CantSetAnInvalidMode() {
    	assertThrowsLike( () -> new Linea(4,4,'D'), "The requested mode does not exist");
    }
    @Test 
    public void test03CantSetABoardSmallerThan4columns() {
    	assertThrowsLike( () -> new Linea(3,4,'A'), "Not a possible board");
    }
    @Test 
    public void test04CantSetABoardSmallerThan4rows() {
    	assertThrowsLike( () -> new Linea(4,3,'A'), "Not a possible board");
    }
    @Test
    public void test05BluePlaysAfterRed() {
		assertEquals( gameA6x6().playRedAt(1).whosNext(), "Blue");		
    }
    
    @Test
    public void test06RedPlaysAfterBlue() {
    	assertEquals( gameA6x6().playRedAt(1).playBlueAt(1).whosNext(), "Red");	
    }
    
    @Test
    public void test07BlueCantCheat() {	
		assertThrowsLike( () -> gameA6x6().playBlueAt(1), "Not blue's turn");
    }
    
    @Test
    public void test08RedCantCheat() {
		assertThrowsLike( () -> gameA6x6().playRedAt(1).playRedAt(1), "Not red's turn");
    }
    
    @Test
    public void test09PlayRedAtWorksPropperly() {
		assertEquals('r' , gameA6x6().playRedAt(1).board.get(0).get(0));
    }
    
    @Test
    public void test10PlayBlueAtWorksPropperly() {
		assertEquals('b' , gameA6x6().playRedAt(1).playBlueAt(1).board.get(0).get(1));
    }
    
    @Test
    public void test11CantPlayRedAtAFullColumn() {
		assertThrowsLike(()-> gameA4x4().playRedAt(1).playBlueAt(1).playRedAt(1).playBlueAt(1).playRedAt(1), "This column is full");
    }
	
    
    @Test
    public void test12CantPlayBlueAtAFullColumn() {
		assertThrowsLike(()-> gameA4x4().playRedAt(1).playBlueAt(1).playRedAt(1).playBlueAt(1).playRedAt(2).playBlueAt(1), "This column is full");
    }
    
    @Test
    public void test13CantPlayRedAtAnInexistentColumn() {
    	assertThrowsLike(()-> gameA4x4().playRedAt(5), "Inexistent column");
    }
    
    @Test
    public void test14CantPlayBlueAtAnInexistentColumn() {
		assertThrowsLike(()-> gameA4x4().playRedAt(1).playBlueAt(5), "Inexistent column");
    }
    
    @Test 
    public void test15ModeCworksWithHorizontalWin() {
    	assertTrue(gameC4x4().playRedAt(1).playBlueAt(1).playRedAt(2).playBlueAt(2).playRedAt(3).playBlueAt(3).playRedAt(4).endGame());
    }
	
    
    @Test 
    public void test16ModeCworksWithVerticalWin() {
    	assertTrue(gameC4x4().playRedAt(1).playBlueAt(2).playRedAt(1).playBlueAt(2).playRedAt(1).playBlueAt(2).playRedAt(1).endGame());
    }
    
    @Test
    public void test17ModeCworksWithDiagonalWin() {
    	assertTrue(gameC4x4().playRedAt(1).playBlueAt(2).playRedAt(2).playBlueAt(3).playRedAt(4).playBlueAt(3).playRedAt(3).playBlueAt(4).playRedAt(1).playBlueAt(4).playRedAt(4).endGame());
    }
    
    @Test
    public void test18HorizontalWin(){
    	assertTrue(gameC4x4().playRedAt(1).playBlueAt(1).playRedAt(2).playBlueAt(2).playRedAt(3).playBlueAt(3).playRedAt(4).endGame());
    }  
    
    @Test 
    public void test19VerticalWin() {
    	assertTrue(gameA4x4().playRedAt(1).playBlueAt(2).playRedAt(1).playBlueAt(2).playRedAt(1).playBlueAt(2).playRedAt(1).endGame());
    }
    
    
    @Test 
    public void test20GoingUpDiagonalWin() {
    	assertTrue(gameB4x4().playRedAt(1).playBlueAt(2).playRedAt(2).playBlueAt(3).playRedAt(4).playBlueAt(3).playRedAt(3).playBlueAt(4).playRedAt(1).playBlueAt(4).playRedAt(4).endGame());
    }
	
    
    @Test 
    public void test21GoingDownDiagonalWin() {
        assertTrue(gameB4x4().playRedAt(1).playBlueAt(1).playRedAt(1).playBlueAt(1).playRedAt(2).playBlueAt(3).playRedAt(2).playBlueAt(2).playRedAt(2).playBlueAt(3).playRedAt(3).playBlueAt(4).endGame());
    }
    
    @Test 
    public void test22ShowWorksPropperlyWhenNobodyPlayed() {
    	assertEquals("        \n" + "        \n" + "        \n"+"        \n" + "1 2 3 4 \n", gameA4x4().show());
    }
    
    @Test
    public void test23ShowWorksPropperlyWhenRedPlayed() {
    	assertEquals("        \n" + "        \n" + "        \n"+"X       \n" + "1 2 3 4 \n", gameA4x4().playRedAt(1).show());
    }
    
    @Test
    public void test24ShowWorksPropperlyWhenBluePlayed() {
    	assertEquals("        \n" + "        \n" + "O       \n"+"X       \n" + "1 2 3 4 \n", gameA4x4().playRedAt(1).playBlueAt(1).show());
    }
    
    private void assertThrowsLike(Executable executable, String message) {
    	assertEquals(message, assertThrows(Error.class, executable).getMessage());
    }
    
    private Linea gameA6x6() {return new Linea(6,6,'A');}
    private Linea gameA4x4() {return new Linea(4,4,'A');}
    private Linea gameB4x4() {return new Linea(4,4,'B');}
    private Linea gameC4x4() {return new Linea(4,4,'C');}
}