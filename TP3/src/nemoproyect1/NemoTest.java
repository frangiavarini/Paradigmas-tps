package nemoproyect1;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		nemo.executeCommands("");
		assertEquals(0, nemo.coordinates.coordX);
		assertEquals(0, nemo.coordinates.coordY);
		assertEquals("North",nemo.cardinal.getDirection());
	}
	
	@Test public void test02NemoSumerges() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("d");
		assertEquals(-1, nemo.depths.get(nemo.depths.size()-1).getDepth());
	}
	
	@Test public void test03NemoAscends() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("du");
		assertEquals(0, nemo.coordinates.coordZ);
	}
	
	@Test public void test04NemoRotatesLeft() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("l");
		assertEquals("West", nemo.cardinal.getDirection());
	}
	@Test public void test05NemoRotatesRight() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("r");
		assertEquals("East", nemo.cardinal.getDirection());
	}
	@Test public void test06NemoCanBeLocatedWillingly(){
		Coordinate coords = new Coordinate(1,1);
		Orientation cardinalPoint = new EastOrientation();
		
		Submarine nemo = new Submarine(coords, cardinalPoint);
		
		assertEquals(1, nemo.coordinates.coordX);
		assertEquals(1, nemo.coordinates.coordY);
		assertEquals("East", nemo.cardinal.getDirection());
	
	}
	
	@Test public void test07NemoSwims() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("f");
		assertEquals(1, nemo.coordinates.coordY);
	
	}

	@Test public void test08NemoSwimsDirectedTo() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("frf");
		assertEquals(1, nemo.coordinates.coordY);
		assertEquals(1, nemo.coordinates.coordX);
	}
	
	@Test public void test09NemoThrowsBrownieAtSurface() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("m");
		assertTrue(nemo.wasBrownieThrown);
	}
	
	@Test public void test10NemoThrowsBrownieAtFirstLevel() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("dm");
		assertTrue(nemo.wasBrownieThrown);
	}
	
	@Test public void test11NemoDoesntThrowBrownieBelowFirstLevel() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("ddm");
		assertFalse(nemo.wasBrownieThrown);
	}
	
	@Test public void test12NemoHanddlesManyCommands() {
		Submarine nemo = new Submarine();
		nemo.executeCommands("dumldr");
		assertTrue(nemo.wasBrownieThrown);
		assertEquals(-1,nemo.depths.get(nemo.depths.size()-1).getDepth());
		assertEquals("North",nemo.cardinal.getDirection());
	}
	
	
}

