package example.tiles.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPuzzle {

	@Test
	public void testConst() {
		Puzzle p = new Puzzle(3, 3);
		assertEquals (3, p.numXCols);
		assertEquals (3, p.numYRows);
	}
	
	@Test
	public void testMethods() {
		Puzzle p = new Puzzle(3, 3);
		assertEquals (3, p.numXCols);
		assertEquals (3, p.numYRows);
		p.setMidXCol(1);
		p.setMidYRow(1);
		
		assertEquals (1, p.getMidXCol());
		assertEquals (1, p.getMidYRow());
	}
}
