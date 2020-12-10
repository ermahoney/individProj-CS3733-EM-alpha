package example.tiles.controller;

import java.awt.Point;
import java.util.List;

import example.tiles.boundary.TilePuzzleApp;

import example.tiles.entity.Coordinate;
import example.tiles.entity.Model;
import example.tiles.entity.MoveType;
import example.tiles.entity.Puzzle;
import example.tiles.entity.Tile;

public class SelectTileController {

	Model model;
	TilePuzzleApp app;
	
	public SelectTileController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();
		
		for (Tile t : puzzle) {
			if (t.contains(c)) {
				model.clearSelectedTile();
				model.setSelectedTile(t);
				
				List<MoveType> moves = model.availableMoves(t);
				app.repaint();
			}
		}
	}
}
