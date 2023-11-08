package fourInLine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class FourInLineTest {
	
	// Test for invalid board dimensions?
	// Test for full column movements?
	// Test for show?
	
    @Test public void test01() {
    		GameMode gamemode = new ModeA();
    		FourInLine game = new FourInLine(6,6,gamemode);		
    		assertEquals("A",game.gameMode.getMode());

    	
    }
    
    
    @Test public void test02(){
    	GameMode gamemode = new ModeA();
        FourInLine game = new FourInLine(4, 4, gamemode);
        game.playAt(0, new RedTurn());
        game.playAt(0, new BlueTurn());
        game.playAt(1, new RedTurn());
        game.playAt(1, new BlueTurn());
        game.playAt(2, new RedTurn());
        game.playAt(2, new BlueTurn());
        game.playAt(3, new RedTurn());

       
        assertTrue(game.endGame());
        //  red won missing!!
        // show missing!!
        
    }  
    
    //Test other modes 
    
    


}
