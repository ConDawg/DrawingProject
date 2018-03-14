package Model;

import java.awt.Image;
import java.awt.RenderingHints;

//Provides classes for creating and modifying images.
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
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
		
		protected void paintComponent(Graphics g2)
		{
			if (image == null)
			{
				image = createImage(getSize().width, getSize().height);
				g2 = (Graphics2D) image.getGraphics();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				clear();
			}
			
			g.drawImage(image, 0, 0, null);
		}
		
		public void clear()
		{
			g2.setPaint(Color.white);
			g2.fillRect(0, 0, getSize().width, getSize().height);
			g2.setPaint(Color.black);
			repaint();
		}
		
		public void red()
		{
			g2.setPaint(Color.red);
		}
		
		public void blue()
		{
			g2.setPaint(Color.blue);
		}
		//
	}
}
