package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class VistaAltaCliente extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textDNI_CUIT;
	private JTextField textNombre_razonSocial;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	
	private JPanel contentPane;
	static private VistaAltaCliente instancia;

	static public VistaAltaCliente getInstancia() {
		if (instancia == null) {
			instancia = new VistaAltaCliente();
		}
		return instancia;
	}
	
	public VistaAltaCliente() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Crear cliente");
		setBounds(100, 100, 352, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBoxPF_PJ = new JComboBox<String>();
		comboBoxPF_PJ.setBounds(10, 13, 161, 27);
		contentPane.add(comboBoxPF_PJ);
		comboBoxPF_PJ.addItem("Persona fisica");
		comboBoxPF_PJ.addItem("Persona juridica");
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 52, 47, 14);
		contentPane.add(lblDNI);
		
		JLabel lblCUIT = new JLabel("CUIT");
		lblCUIT.setBounds(10, 52, 47, 14);
		contentPane.add(lblCUIT);
		lblCUIT.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 78, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblRazonSocial = new JLabel("Razon social");
		lblRazonSocial.setBounds(10, 78, 96, 14);
		contentPane.add(lblRazonSocial);
		lblRazonSocial.setVisible(false);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 110, 65, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 136, 65, 14);
		contentPane.add(lblTelefono);
		
		textDNI_CUIT = new JTextField();
		textDNI_CUIT.setBounds(100, 46, 235, 20);
		contentPane.add(textDNI_CUIT);
		textDNI_CUIT.setColumns(10);
		
		textNombre_razonSocial = new JTextField();
		textNombre_razonSocial.setBounds(100, 75, 235, 20);
		contentPane.add(textNombre_razonSocial);
		textNombre_razonSocial.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(100, 107, 235, 20);
		contentPane.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(100, 133, 235, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(10, 170, 161, 18);
		contentPane.add(labelResultado);
		
		
		comboBoxPF_PJ.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (comboBoxPF_PJ.getSelectedIndex() == 0) {
						lblDNI.setVisible(true);
						lblNombre.setVisible(true);
						lblCUIT.setVisible(false);
						lblRazonSocial.setVisible(false);
					} else {
						lblDNI.setVisible(false);
						lblNombre.setVisible(false);
						lblCUIT.setVisible(true);
						lblRazonSocial.setVisible(true);
					}
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		
		
		
		JButton btnCrearCliente = new JButton("Crear cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try{
					int dni = Integer.parseInt(textDNI_CUIT.getText());
					String nombre = textNombre_razonSocial.getText();
					String domicilio = textDomicilio.getText();
					int telefono = Integer.parseInt(textTelefono.getText());
					if (comboBoxPF_PJ.getSelectedIndex()==0) {
					//Llamar al constructor de persona fisica pasando como parametros los campos dni, nombre, domicilio y telefono
					//devuelve un boolean
						labelResultado.setText("Cliente PF creada!");
					} else {
					//Llamar al constructor de persona juridica como parametros los campos dni, nombre, domicilio y telefono
					//devuelve un boolean
						labelResultado.setText("Cliente PJ creada!");
					}
					textDNI_CUIT.setText("");
					textNombre_razonSocial.setText("");
					textDomicilio.setText("");
					textTelefono.setText("");
					VistaAltaCliente.getInstancia().setVisible(false);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("No se pudo guardar el registro de cliente");
				}
			}
			
		});
		btnCrearCliente.setBounds(10, 165, 161, 23);
		contentPane.add(btnCrearCliente);		
		
	}
}