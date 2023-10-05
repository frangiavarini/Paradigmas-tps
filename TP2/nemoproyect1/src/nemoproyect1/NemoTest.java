package nemoproyect1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NemoTest {

	@Test public void test00() {
		// esta en la superficie
		// en que posicion esta
		// para donde mira 
		
		Nemo nemo = new Nemo();
		assertEquals(0, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("north", nemo.getCardinal());
		
	}
	
	@Test public void test01() {
		Nemo nemo = new Nemo();
	
		nemo.move("");
		assertEquals(0, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("north", nemo.getCardinal());
		
	}
	
	@Test public void test02() {
		Nemo nemo = new Nemo();
		
		nemo.move("d");
		assertEquals(-1, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("north", nemo.getCardinal());
	}
	
	@Test public void test03() {
		Nemo nemo = new Nemo();
		
		nemo.move("u");
		assertEquals(1, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("north", nemo.getCardinal());
	}
	
	// seguir con los tests de un caracter
	@Test public void test04() {
	
		
		Nemo nemo = new Nemo();
		nemo.move("f");
		assertEquals(0, nemo.getProf()); 
		assertEquals(1, nemo.getPosition()); 
		assertEquals("north", nemo.getCardinal());
		
		
	}
	
	@Test public void test05() {
		Nemo nemo = new Nemo();
		nemo.move("r");
		assertEquals(0, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("east", nemo.getCardinal());
		
	}
	
	@Test public void test06() {
		Nemo nemo = new Nemo();
		nemo.move("l");
		assertEquals(0, nemo.getProf()); 
		assertEquals(0, nemo.getPosition()); 
		assertEquals("west", nemo.getCardinal());
	}
	
}
