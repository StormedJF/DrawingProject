package ctec.view;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import ctec.controller.Controller;

public class DrawingPanel extends JPanel
{
	//Base Components
	private Controller baseController;
	private SpringLayout baseLayout;
	
	//Panels
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	
	//Buttons
	private JButton addRectangleButton;
	private JButton addSquareButton;
	private JButton addEllipseButton;
	private JButton addCircleButton;
	private JButton addTriangleButton;
	private JButton addPolygonButton;
	private JButton clearScreenButton;
	private JButton redrawGraphButton;
	private JButton spamButton;
	
	public DrawingPanel(Controller baseController)
	{
		//Base Components
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		//Panels
		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();
		
		//Buttons
		addRectangleButton = new JButton("Add a Rectangle");
		addSquareButton = new JButton("Add a Square");
		addEllipseButton = new JButton("Add a Ellipse");
		addCircleButton = new JButton("Add a Circle");
		addTriangleButton = new JButton("Add a Triangle");
		addPolygonButton = new JButton("Add a Polygon");
		clearScreenButton = new JButton("Clear the Screen");
		redrawGraphButton = new JButton("Redraw Graph");
		spamButton = new JButton("Spam");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Adds components to the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(shapePanel);
		this.add(addRectangleButton);
		this.add(addSquareButton);
		this.add(addEllipseButton);
		this.add(addCircleButton);
		this.add(addTriangleButton);
		this.add(addPolygonButton);
		this.add(clearScreenButton);
		this.add(graphPanel);
		this.add(redrawGraphButton);
		this.add(spamButton);
	}
	
	/**
	 * Moves components to their correct positions.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addTriangleButton, 6, SpringLayout.EAST, spamButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, addRectangleButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, clearScreenButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addTriangleButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -18, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonButton, 0, SpringLayout.NORTH, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 6, SpringLayout.EAST, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 479, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -6, SpringLayout.NORTH, graphPanel);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, redrawGraphButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, redrawGraphButton, 0, SpringLayout.EAST, clearScreenButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addCircleButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, clearScreenButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addCircleButton, 6, SpringLayout.EAST, addEllipseButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addSquareButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addSquareButton, 6, SpringLayout.EAST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addEllipseButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addEllipseButton, 6, SpringLayout.EAST, addSquareButton);
	}
	
	/**
	 * Adds listeners to components that need them.
	 */
	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				shapePanel.repaint();
			}
		});
		
		addSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.addSquare();
				shapePanel.repaint();
			}
		});
		
		addEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.addEllipse();
				shapePanel.repaint();
			}
		});
		
		addCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.addCircle();
				shapePanel.repaint();
			}
		});
		
		addTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.addTriangle();
				shapePanel.repaint();
			}
		});
		
		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.addPolygon();
				shapePanel.repaint();
			}
		});
		
		clearScreenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.clearScreen();
				shapePanel.repaint();
			}
		});
		
		redrawGraphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				graphPanel.setupList();
				graphPanel.repaint();
			}
		});
		
		spamButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Click)
			{
				shapePanel.spam();
				shapePanel.repaint();
			}
		});
	}
}