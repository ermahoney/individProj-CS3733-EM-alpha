package example.tiles.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.tiles.entity.Coordinate;
import example.tiles.entity.Tile;

public class TestSelectTileController extends AppTestCase {
	
	@Test
	public void testSelect() {
		SelectTileController spc = new SelectTileController (model, app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		assertEquals (new Coordinate(1,1), app.getPuzzlePanel().pointToCoordinate(pt));
		
		spc.process(pt);
		
		Tile t = getTile(new Coordinate(1, 1)).get(); 
		assertEquals (t, model.getSelectedTile());
		
		// this piece can only move left and right. ensure buttons are enabled/disabled
		assertTrue (app.getLeftButton().isEnabled());
		assertTrue (app.getRightButton().isEnabled());
		assertTrue (app.getUpButton().isEnabled());
		assertTrue (app.getDownButton().isEnabled());
	}
}