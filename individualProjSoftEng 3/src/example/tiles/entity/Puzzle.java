package example.tiles.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile> {

	ArrayList<Tile> tiles = new ArrayList<>();
	
	ArrayList<Tile> originals = new ArrayList<>();
	
	public final int numYRows;
	public final int numXCols;
	int midYRow;
	int midXCol;
	
	public Puzzle(int numXCols, int numYRows) {
		this.numXCols = numXCols;
		this.numYRows = numYRows;
	}
	
	public void setMidYRow(int r) { midYRow = r; }
	public int getMidYRow() { return midYRow; }
	
	public void setMidXCol(int c) { midXCol = c; }
	public int getMidXCol() { return midXCol; }

	public void add(Tile t, int colXPos, int rowYPos) {
		t.setColXPos(colXPos);
		t.setRowYPos(rowYPos);
		tiles.add(t);
		originals.add(t.copy());
	}
	
	public boolean hasTile(Coordinate coord) {
		for (Tile t : tiles) {
			if (t.contains(coord)) {
				return true;
			}
		}
		return false;
	}
	
	public Tile getTile(int colXPos, int rowYPos) {
		Coordinate thisCoord = new Coordinate(colXPos, rowYPos);
		for (Tile t: tiles) {
			if (t.contains(thisCoord)) {
				return t;
			}
		}
		System.out.println("No tile found");
		return null;
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	public void reset() {
		tiles.clear();
		for (Tile t: originals) {
			tiles.add(t.copy());
		}
		
	}

	public boolean isWinCondition(int colXPos, int rowYPos) {
		
		return colXPos == midXCol && rowYPos == midYRow;
	}
}
