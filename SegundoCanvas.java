package Proyecto_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SegundoCanvas extends JFrame implements ActionListener, ChangeListener, MouseListener
{
		JSlider sliding;
		JPanel ventanota;
		
		public SegundoCanvas() 
		{
			
			ventanota = new JPanel();
			ventanota.setLayout(null);
			sliding = new JSlider(0,255);
			sliding.setBounds(0,800, 300,100);
			sliding.addChangeListener(this);
			
			Canvas canvas 	= new Canvas();
			canvas.setBounds(500, 200,500,500);//---			
			canvas.addMouseListener(this);
			
			ventanota.add(canvas);
			ventanota.add(sliding);			
			add(ventanota);
			
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1500,900);
			setLocationRelativeTo(null);					// centra la ventana
			//setLayout(null);								// elimina plantillas
			setResizable(false);							// no permite modificar el tamaño de la ventana
			setVisible(true);	
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{		}

		@Override
		public void stateChanged(ChangeEvent e) 
		{
			System.out.println(sliding.getValue());
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{		}

		@Override
		public void mousePressed(MouseEvent e) 
		{		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{		}

		@Override
		public void mouseEntered(MouseEvent e) 
		{		}

		@Override
		public void mouseExited(MouseEvent e) 
		{		}
}