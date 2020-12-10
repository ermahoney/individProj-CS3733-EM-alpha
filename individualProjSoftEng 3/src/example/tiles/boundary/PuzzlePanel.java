package example.tiles.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import example.tiles.entity.Coordinate;
import example.tiles.entity.Model;
import example.tiles.entity.Puzzle;
import example.tiles.entity.Tile;

public class PuzzlePanel extends JPanel {
	
	Model model;
	public static final int boxSize = 70;
	public static final int offset = 2;
	public static final int fontSize = 50;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computeRectangle (Tile t) {
		int colXPos = t.getColXPos();
		int rowYPos = t.getRowYPos(); 
		Rectangle rect = new Rectangle(colXPos*boxSize + offset, rowYPos*boxSize + offset, boxSize - offset, boxSize - offset);
		return rect;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.x/boxSize, p.y/boxSize);
	}
	
	public void drawStringRect(Graphics g, Color stringColor, Rectangle rect, String s) {
		Color black = g.getColor();
		FontMetrics fm = g.getFontMetrics();
		g.setColor(stringColor);
		int stringWidth = fm.stringWidth( s );
		int startX = rect.x + (( rect.width - stringWidth ) / 2);
		int startY = rect.y + (( rect.height + fm.getHeight() ) / 2);
		g.drawString( s,  startX,  startY );
		g.setColor( black );
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; } // nothing to draw. only here for windowbuilder
		
		Tile selectedTile = model.getSelectedTile();
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {
			
			if (t.equals(selectedTile)) {
				g.setColor(Color.yellow);
			} else {
				if (t.isWinner()) {
					g.setColor(Color.red);
				} else {
					g.setColor(Color.gray);
				}
			}
			
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			drawStringRect(g, Color.black, r, Integer.toString(t.getValue()));
			//g.setFont(g.getFont().getFontName(), Font.PLAIN, 24);
		}
		
	}
}
