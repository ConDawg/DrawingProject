package Model;

import java.awt.Image;
//Provides classes for creating and modifying images.
import javax.swing.JComponent;
import java.awt.Graphics2D;
//Provides control over geometry, coordinate transformations, and text.
import java.awt.event.MouseAdapter;
//provides use of drag and moved events by the mouse.

public class DrawArea extends JComponent
//JComponent provides support for tool tips, The base class for standard and custom components.
{
	private Image image;
	// Picture that'll be drawn on.
	
