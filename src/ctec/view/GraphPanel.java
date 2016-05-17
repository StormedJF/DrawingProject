package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private ArrayList<Integer> valueList;
	
	public GraphPanel()
	{
		valueList = new ArrayList<Integer>();
		setupList();
		repaint();
	}
	
	public void setupList()
	{
		valueList.clear();
		
		int numberOfBars = 0;
		
		while(numberOfBars == 1 || numberOfBars == 0)
		{
			numberOfBars = (int) (Math.random() * 20);
		}
		
		for(int index = 0; index < numberOfBars; index++)
		{
			int number = (int) (Math.random() * this.getWidth() - 10);
			
			valueList.add(number);
		}
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(int current = 0; current < valueList.size(); current++)
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			mainGraphics.setStroke(new BasicStroke(2));
			mainGraphics.setColor(new Color(red, green, blue));
			
			int x = 0;
			int width = valueList.get(current);
			int height = this.getHeight() / valueList.size();
			int y = current * height;
			
			mainGraphics.fill(new Rectangle(x, y, width, height));
		}
	}
}