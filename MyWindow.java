package Proyecto_Final;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

// import SaveImageButton.ImageFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MyWindow extends JFrame implements ActionListener , MouseListener , ChangeListener {
	
	JButton cargarButton;
	
	JButton guardarJPGButton;
	JButton guardarPNGButton;
	JButton guardarGIFButton;
	
	JButton borrarButton;
	
	JButton colorButton1;
	JButton colorButton2;
	JButton colorButton3;
	JButton colorButton4;
	JButton colorButton5;
	JButton colorButton6;
	JButton colorButton7;
	
	JFileChooser select;
	File archivo;
	byte[] imagen;
	FileInputStream entrada;
	FileOutputStream salida;

	
	JButton colorRGB;
	
	JPanel contentPane;
	
	Canvas canvas;
	
	JLabel lbl;
	
	JSlider RGB1;
	JSlider RGB2;
	JSlider RGB3;
	
	static Graphics g;	
	static BufferedImage img;
	
	int width, height, x, y;
	
	public MyWindow(int width, int height) {
	
		this.width = width;
		this.height = height;				
		
		components();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // al cerrar la ventana se detiene el programa
		setSize(width,height);							// tamaño de la ventana
		setLocationRelativeTo(null);					// centra la ventana
		setLayout(null);								// elimina plantillas
		setResizable(false);							// no permite modificar el tamaño de la ventana
		setVisible(true);								// muestra la ventana	
	}
			
	private void components()
	{
		contentPane = new JPanel();
		cargarButton = new JButton("CARGAR");
		guardarJPGButton = new JButton("GUARDAR .JPG");
		guardarPNGButton = new JButton("GUARDAR .PNG");
		guardarGIFButton = new JButton ("GUARDAR .GIF");
		borrarButton = new JButton("BORRAR TODO");
		colorButton1 = new JButton("BORRAR");
		colorButton2 = new JButton();
		colorButton3 = new JButton();
		colorButton4 = new JButton();
		colorButton5 = new JButton();
		colorButton6 = new JButton();
		colorButton6 = new JButton();
		colorButton7 = new JButton();
		
		lbl = new JLabel();

		select = new JFileChooser();
		
		// fileChooser.addChoosableFileFilter(new ImageFilter()); //*/

		colorRGB = new JButton();

		canvas 		= new Canvas();
		RGB1		= new JSlider(0, 255);
		RGB1.setBackground(Color.RED);

		RGB2		= new JSlider(0, 255);
		RGB2.setBackground(Color.green);

		RGB3		= new JSlider(0, 255);
		RGB3.setBackground(Color.blue);
				
		contentPane.setLayout(null);
		contentPane.setBackground(Color.gray);
		contentPane.setBounds(0,0,width,height);
				
		lbl.setBounds(0,0, width,height);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Serif", Font.PLAIN, 70));
		
		//COLORES RGB
		
		RGB1.setBounds(20, 600, 335, 35);
		RGB1.addChangeListener(this); //AGREGAR SLIDERS	
		RGB2.setBounds(20, 630, 335, 35);
		RGB2.addChangeListener(this); //AGREGAR SLIDERS	
		RGB3.setBounds(20, 660, 335, 35);
		RGB3.addChangeListener(this); //AGREGAR SLIDERS	
		
		//BOTONES EXTRA
		cargarButton.setBounds(50, 50, 150, 30);
		cargarButton.addActionListener(this);	
		
		guardarJPGButton.setBounds(225, 50, 150, 30);
		guardarJPGButton.addActionListener(this);	//AGREGAR BOTON}
		
		guardarPNGButton.setBounds(225, 80, 150, 30);
		guardarPNGButton.addActionListener(this);
		
		guardarGIFButton.setBounds(225, 110, 150, 30);
		guardarGIFButton.addActionListener(this);
		
		borrarButton.setBounds(50, 200, 150, 30);
		borrarButton.addActionListener(this);	//AGREGAR BOTON
		
		//COLORES PREDETERMINADOS
		colorButton1.setBounds(50, 260, 200, 30);
		colorButton1.addActionListener(this);	//AGREGAR BOTON

		colorButton2.setBounds(50, 290, 200, 30);
		colorButton2.addActionListener(this);	//AGREGAR BOTON
		colorButton2.setBackground(Color.blue);

		colorButton3.setBounds(50, 320, 200, 30);
		colorButton3.addActionListener(this);	//AGREGAR BOTON
		colorButton3.setBackground(Color.red);

		colorButton4.setBounds(50, 350, 200, 30);
		colorButton4.addActionListener(this);	//AGREGAR BOTON
		colorButton4.setBackground(Color.yellow);

		colorButton5.setBounds(50, 380, 200, 30);
		colorButton5.addActionListener(this);	//AGREGAR BOTON
		colorButton5.setBackground(Color.orange);

		colorButton6.setBounds(50, 410, 200, 30);
		colorButton6.addActionListener(this);	//AGREGAR BOTON
		colorButton6.setBackground(Color.green);
	
		colorButton7.setBounds(50, 440, 200, 30);
		colorButton7.addActionListener(this);	//AGREGAR BOTON
		colorButton7.setBackground(Color.white);
		
		colorRGB.setBounds(400, 650, 50, 50);
		colorRGB.addActionListener(this);

		colorButton1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(0);
		        RGB2.setValue(0);
		        RGB3.setValue(0);

		    }});		
		colorButton2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(0);
		        RGB2.setValue(0);
		        RGB3.setValue(255);

		    }});
		colorButton3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(255);
		        RGB2.setValue(0);
		        RGB3.setValue(0);

		    }});
		colorButton4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(255);
		        RGB2.setValue(255);
		        RGB3.setValue(0);

		    }});
		colorButton5.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(255);
		        RGB2.setValue(200);
		        RGB3.setValue(0);

		    }});
		colorButton6.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(0);
		        RGB2.setValue(255);
		        RGB3.setValue(0);

		    }});
		
		colorButton7.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        RGB1.setValue(255);
		        RGB2.setValue(255);
		        RGB3.setValue(255);

		    }});
		
		guardarJPGButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						guardarJPG(e);
					}
			
				});
		
		guardarPNGButton.addActionListener(new ActionListener()
			{
	
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					guardarPNG(e);
				}
	
			});
		
		guardarGIFButton.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					guardarGIF(e);
				}
	
			});
		
		cargarButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try 
					{
						cargar(e);
					} catch (FileNotFoundException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		borrarButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					borrarTodo(e);
				}
			});
			
		
		canvas.setBounds((width/2 )- 250, (height/2) - 390, 626, 626);
		canvas.addMouseListener(this);
		
		contentPane.add(RGB1);
		contentPane.add(RGB2);
		contentPane.add(RGB3);
		contentPane.add(canvas);
		contentPane.add(lbl);
		contentPane.add(cargarButton);
		contentPane.add(guardarJPGButton);
		contentPane.add(guardarPNGButton);
		contentPane.add(guardarGIFButton);
		contentPane.add(borrarButton);
		contentPane.add(colorButton1);
		contentPane.add(colorButton2);
		contentPane.add(colorButton3);
		contentPane.add(colorButton4);
		contentPane.add(colorButton5);
		contentPane.add(colorButton6);
		contentPane.add(colorButton7);
		contentPane.add(colorRGB);
		
		add(contentPane);
	}
	
	public void guardarJPG(ActionEvent e)
	{
		String extension = ".jpg"; 
		String fileName = "";
		
		int result = select.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = select.getSelectedFile();
			extension = getFileExtension(selectedFile);
			fileName = selectedFile.getName();
			
			if(extension.isEmpty())
			{
				switch(select.getFileFilter().getDescription())
				{
				case "JPEG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "PNG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "GIF":
					selectedFile = new File(selectedFile.getPath());
					break;
				} //*/
			}
			
			try
			{
				BufferedImage image = canvas.getImage();
				
				ImageIO.write(image, ".jpg", selectedFile);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	 public void guardarPNG(ActionEvent e)
	{
		String extension = ".png"; 
		String fileName = "";
		
		int result = select.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = select.getSelectedFile();
			extension = getFileExtension(selectedFile);
			fileName = selectedFile.getName();
			
			if(extension.isEmpty())
			{
				switch(select.getFileFilter().getDescription())
				{
				case "JPEG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "PNG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "GIF":
					selectedFile = new File(selectedFile.getPath());
					break;
				}
			}
			
			try
			{
				BufferedImage image = canvas.getImage();
				
				ImageIO.write(image, ".png", selectedFile);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void guardarGIF(ActionEvent e)
	{
		String extension = ".gif"; 
		String fileName = "";
		
		int result = select.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = select.getSelectedFile();
			extension = getFileExtension(selectedFile);
			fileName = selectedFile.getName();
			
			if(extension.isEmpty())
			{
				switch(select.getFileFilter().getDescription())
				{
				case "JPEG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "PNG":
					selectedFile = new File(selectedFile.getPath());
					break;
				case "GIF":
					selectedFile = new File(selectedFile.getPath());
					break;
				}
			}
			
			try
			{
				BufferedImage image = canvas.getImage();
				
				ImageIO.write(image, ".gif", selectedFile);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	} 
	
	public void cargar(ActionEvent e) throws FileNotFoundException
	{
		if(select.showDialog(null, null) == JFileChooser.APPROVE_OPTION)
		{
			archivo = select.getSelectedFile();
			if(archivo.canRead())
			{
				if(archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png") || archivo.getName().endsWith("gif"));
				imagen = AbrirArchivo(archivo);
				// canvas.setForeground(imagen);
			}
		}
	}
	
	public void borrarTodo(ActionEvent e)
	{
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				canvas.getGraphic().setColor(Color.black);
				canvas.getGraphic().fillRect(i, j, 500, 500);
			}
		}
	}
	
	public byte[] AbrirArchivo(File archivo)
	{
		byte[] imagen = new byte[1024*100];
		try
		{
			entrada = new FileInputStream(archivo);
			entrada.read(imagen);
		}
		catch(Exception e)
		{
			
		}
		return imagen;
	}

	private String getFileExtension(File file) 
	{
		String extension = "";
		String fileName = file.getName();
		int dotIndex = fileName.lastIndexOf('.');
		
		if(dotIndex > 0 && dotIndex < fileName.length() - 1)
		{
			extension = fileName.substring(dotIndex + 1).toLowerCase();
		}
		
		return extension;
	}
	
	private class ImageFilter extends FileFilter 
    {

        public boolean accept(File file) 
        {
            if (file.isDirectory()) 
            {
                return true;
            }

            String extension = getFileExtension(file);

            if (extension != null) 
            {
                switch (extension.toLowerCase()) 
                {
                    case "jpg":
                    case "jpeg":
                    case "png":
                    case "gif":
                        return true;
                }
            }

            return false;
        }

        public String getDescription() 
        {
            return "Images (*.jpg, *.png, *.gif)";
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		x = e.getX(); //get the x and y coordinates of
		y = e.getY();
		
		x /= 25;
		x *= 25;
		
		y /=25;
		y *=25;
		
		canvas.getGraphic().setColor(new Color(RGB1.getValue(), RGB2.getValue(), RGB3.getValue()));
		canvas.getGraphic().fillRect(x, y, 25, 25);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		colorRGB.setBackground(new Color(RGB1.getValue(), RGB2.getValue(), RGB3.getValue()));
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
}