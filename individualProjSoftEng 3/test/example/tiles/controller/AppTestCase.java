package example.tiles.controller;

import java.awt.Point;

import org.junit.*;

import example.tiles.boundary.PuzzlePanel;
import example.tiles.boundary.TilePuzzleApp;
import example.tiles.entity.Coordinate;
import example.tiles.entity.ModelTestCase;

public abstract class AppTestCase extends ModelTestCase {
	
	protected TilePuzzleApp app;
	
	@Before
	public void createApp() {
		app = new TilePuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.colXPos * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2, c.rowYPos * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2);
	}

}