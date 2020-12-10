package example.tiles.entity;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Tile selectedTile;
	String result;

	/**
	 * 	(0,0) (1,0) (2,0)
	 * 	(0,1) (1,1) (2,1)
	 * 	(0,2) (1,2) (2,2)
	 */

	public Model() {
	}

	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) { return false; }

		for (MoveType move : availableMoves()) {
			if (dir == move) {
				selectedTile.move(dir);
				return true;
			}
		}
		return true;
	}

	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedTile == null) {
			return moves;
		}
		return availableMoves(selectedTile);
	}

	public List<MoveType> availableMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();

		Coordinate coordTile = t.getLocation();

		if (t.isWinner) {
			int midXCol = puzzle.getMidXCol();
			int midYRow = puzzle.getMidYRow();
			Coordinate midCoord = new Coordinate(midXCol, midYRow);
			if (coordTile.equals(midCoord)) {
				t.isWinner = true;
			}
		}

		Tile upTarget = puzzle.getTile(coordTile.colXPos, coordTile.rowYPos - 1);
		Tile downTarget = puzzle.getTile(coordTile.colXPos, coordTile.rowYPos + 1);
		Tile leftTarget = puzzle.getTile(coordTile.colXPos - 1, coordTile.rowYPos);
		Tile rightTarget = puzzle.getTile(coordTile.colXPos + 1, coordTile.rowYPos);

		boolean available = true;
		if (coordTile.colXPos -1 < 0 || leftTarget == null || coordTile == null) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Left);
		}
		available = true;
		if (coordTile.colXPos + 1 > 2 || rightTarget == null || coordTile == null) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Right);
		}
		available = true;
		if (coordTile.rowYPos - 1 < 0 || upTarget == null || coordTile == null) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Up);
		}
		available = true;
		if (coordTile.rowYPos + 1 > 2 || downTarget == null || coordTile == null) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Down);
		}

		return moves;
	}

	public void setPuzzle(Puzzle p) { 
		puzzle = p;
		gameOver = false;
		selectedTile = null;
	}
	public Puzzle getPuzzle() { return puzzle; }

	public void setSelectedTile(Tile t) { selectedTile = t; }
	public void clearSelectedTile() { selectedTile = null; }
	public Tile getSelectedTile() { return selectedTile; }

	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }

	public String getResult() { return result; }

	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		gameOver = false;
	}

	public boolean isWinCondition(MoveType dir) {
		if(selectedTile == null) { return false; }
		if(!selectedTile.isWinner) { return false; }
		return puzzle.isWinCondition(selectedTile.getColXPos(), selectedTile.getRowYPos());
	}
}