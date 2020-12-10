package example.tiles.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import example.tiles.entity.Coordinate;
import example.tiles.entity.MoveType;
import example.tiles.entity.Tile;

public class TestResetController extends AppTestCase {
	
	@Test
	public void testReset() {
		Tile t = this.getTile(new Coordinate(1,1)).get(); // piece in middle of panel
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertTrue (getTile(new Coordinate(0,1)).isPresent());  // moved
		
		ResetController rpc = new ResetController(model, app);
		rpc.reset();
		

		assertTrue (getTile(new Coordinate(1,1)).isPresent());  // no longer there
	}
}