package example.tiles;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.tiles.boundary.TilePuzzleApp;
import example.tiles.controller.ExitController;
import example.tiles.entity.Model;
import example.tiles.entity.Puzzle;
import example.tiles.entity.Tile;

public class Main {
	
	public static void main(String[] args) {
		Model m = new Model();
		
		Puzzle puzzle = new Puzzle(3, 3);
		puzzle.setMidXCol(1);
		puzzle.setMidYRow(1);
		//this is my middle tile
		Tile t = new Tile(4, 1, 1);
		t.setWinner(true);
		puzzle.add(t, 1, 1);
		
		puzzle.add(new Tile(7, 1, 1), 0, 0);
		puzzle.add(new Tile(2, 1, 1), 1, 0);
		puzzle.add(new Tile(8, 1, 1), 2, 0);
		puzzle.add(new Tile(1, 1, 1), 0, 1);
		
		
		
		puzzle.add(new Tile(9, 1, 1), 2, 1);
		puzzle.add(new Tile(6, 1, 1), 0, 2);
		puzzle.add(new Tile(3, 1, 1), 1, 2);
		puzzle.add(new Tile(5, 1, 1), 2, 2);
		m.setPuzzle(puzzle);
		
		TilePuzzleApp app = new TilePuzzleApp(m);
		app.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		
		app.setVisible(true);
	}

}
