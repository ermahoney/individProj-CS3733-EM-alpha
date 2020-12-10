package example.tiles.controller;


import example.tiles.boundary.TilePuzzleApp;
import example.tiles.entity.Model;


public class ResetController {

	Model model;
	TilePuzzleApp app;
	
	public ResetController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void reset() {
		model.resetPuzzle();
		app.getActualResult().setText("" + model.getResult());
		app.repaint();
	}
}
