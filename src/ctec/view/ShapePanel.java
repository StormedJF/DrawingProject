package ctec.view;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Object> spamList;
	
	public ShapePanel()
	{
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		spamList = new ArrayList<Object>();
	}
	
	/**
	 * Adds a rectangle with a random position and size to the rectangle array list.
	 */
	public void addRectangle()
	{
		int xPosition = (int) (Math.random() * this.getWidth());
		int yPosition = (int) (Math.random() * this.getHeight());
		int width = (int) (Math.random() * (this.getWidth() / 2));
		int height = (int) (Math.random() * (this.getHeight() / 2));
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
	}
	
	/**
	 * Adds a square with a random position and size to the square array list.
	 */
	public void addSquare()
	{
		int xPosition = (int) (Math.random() * this.getWidth());
		int yPosition = (int) (Math.random() * this.getHeight());
		int size = (int) (Math.random() * (this.getHeight() / 2));
		
		squareList.add(new Rectangle(xPosition, yPosition, size, size));
	}
	
	/**
	 * Adds a ellipse with a random position and size to the ellipse array list.
	 */
	public void addEllipse()
	{
		int xPosition = (int) (Math.random() * this.getWidth());
		int yPosition = (int) (Math.random() * this.getHeight());
		int width = (int) (Math.random() * (this.getWidth() / 2));
		int height = (int) (Math.random() * (this.getWidth() / 2));
		
		ellipseList.add(new Ellipse2D.Double(xPosition, yPosition, width, height));
	}
	
	/**
	 * Adds a circle with a random position and size to the circle array list.
	 */
	public void addCircle()
	{
		int xPosition = (int) (Math.random() * this.getWidth());
		int yPosition = (int) (Math.random() * this.getHeight());
		int size = (int) (Math.random() * (this.getHeight() / 2));
		
		circleList.add(new Ellipse2D.Double(xPosition, yPosition, size, size));
	}
	
	/**
	 * Adds a triangle connecting 3 random positions to the triangle array list.
	 */
	public void addTriangle()
	{
		int[] xPoints = {(int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getWidth())};
		int[] yPoints = {(int) (Math.random() * this.getHeight()), (int) (Math.random() * this.getHeight()), (int) (Math.random() * this.getHeight())};
		
		triangleList.add(new Polygon(xPoints, yPoints, 3));
	}
	
	/**
	 * Adds a polygon with a random number of sides and random positions to the polygon array list.
	 */
	public void addPolygon()
	{
		int numberOfSides = (int) (Math.random() * 9) + 3;
		int[] xPoints = new int[numberOfSides];
		int[] yPoints = new int[numberOfSides];
		
		for(int side = 0; side < numberOfSides; side++)
		{
			xPoints[side] = (int) (Math.random() * this.getWidth());
			yPoints[side] = (int) (Math.random() * this.getHeight());
		}
		
		polygonList.add(new Polygon(xPoints, yPoints, numberOfSides));
	}
	
	/**
	 * removes all objects from all of the array lists.
	 */
	public void clearScreen()
	{
		rectangleList.clear();
		squareList.clear();
		ellipseList.clear();
		circleList.clear();
		triangleList.clear();
		polygonList.clear();
		spamList.clear();
	}
	
	public void spam()
	{
		int numObjects = (int) (Math.random() * 5000);
		
		for(int index = 0; index < numObjects; index++)
		{
			int xPosition = (int) (Math.random() * this.getWidth());
			int yPosition = (int) (Math.random() * this.getHeight());
			int width = (int) (Math.random() * (this.getWidth() / 2));
			int height = (int) (Math.random() * (this.getHeight() / 2));
			
			spamList.add(new Rectangle(xPosition, yPosition, width, height));
			
			xPosition = (int) (Math.random() * this.getWidth());
			yPosition = (int) (Math.random() * this.getHeight());
			width = (int) (Math.random() * (this.getWidth() / 2));
			height = (int) (Math.random() * (this.getWidth() / 2));
			
			spamList.add(new Ellipse2D.Double(xPosition, yPosition, width, height));
			
			xPosition = (int) (Math.random() * this.getWidth());
			yPosition = (int) (Math.random() * this.getHeight());
			int size = (int) (Math.random() * (this.getHeight() / 2));
			
			spamList.add(new Ellipse2D.Double(xPosition, yPosition, size, size));
			
			int[] xPoints = {(int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getWidth())};
			int[] yPoints = {(int) (Math.random() * this.getHeight()), (int) (Math.random() * this.getHeight()), (int) (Math.random() * this.getHeight())};
			
			spamList.add(new Polygon(xPoints, yPoints, 3));
			
			int numberOfSides = (int) (Math.random() * 9) + 3;
			int[] x2Points = new int[numberOfSides];
			int[] y2Points = new int[numberOfSides];
			
			for(int side = 0; side < numberOfSides; side++)
			{
				x2Points[side] = (int) (Math.random() * this.getWidth());
				y2Points[side] = (int) (Math.random() * this.getHeight());
			}
			
			spamList.add(new Polygon(x2Points, y2Points, numberOfSides));
		}
	}
	
	/**
	 * Draws all of the objects in the array lists onto the screen.
	 */
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		drawShapes(mainGraphics, rectangleList);
		drawShapes(mainGraphics, squareList);
		drawShapes(mainGraphics, ellipseList);
		drawShapes(mainGraphics, circleList);
		drawShapes(mainGraphics, triangleList);
		drawShapes(mainGraphics, polygonList);
		drawShapes(mainGraphics, spamList);
	}

	private void drawShapes(Graphics2D mainGraphics, ArrayList shapes)
	{
		for(Object current : shapes)
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int alpha = (int) (Math.random() * 256);
			int stroke = (int) (Math.random() * 20);
			
			mainGraphics.setStroke(new BasicStroke(stroke));
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.draw((Shape)current);
		}
	}
}