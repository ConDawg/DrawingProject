package Model;

import java.awt.Image;
//Provides classes for creating and modifying images.
import javax.swing.JComponent;
import java.awt.Graphics2D;
//Provides control over geometry, coordinate transformations, and text.
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//provides use of drag and moved events by the mouse.

public class DrawArea extends JComponent
//JComponent provides support for tool tips, The base class for standard and custom components.
{
	private Image image;
	// Picture that'll be drawn on.
	private Graphics2D g2;
	//g- the graphics context in which to paint.
	private int currentX, currentY, oldX, oldY;
	//These are mouse coordinates.
	
	public DrawArea()
	{
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent line)
			{
				oldX = line.getX();
				oldY = line.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent line)
			{
				currentX = line.getX();
				currentY = line.getY();
				
				if (g2 != null) 
				{
					g2.drawLine(oldX, oldY, currentX, currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}
		});
		
		protected void paintComponent (Graphics g)
		{
			if (image == null)
			{
				
			}
		}
		//
	}
}
