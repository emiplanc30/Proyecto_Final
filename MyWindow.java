package Proyecto_Final;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import java.io.File;
import java.io.IOException;

public class MyWindow extends JFrame implements ActionListener , MouseListener , ChangeListener 
{	
	JButton cargarButton;
	JButton guardarButton;
	JButton borrarButton;
	
	JButton colorButton1;
	JButton colorButton2;
	JButton colorButton3;
	JButton colorButton4;
	JButton colorButton5;
	JButton colorButton6;
	JButton colorButton7;

	JButton colorRGB;
	
	JPanel contentPane;
	
	Canvas canvas;
	
	JLabel lbl;
	
	JSlider RGB1;
	JSlider RGB2;
	JSlider RGB3;
	
	static Graphics g, gL0;	
	static BufferedImage img, layer0;
	
	int width, height, x, y;
	
	public MyWindow(int width, int height) 
	{
	
		this.width = width;
		this.height = height;				
		
		components();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(width,height);							
		setLocationRelativeTo(null);					
		setLayout(null);								
		setResizable(false);							
		setVisible(true);								
	}
			
	private void components()
	{
		contentPane = new JPanel();
		
		cargarButton 	= new JButton("CARGAR");
		guardarButton 	= new JButton("GUARDAR");
		borrarButton 	= new JButton("BORRAR TODO");
		colorButton1 	= new JButton("BORRAR");
		colorButton2 	= new JButton();
		colorButton3 	= new JButton();
		colorButton4 	= new JButton();
		colorButton5 	= new JButton();
		colorButton6 	= new JButton();
		colorButton6 	= new JButton();
		colorButton7 	= new JButton();


		colorRGB = new JButton();

		lbl 		= new JLabel("");
		canvas 		= new Canvas();
		RGB1		= new JSlider(0, 255);
		RGB1.setBackground(Color.RED);

		RGB2		= new JSlider(0, 255);
		RGB2.setBackground(Color.green);

		RGB3		= new JSlider(0, 255);
		RGB3.setBackground(Color.blue	);
				
		contentPane.setLayout(null);
		contentPane.setBackground(Color.gray);
		contentPane.setBounds(0,0,width,height);//*/
				
		lbl.setBounds(0,0, width,height);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Serif", Font.PLAIN, 50));
		
		//COLORES RGB
		RGB1.setBounds(20, 600, 335, 35);
		RGB1.addChangeListener(this); //AGREGAR SLIDERS	
		RGB2.setBounds(20, 630, 335, 35);
		RGB2.addChangeListener(this); //AGREGAR SLIDERS	
		RGB3.setBounds(20, 660, 335, 35);
		RGB3.addChangeListener(this); //AGREGAR SLIDERS	
		
		//BOTONES CARGAR Y GUARDAR
		cargarButton.setBounds(50, 50, 150, 30);
		cargarButton.addActionListener(this);	//AGREGAR BOTON
		guardarButton.setBounds(225, 50, 150, 30);
		guardarButton.addActionListener(this);	//AGREGAR BOTON
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

		colorButton1.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(0);
		        RGB2.setValue(0);
		        RGB3.setValue(0);

		    }});
		
		colorButton2.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(0);
		        RGB2.setValue(0);
		        RGB3.setValue(255);

		    }});
		
		colorButton3.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(255);
		        RGB2.setValue(0);
		        RGB3.setValue(0);

		    }});
		
		colorButton4.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(255);
		        RGB2.setValue(255);
		        RGB3.setValue(0);

		    }});
		
		colorButton5.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(255);
		        RGB2.setValue(200);
		        RGB3.setValue(0);

		    }});
		
		colorButton6.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(0);
		        RGB2.setValue(255);
		        RGB3.setValue(0);

		    }});
		
		colorButton7.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        RGB1.setValue(255);
		        RGB2.setValue(255);
		        RGB3.setValue(255);

		    }});
		
		guardarButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						guardar(e);
					}
				});
		
		cargarButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						cargar(e);
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
		
		canvas.setBounds((width/2 )- 250, (height/2) - 390,626,626);	
		canvas.addMouseListener(this);
		
		contentPane.add(RGB1);
		contentPane.add(RGB2);
		contentPane.add(RGB3);
		contentPane.add(canvas);
		contentPane.add(lbl);
		contentPane.add(cargarButton);
		contentPane.add(guardarButton);
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
	
	public void guardar(ActionEvent e)
	{
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = chooser.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				BufferedImage imagen = canvas.getImage();
				File directorio = chooser.getSelectedFile();
				String opciones[] = {"png", "jpg", "gif"};
				String extension = (String) JOptionPane.showInputDialog(
						this, 
						"Seleciona la extensión del archivo:", 
						"Guardar imagen",
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						opciones, 
						"png");
				
				if (extension != null)
				{
					String nombreArchivo = JOptionPane.showInputDialog(
							this, 
							"Ingresa el nombre del archivo:",
							"Guardar imagen",
							JOptionPane.PLAIN_MESSAGE);
					if(nombreArchivo != null && !nombreArchivo.isEmpty())
					{
						File archivo = new File(directorio, nombreArchivo + "." + extension);
						ImageIO.write(imagen, extension, archivo);
					}
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void cargar(ActionEvent e)
	{
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				File archivo = chooser.getSelectedFile();
				BufferedImage imagen = ImageIO.read(archivo);
				Image imagenEscalada = imagen.getScaledInstance(canvas.getWidth(), canvas.getHeight(), Image.SCALE_SMOOTH);
				canvas.getGraphics().drawImage(imagenEscalada, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void borrarTodo(ActionEvent e)
	{
		canvas.fondoCanvas();		
		canvas.cuadricula();
	}
	
	public void actionPerformed(ActionEvent event) 
	{	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		x = e.getX(); 
		y = e.getY();
		
		x /= 25;
		x *= 25;
		
		y /=25;
		y *=25;
		
		canvas.getGraphic().setColor(new Color(RGB1.getValue(), RGB2.getValue(), RGB3.getValue()));
		canvas.getGraphic().fillRect(x, y, 25, 25);
		
		lbl.setText(x+" "+y);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		colorRGB.setBackground(new Color(RGB1.getValue(), RGB2.getValue(), RGB3.getValue()));
	}
}
