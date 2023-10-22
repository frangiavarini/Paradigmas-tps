package nemoproyect1;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NemoTest {

	
	@Test public void test00DefaultNemoStartsAt00() {
	Submarine nemo = nemo();
	assertEquals(0, nemo.coordinates.coordX);
	assertEquals(0, nemo.coordinates.coordY);
	}
	
	@Test public void test01NemoIsntSumergedWhenCreated() {
	Submarine nemo = nemo();
	assertEquals(0, nemo.depths.get(nemo.depths.size()-1).getDepth());
	}
	
	@Test public void test02NemoDoesNotMoveWNoCommand() {
		Submarine nemo = nemo();
		nemo.executeCommands("");
		assertEquals(0, nemo.coordinates.coordX);
		assertEquals(0, nemo.coordinates.coordY);
		
	}
	
	@Test public void test03NemoDoesNotSpinWNoCommand() {
		Submarine nemo = nemo();
		nemo.executeCommands("");
		assertEquals("North",nemo.cardinal.getDirection());
	}
	
	@Test public void test04NemoSumerges() {
		Submarine nemo = nemo();
		nemo.executeCommands("d");
		assertEquals(-1, nemo.depths.get(nemo.depths.size()-1).getDepth());
	}
	
	@Test public void test05NemoAscends() {
		Submarine nemo = nemo();
		nemo.executeCommands("du");
		assertEquals(0, nemo.depths.get(nemo.depths.size()-1).getDepth());
	}
	
	@Test public void test06NemoWontFly() {
		Submarine nemo = nemo();
		nemo.executeCommands("uuu");
		assertEquals(0, nemo.depths.get(nemo.depths.size()-1).getDepth());
	}
	
	@Test public void test07NemoRotatesLeft() {
		Submarine nemo = nemo();
		nemo.executeCommands("l");
		assertEquals("West", nemo.cardinal.getDirection());
	}


	@Test public void test08NemoRotatesRight() {
		Submarine nemo = nemo();
		nemo.executeCommands("r");
		assertEquals("East", nemo.cardinal.getDirection());
	}
	
	@Test public void test09NemoCanBeLocatedWillingly(){
		Submarine dory = dory();
		
		assertEquals(1, dory.coordinates.coordX);
		assertEquals(1, dory.coordinates.coordY);
	}
 
	@Test public void test10NemoCanBeOrientatedWillingly(){
		Submarine dory = dory();
		
		assertEquals("East", dory.cardinal.getDirection());
	}
	
	@Test public void test11NemoSwimsTowardsNorthpropperly() {
		Submarine nemo = nemo();
		nemo.executeCommands("f");
		assertEquals(1, nemo.coordinates.coordY);
	}
	
	@Test public void test12NemoSwimsTowardsEastpropperly() {
		Submarine nemo = nemo();
		nemo.executeCommands("rf");
		assertEquals(1, nemo.coordinates.coordX);
	}
	
	@Test public void test13NemoSwimsTowardsSouthpropperly() {
		
		Submarine nemo = nemo();
		nemo.executeCommands("llf");
		assertEquals(-1, nemo.coordinates.coordY);
	}
	
	@Test public void test14NemoSwimsTowardsWestpropperly() {
		Submarine nemo = nemo();
		nemo.executeCommands("lf"); //lf
		assertEquals(-1, nemo.coordinates.coordX);
	}


	@Test public void test15NemoChangesDirectionToSwimIfToldSo() {

		Submarine nemo = nemo();
		nemo.executeCommands("frf");
		assertEquals(1, nemo.coordinates.coordY);
		assertEquals(1, nemo.coordinates.coordX);
	}
	
	@Test public void test16NemoThrowsBrownieAtSurface() {
		Submarine nemo = nemo();
		nemo.executeCommands("m");
		assertTrue(nemo.wasBrownieThrown);
	}
	
	@Test public void test17NemoThrowsBrownieAtFirstLevel() {
		Submarine nemo = nemo();
		nemo.executeCommands("dm");
		assertTrue(nemo.wasBrownieThrown);
	}
	
	@Test public void test18NemoCantThrowBrownifBelowFirstLevel() {
		Submarine nemo = nemo();
		try {
	      nemo.executeCommands("ddm");
	    } catch ( Exception e ) {
	      assertEquals( "Boom!", e.getMessage() );
	    }
	
	}
	
	private Submarine nemo() {
		return new Submarine();
	}
	
	private Submarine dory() {
		Coordinate coords = new Coordinate(1,1);
		Orientation cardinalPoint = new EastOrientation();
		
		Submarine dory = new Submarine(coords, cardinalPoint);
		return dory;
	}
	
	
	
}