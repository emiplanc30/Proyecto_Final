package Proyecto_Final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Canvas extends JPanel  implements MouseMotionListener{
	
	
	private int x,y;
	static BufferedImage img, grid, layer0;
	static Graphics gfx, gL0, gg;	
	
	public Canvas() 
	{
		//FONDO DEL CANVAS
		addMouseMotionListener(this);
		setBackground(Color.black);
		
		img = new BufferedImage(740, 740, BufferedImage.TYPE_INT_ARGB);
		
		gfx = img.createGraphics();
		layer0 = new BufferedImage(740, 740, BufferedImage.TYPE_INT_ARGB);
		
		int size = 25;
		gL0 = layer0.createGraphics();
		gL0.setColor(Color.white);
		for(int y = 0; y <25; y++)
			for(int x= 0; x < 25; x++)
				gL0.drawRect(x*size, y*size, size, size);
	}
	
	public BufferedImage getImage()
	{
		return img;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		g.drawImage(layer0, 0, 0, null);
		
		g.drawImage(img, 0, 0, null);
	    g.setColor(Color.yellow);
	    g.fillOval(x-5, y-5, 10, 10);
	}

	public void setImage(BufferedImage image) 
	{
		img = image;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x = e.getX(); //get the x and y coordinates of
		y = e.getY(); //the mouse click point
		
		repaint();
	}
	
	public Graphics getGraphic() 
	{
		return gfx;
	}
	
}