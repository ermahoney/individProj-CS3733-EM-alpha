package example.tiles.controller;
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.tiles.entity.Coordinate;
import example.tiles.entity.MoveType;

public class TestMoveTileController extends AppTestCase {
	
	@Test
	public void testMove() {
		SelectTileController spc = new SelectTileController (model, app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		assertEquals (new Coordinate(1,1), app.getPuzzlePanel().pointToCoordinate(pt));
		
		spc.process(pt);
		
		// now request move via MovePieceController
		MoveTileController mpc = new MoveTileController(model, app);
		assertTrue (mpc.move(MoveType.Left));

		// validate piece in that location
		//assertEquals (model.getSelectedTile(), this.getTile(new Coordinate(0,1)).get());
	}
}