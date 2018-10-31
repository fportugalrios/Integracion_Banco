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


public class VistaBajaCuenta extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel labelNroCuenta;
	private JLabel labelInstruccion;
	private JTextField textFieldNroCuenta;
	private JButton botonBaja;
	private JButton botonCerrar;
	
		
	public VistaBajaCuenta()
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
			
			labelNroCuenta = new JLabel();
			getContentPane().add(labelNroCuenta);
			labelNroCuenta.setText("Nro cuenta:");
			labelNroCuenta.setBounds(18, 94, 89, 28);
			
			labelInstruccion = new JLabel("Ingrese el nro de cuenta del cliente");
			labelInstruccion.setBounds(106, 52, 292, 14);
			getContentPane().add(labelInstruccion);
						
			textFieldNroCuenta = new JTextField();
			getContentPane().add(textFieldNroCuenta);
			textFieldNroCuenta.setBounds(119, 94, 147, 28);
			
			botonBaja = new JButton();
			getContentPane().add(botonBaja);
			botonBaja.setText("Baja");
			botonBaja.setBounds(156, 133, 77, 28);
			botonBaja.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					//Metodo de baja de cuenta
					//bajaCuenta(textFieldNroCuenta.getText());
					boolean resultado=true; //test
					
					if (resultado)
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "Cuenta eliminada"); 
					}
					else
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "La cuenta no existe"); 
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