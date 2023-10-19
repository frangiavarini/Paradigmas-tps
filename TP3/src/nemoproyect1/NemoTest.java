package nemoproyect1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NemoTest {

	
	@Test public void test00() {
	Submarine nemo = new Submarine();
	assertEquals(0, nemo.coordinates.coordX);
	assertEquals(0, nemo.coordinates.coordY);
	assertEquals(0, nemo.coordinates.coordZ);
	}
	
	@Test public void test01NemoDoesNotmoveWNoDirec() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("");
		assertEquals(0, nemo.coordinates.coordX);
		assertEquals(0, nemo.coordinates.coordY);
		assertEquals(0, nemo.coordinates.coordZ);
		assertEquals("north",nemo.cardinal.getDirection());
	}
	
	@Test public void test02NemoSumerges() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("d");
		assertEquals(-1, nemo.coordinates.coordZ); // aca el coord z 
													//deberia ser de la clase profundidad
	}
	
	@Test public void test03NemoAscends() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("du");
		assertEquals(0, nemo.coordinates.coordZ);
	}
	
	@Test public void test04NemoRotatesLeft() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("l");
		assertEquals("west", nemo.cardinal.getDirection());
	}
	@Test public void test05NemoRotatesRight() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("r");
		assertEquals("east", nemo.cardinal.getDirection());
	}
	@Test public void test06(){
		Coordinate coords = new Coordinate(1,1);
		Orientation cardinalPoint = new EastOrientation();
		
		Submarine nemo = new Submarine(coords, cardinalPoint);
		
		assertEquals(1, nemo.coordinates.coordX);
		assertEquals(1, nemo.coordinates.coordY);
		assertEquals("east", nemo.cardinal.getDirection());
	
	}
	
	@Test public void test07() {
		Submarine nemo = new Submarine();
		nemo.ejecutarComandos("f");
		assertEquals(1, nemo.coordinates.coordY);
	
	}

	
}

//public void funcion1(int n1, int n2, Nemo nemo) {
//assertEquals(n1, nemo.getProf()); 
//assertEquals(n2, nemo.getPosition()); 
//assertEquals("north", nemo.getCardinal());
