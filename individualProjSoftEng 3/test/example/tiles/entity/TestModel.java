package example.tiles.entity;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestModel extends ModelTestCase { 

	@Test
	public void testInitialState( ) {
		
		assertTrue (model.getSelectedTile() == null);
		
		// no moves available.
		assertEquals (0, model.availableMoves().size());
	}
	
	@Test
	public void testPossibleMove() {
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		assertEquals (4, t.value);
		model.setSelectedTile(t);
		
		List<MoveType> available = model.availableMoves();
		assertEquals (4, available.size());
		assertTrue (available.contains(MoveType.Left));
		assertTrue (available.contains(MoveType.Right));
	}
	
	
	@Test
	public void testMove() {
		assertFalse (model.tryMove(MoveType.Left));  // nothing selected? No moves vailable.
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (new Coordinate(0, 1), t.getLocation());
	}
	
	
	@Test
	public void testBadMoves() {
		Tile t = this.getTile(new Coordinate(0,0)).get(); 
		model.setSelectedTile(t);
		assertEquals (2, model.availableMoves().size());
		
		t = this.getTile(new Coordinate(2,0)).get(); 
		model.setSelectedTile(t);
		assertEquals (2, model.availableMoves().size());
	}
	
	
	@Test
	public void testReset() {
		assertFalse (model.tryMove(MoveType.Left));  // nothing selected? No moves vailable.
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (new Coordinate(0, 1), t.getLocation());
		
		model.resetPuzzle();
		t = this.getTile(new Coordinate(1, 1)).get(); 
		assertTrue(t != null);
	}
	
	
}