package example.tiles.entity;

public class Tile {

	int value;
	int rowYPos;
	int colXPos;
	boolean isWinner;
	
	//he deleted constructor but i am leaving for reference
	public Tile(int value, int rowYPos, int colXPos) {
		this.value = value;
 		this.rowYPos = rowYPos;
 		this.colXPos = colXPos;
	}
	
	//for making new tile with just value
	public Tile(int value) {
		this.value = value;
	}
	
	public Tile copy() {
		Tile t = new Tile(value, rowYPos, colXPos);
		t.setValue(value);
		t.setRowYPos(rowYPos);
		t.setColXPos(colXPos);
		t.setWinner(isWinner);
		return t;
	}

	public boolean isWinner() { return isWinner; }
	public void setWinner(boolean flag) { isWinner = flag; }
	
	public int getValue() { return value; }
	public void setValue(int v) { this.value = v; }
	
	public void setRowYPos(int r) { this.rowYPos = r; }
	public void setColXPos(int c) { this.colXPos = c; }
	
	public int getColXPos() { return colXPos; }
	public int getRowYPos() { return rowYPos; }


	public Coordinate getLocation () { return new Coordinate(colXPos, rowYPos); }

	public boolean contains(Coordinate c) {
		if (c.colXPos == colXPos && c.colXPos == colXPos && c.rowYPos == rowYPos && c.rowYPos == rowYPos) {
			return true;
		}
		return false;
	}

	public void move(MoveType dir) {
		if (dir == MoveType.None) { return; }
		this.rowYPos += dir.deltaR;
		this.colXPos += dir.deltaC;
	}

	

}
