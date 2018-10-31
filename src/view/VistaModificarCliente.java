package view;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bean.ClienteView;


public class VistaModificarCliente extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblDNI_CUIT;
	private JTextField textFieldDNI_CUIT;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JLabel lblNombre_razonSocial;
	private JLabel lblDomicilio;
	private JLabel lblTelefono;
	private JTextField textNombre_razonSocial;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private ClienteView cv;
	
	
	public VistaModificarCliente()
	{
		crearPantalla();
	}

	private void crearPantalla()
	{
		try
		{
			setTitle("Modificar cliente");
			setSize(500, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			lblNombre_razonSocial = new JLabel();
			getContentPane().add(lblNombre_razonSocial);
			lblNombre_razonSocial.setText("Nombre/Razon Social");
			lblNombre_razonSocial.setBounds(10, 61, 158, 28);
			lblNombre_razonSocial.setVisible(false);
			
			lblDNI_CUIT = new JLabel("DNI/CUIT");
			lblDNI_CUIT.setBounds(10, 18, 63, 14);
			getContentPane().add(lblDNI_CUIT);
		
			lblDomicilio = new JLabel("Domicilio:");
			lblDomicilio.setBounds(10, 100, 83, 14);
			getContentPane().add(lblDomicilio);
			lblDomicilio.setVisible(false);

			lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 132, 83, 14);
			getContentPane().add(lblTelefono);
			lblTelefono.setVisible(false);

			textNombre_razonSocial = new JTextField();
			textNombre_razonSocial.setBounds(190, 64, 184, 22);
			getContentPane().add(textNombre_razonSocial);
			textNombre_razonSocial.setVisible(false);
			
			textFieldDNI_CUIT = new JTextField();
			textFieldDNI_CUIT.setBounds(83, 15, 140, 20);
			getContentPane().add(textFieldDNI_CUIT);
			textFieldDNI_CUIT.setColumns(10);
			
			textDomicilio = new JTextField();
			textDomicilio.setBounds(190, 96, 184, 22);
			getContentPane().add(textDomicilio);
			textDomicilio.setVisible(false);
			
			textTelefono = new JTextField();
			textTelefono.setBounds(190, 128, 184, 22);
			getContentPane().add(textTelefono);
			textTelefono.setVisible(false);
			
			btnBuscar = new JButton("Buscar");
			getContentPane().add(btnBuscar);
			btnBuscar.setBounds(243, 14, 103, 22);
			btnBuscar.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					cv = null;//Llamar la instanciaControladorCliente.getInstancia().mostrarCliente(Integer.parseInt(textFieldDNI.getText()));
					if (cv != null)
					{
						textFieldDNI_CUIT.setEnabled(false);
						btnBuscar.setEnabled(false);
						lblNombre_razonSocial.setVisible(true);
						lblDomicilio.setVisible(true);
						lblTelefono.setVisible(true);
						btnModificar.setEnabled(true);
						btnModificar.setVisible(true);
						textNombre_razonSocial.setVisible(true);
						textNombre_razonSocial.setEnabled(true);
						//textNombre_razonSocial.setText(cv.getNombre());
						textDomicilio.setEnabled(true);
						textDomicilio.setVisible(true);
						//textDomicilio.setText(cv.getDomicilio());
						textTelefono.setEnabled(true);
						textTelefono.setVisible(true);
						//textTelefono.setText(String.valueOf(cv.getTelefono()));
					}else
					{
						JOptionPane.showMessageDialog((Component)e.getSource(), "Cliente inexistente");
					}
				}
			});

			
			btnModificar = new JButton("Modificar");
			btnModificar.setBounds(10, 175, 89, 23);
			getContentPane().add(btnModificar);
			btnModificar.setVisible(true);
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					//metodo para modificar cliente
					//modificarCliente(textNombre.getText(), Integer.parseInt(textFieldDNI.getText()), textDomicilio.getText(), Integer.parseInt(textTelefono.getText()));
					JOptionPane.showMessageDialog((Component)e.getSource(), "Cliente modificado");
					textFieldDNI_CUIT.setText("");
					textFieldDNI_CUIT.setEnabled(true);
					textNombre_razonSocial.setText("");
					textNombre_razonSocial.setEnabled(false);
					textDomicilio.setText("");
					textDomicilio.setEnabled(false);
					textTelefono.setText("");
					textTelefono.setEnabled(false);
					btnBuscar.setEnabled(true);
					btnModificar.setEnabled(false);
				}
			});

			JButton btnCerrar = new JButton();
			getContentPane().add(btnCerrar);
			btnCerrar.setText("Cerrar");
			btnCerrar.setBounds(297, 172, 77, 28);
			btnCerrar.addActionListener(new ActionListener()
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
