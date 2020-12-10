package example.tiles.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMoveType {

	@Test
	public void testMove() {
		
		assertEquals (0, MoveType.Up.deltaC);
		assertEquals (-1, MoveType.Up.deltaR);
		
		assertEquals (0, MoveType.Down.deltaC);
		assertEquals (1, MoveType.Down.deltaR);
		
		assertEquals (-1, MoveType.Left.deltaC);
		assertEquals (0, MoveType.Left.deltaR);
		
		assertEquals (1, MoveType.Right.deltaC);
		assertEquals (0, MoveType.Right.deltaR);
		
	}

}
