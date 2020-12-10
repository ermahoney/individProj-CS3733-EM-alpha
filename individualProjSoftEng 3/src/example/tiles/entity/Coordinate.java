package example.tiles.entity;

public class Coordinate {
	public final int colXPos;
	public final int rowYPos;

	public Coordinate(int colXPos, int rowYPos) {
		this.colXPos = colXPos;
		this.rowYPos = rowYPos;
	}

	public String toString() {
		return "(" + colXPos + "," + rowYPos + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o instanceof Coordinate) {
			Coordinate other = (Coordinate) o;
			return colXPos == other.colXPos && rowYPos == other.rowYPos;
		}
		return false;
	}
}
