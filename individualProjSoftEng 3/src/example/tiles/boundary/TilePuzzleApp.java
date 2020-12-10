package example.tiles.boundary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.tiles.controller.MoveTileController;
import example.tiles.controller.ResetController;
import example.tiles.controller.SelectTileController;
import example.tiles.entity.Model;
import example.tiles.entity.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TilePuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	
	Model model;
	JButton upButton, downButton, leftButton, rightButton, resetButton;
	JLabel actualResult;
	
	public PuzzlePanel getPuzzlePanel() { return panel; }
	public JButton getUpButton() { return upButton;}
	public JButton getDownButton() { return downButton;}
	public JButton getLeftButton() { return leftButton;}
	public JButton getRightButton() { return rightButton;}
	public JButton getResetButton() { return resetButton;}
	public JLabel getActualResult() { return actualResult; }
	
	/**
	 * Create the frame.
	 */
	public TilePuzzleApp(Model m) {
		super();
		this.model = m;
		setTitle("Tile Puzzle Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 495, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		panel.addMouseListener(new MouseAdapter( ) {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, TilePuzzleApp.this).process(me.getPoint());
				
			}
		});
		
		JLabel resultLabel = new JLabel("Result:");
		
		actualResult = new JLabel("" + model.getResult());
		actualResult.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, TilePuzzleApp.this).reset();
			}
		});
		
		upButton = new JButton("^");
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, TilePuzzleApp.this).move(MoveType.Up);
			}
		});
		
		leftButton = new JButton("<");
		leftButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, TilePuzzleApp.this).move(MoveType.Left);
			}
		});
		
		rightButton = new JButton(">");
		rightButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, TilePuzzleApp.this).move(MoveType.Right);
			}
		});
		
		downButton = new JButton("v");
		downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, TilePuzzleApp.this).move(MoveType.Down);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(resetButton)
							.addGap(75)
							.addComponent(resultLabel)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(actualResult, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(43))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(45))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(resetButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(actualResult, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(resultLabel)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
