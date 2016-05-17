package ctec.view;

import javax.swing.JFrame;
import ctec.controller.Controller;

public class DrawingFrame extends JFrame
{
	private Controller baseController;
	private DrawingPanel drawingPanel;
	
	public DrawingFrame(Controller baseController)
	{
		this.baseController = baseController;
		drawingPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Sets all of the variables for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(drawingPanel);
		this.setTitle("Drawing!");
		this.setSize(800, 800);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}