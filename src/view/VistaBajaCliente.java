package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class VistaBajaCliente extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel labelDNI_CUIT;
	private JLabel labelInstruccion;
	private JTextField textFieldDNI_CUIT;
	private JButton botonBaja;
	private JButton botonCerrar;
	
		
	public VistaBajaCliente()
	{
		crearPantalla();
	}
	
	private void crearPantalla()
	{
		try
		{
			setSize(400, 270);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			labelDNI_CUIT = new JLabel();
			getContentPane().add(labelDNI_CUIT);
			labelDNI_CUIT.setText("DNI/CUIT:");
			labelDNI_CUIT.setBounds(18, 94, 89, 28);
			
			labelInstruccion = new JLabel("Ingrese el DNI/CUIT del cliente");
			labelInstruccion.setBounds(106, 52, 292, 14);
			getContentPane().add(labelInstruccion);
						
			textFieldDNI_CUIT = new JTextField();
			getContentPane().add(textFieldDNI_CUIT);
			textFieldDNI_CUIT.setBounds(119, 94, 147, 28);
			
			botonBaja = new JButton();
			getContentPane().add(botonBaja);
			botonBaja.setText("Baja");
			botonBaja.setBounds(156, 133, 77, 28);
			botonBaja.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					//Metodo de baja de cliente
					//bajaCliente(textFieldDNI_CUIT.getText());
					boolean resultado=true; //test
					
					if (resultado)
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "Cliente eliminado"); 
					}
					else
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "El cliente no existe"); 
					}
				}
			});
			
			botonCerrar = new JButton();
			getContentPane().add(botonCerrar);
			botonCerrar.setText("Cerrar");
			botonCerrar.setBounds(156, 185, 77, 28);
			botonCerrar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					dispose();
				}
			});
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}