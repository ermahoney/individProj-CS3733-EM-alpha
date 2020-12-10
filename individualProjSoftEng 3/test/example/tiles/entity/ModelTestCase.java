package example.tiles.entity;

import java.util.Optional;

import org.junit.Before;

public abstract class ModelTestCase { 

	protected Model model;
	
	/** Helper test method for location a piece by a coordinate. */
	protected Optional<Tile> getTile(Coordinate c) {
		for (Tile t : model.getPuzzle()) {
			if (t.contains(c)) {
				return Optional.of(t);
			}
		}
		
		return Optional.empty(); 
	}
	
	@Before
	public void setUp() {
		model  = new Model();
		
		Puzzle puzzle = new Puzzle(3, 3);
		puzzle.setMidXCol(1);
		puzzle.setMidYRow(1);
		
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
		
		model.setPuzzle(puzzle);
	}

}





