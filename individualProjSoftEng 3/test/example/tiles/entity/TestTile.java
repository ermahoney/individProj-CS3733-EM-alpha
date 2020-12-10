package example.tiles.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTile {

	@Test
	void testConstruction() {
		Tile tile = new Tile(1, 2, 3);
		assertEquals (1, tile.value);
		assertEquals (2, tile.rowYPos);
		assertEquals (3, tile.colXPos);
		assertFalse (tile.isWinner());
	}
	
	@Test
	void testConstructionAlt() {
		Tile tile = new Tile(7);
		assertEquals (7, tile.value);
	}
	
	@Test
	void testContains() {
		Tile t = new Tile (7, 0, 0);
		t.getValue();
		t.setRowYPos(0);
		t.setColXPos(0);
		
		/**
		 * (0,0)
		 * (0,1)
		 */
		assertTrue(t.contains(new Coordinate (0,0)));
		assertFalse(t.contains(new Coordinate (1,1)));
		
		
	}
	
	@Test
	void testWinner() {
		Tile tile = new Tile(1, 2, 3);
		tile.setWinner(true);
		assertTrue (tile.isWinner());
	}
	
	@Test
	void testCopy() {
		Tile tile = new Tile(1, 2, 3);
		Tile t2 = tile.copy();
		assertEquals (t2.rowYPos, tile.rowYPos);
		assertEquals (t2.colXPos, tile.colXPos);
		assertEquals (t2.value, tile.value);
		assertEquals (t2.isWinner, tile.isWinner);
	}
	
	@Test
	void testPlacement() {
		Tile tile = new Tile(1, 2, 3);
		tile.setRowYPos(4);
		assertEquals (4, tile.getRowYPos());
		tile.setColXPos(5);
		assertEquals (5, tile.getColXPos());
	}
	
	@Test
	void testMove() {
		Tile tile = new Tile(1, 2, 3);
		tile.setColXPos(2);
		tile.setRowYPos(1);
		tile.move(MoveType.Left);
		
		assertEquals(1, tile.getColXPos());
		assertEquals(new Coordinate(1, 1), tile.getLocation());
	}

}
