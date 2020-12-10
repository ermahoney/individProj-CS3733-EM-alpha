package example.tiles.controller;

import javax.swing.JOptionPane;
import example.tiles.boundary.TilePuzzleApp;


public class ExitController {

	TilePuzzleApp app;
	
	public ExitController(TilePuzzleApp app) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app,  "Do you wish to exit?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
