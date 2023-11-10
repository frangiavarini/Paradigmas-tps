package fourInLine;

import static org.junit.Assert.assertFalse;
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
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);

       
        assertTrue(game.endGame());
        //  red won missing!!
        // show missing!!
        
    }  
    
    //Test other modes 
    
    


}
