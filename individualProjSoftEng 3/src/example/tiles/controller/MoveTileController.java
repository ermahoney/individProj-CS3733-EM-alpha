package example.tiles.controller;

import example.tiles.boundary.TilePuzzleApp;
import example.tiles.entity.Model;
import example.tiles.entity.MoveType;

public class MoveTileController {

	Model model;
	TilePuzzleApp app;
	
	public MoveTileController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(MoveType dir) {
		if (model.getSelectedTile() == null) { return false; }
		
		if (model.isGameOver()) { return false; }
		
		if(model.isWinCondition(dir)) {
			model.setGameOver(true);
			app.getActualResult().setText("Congrats you have won" + model.getResult());
			app.repaint();
			return true;
		}
		
		if (model.tryMove(dir)) {
			
			if(model.isGameOver() == false) {
				app.getActualResult().setText("" + model.getResult());
			}
			app.repaint();
		}
		return true;
	}
}
