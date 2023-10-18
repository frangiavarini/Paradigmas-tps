package nemoproyect1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NemoTest {


	Submarine Nemo = new Submarine();
	@Test public void test00() {
	
	assertEquals(0, Nemo.coordinates.coordX);
	assertEquals(0, Nemo.coordinates.coordY);
	assertEquals(0, Nemo.coordinates.coordZ);
	}
	
	@Test public void test01NemoDoesNotmoveWNoDirec() {
		Commands emptyCommand = new Commands("");
		emptyCommand.doSomenthing(Nemo);
		assertEquals(0, Nemo.coordinates.coordX);
		assertEquals(0, Nemo.coordinates.coordY);
		assertEquals(0, Nemo.coordinates.coordZ);
	}
	
	@Test public void test02NemoSumerges() {
//		Nemo.move("d");
		Submarine Nemo = new Submarine();
		Commands command= new Commands("d");
		command.doSomenthing(Nemo);
		assertEquals(-1, Nemo.coordinates.coordZ);
	}
	
	@Test public void test03NemoAscends() {
		Commands command= new Commands("du");
		command.doSomenthing(Nemo);
		assertEquals(0, Nemo.coordinates.coordZ);
	}
	
	@Test public void test04NemoRotatesLeft() {
//		Nemo.spin("l");
		Commands command= new Commands("l");
		command.doSomenthing(Nemo);
		assertEquals("W", Nemo.cardinal.directedTo);
	}
	@Test public void test05NemoRotatesRight() {
		//Nemo.spin("r");
		Commands command= new Commands("r");
		command.doSomenthing(Nemo);
		assertEquals("E", Nemo.cardinal.directedTo);
	}
	@Test public void test06(){
		Coordinate coords = new Coordinate(1,1);
		Orientation cardinalPoint = new Orientation("E");
		
		Submarine Nemo2 = new Submarine(coords, cardinalPoint);
		
		assertEquals(1, Nemo2.coordinates.coordX);
		assertEquals(1, Nemo2.coordinates.coordY);
		assertEquals("E", Nemo2.cardinal.directedTo);
	
	}
	
	@Test public void test07() {
		Submarine Nemo = new Submarine();
//		Nemo.move("f");
		Commands command= new Commands("f");
		command.doSomenthing(Nemo);
		assertEquals(1, Nemo.coordinates.coordX);
	
	}

	
}


//@Test public void test00() {
//// esta en la superficie
//// en que posicion esta
//// para donde mira 
//
//Nemo nemo = new Nemo();
//funcion1(0,0,nemo);
//
//
//}
//
//@Test public void test01() {
//Nemo nemo = new Nemo();
//
//nemo.move("");
//funcion1(0,0,nemo);
//
//
//}
//
//@Test public void test02() {
//Nemo nemo = new Nemo();
//
//nemo.move("d");
//funcion1(-1,0,nemo);
//
//}
//
//@Test public void test03() {
//Nemo nemo = new Nemo();
//
//nemo.move("u");
//funcion1(1,0,nemo);
//assertEquals(1, nemo.getProf()); 
//assertEquals(0, nemo.getPosition()); 
//assertEquals("north", nemo.getCardinal());
//}
//
//// seguir con los tests de un caracter
//@Test public void test04() {
//
//
//Nemo nemo = new Nemo();
//nemo.move("f");
//assertEquals(0, nemo.getProf()); 
//assertEquals(1, nemo.getPosition()); 
//assertEquals("north", nemo.getCardinal());
//
//
//}
//
//@Test public void test05() {
//Nemo nemo = new Nemo();
//nemo.move("r");
//assertEquals(0, nemo.getProf()); 
//assertEquals(0, nemo.getPosition()); 
//assertEquals("east", nemo.getCardinal());
//
//}
//
//@Test public void test06() {
//Nemo nemo = new Nemo();
//nemo.move("l");
//assertEquals(0, nemo.getProf()); 
//assertEquals(0, nemo.getPosition()); 
//assertEquals("west", nemo.getCardinal());
//}
//
//public void funcion1(int n1, int n2, Nemo nemo) {
//assertEquals(n1, nemo.getProf()); 
//assertEquals(n2, nemo.getPosition()); 
//assertEquals("north", nemo.getCardinal());
//}
//
//}