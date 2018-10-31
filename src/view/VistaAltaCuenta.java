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

public class VistaAltaCuenta extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textDNI_CUIT;
	private JTextField textNombre_razonSocial;
	
	private JPanel contentPane;
	static private VistaAltaCliente instancia;

	static public VistaAltaCliente getInstancia() {
		if (instancia == null) {
			instancia = new VistaAltaCliente();
		}
		return instancia;
	}
	
	public VistaAltaCuenta() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Crear cuenta");
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBoxCA_CC = new JComboBox<String>();
		comboBoxCA_CC.setBounds(100, 7, 161, 27);
		contentPane.add(comboBoxCA_CC);
		comboBoxCA_CC.addItem("Caja de ahorro");
		comboBoxCA_CC.addItem("Cuenta corriente");
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 12, 47, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDNI_CUIT = new JLabel("DNI/CUIT");
		lblDNI_CUIT.setBounds(10, 52, 78, 14);
		contentPane.add(lblDNI_CUIT);
		
		JLabel lblNombre_razonSocial = new JLabel("Nombre/Razon social");
		lblNombre_razonSocial.setBounds(10, 97, 136, 14);
		contentPane.add(lblNombre_razonSocial);
		lblNombre_razonSocial.setVisible(false);
		
		textDNI_CUIT = new JTextField();
		textDNI_CUIT.setBounds(100, 46, 235, 20);
		contentPane.add(textDNI_CUIT);
		textDNI_CUIT.setColumns(10);
		
		textNombre_razonSocial = new JTextField();
		textNombre_razonSocial.setBounds(158, 94, 235, 20);
		contentPane.add(textNombre_razonSocial);
		textNombre_razonSocial.setColumns(10);
		textNombre_razonSocial.setEnabled(false);
		textNombre_razonSocial.setVisible(false);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(195, 161, 161, 18);
		contentPane.add(labelResultado);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(333, 126, 161, 23);
		contentPane.add(btnCrearCuenta);
		btnCrearCuenta.setEnabled(false);
		
		JButton btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setBounds(333, 46, 161, 23);
		contentPane.add(btnBuscarCliente);
		
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					//Cliente c = buscarCliente(textDNI_CUIT.getText());
					//if (c!=null)
					//	textNombre_razonSocial.setText(c.getNombre/razonsocial);
					labelResultado.setText("Cliente encontrado");
					btnCrearCuenta.setEnabled(true);
					textNombre_razonSocial.setEnabled(true);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("Error al buscar el cliente");
				}
			}
			
		});
			
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (comboBoxCA_CC.getSelectedIndex() == 0) {
					//Llamar al constructor de caja de ahorro
						labelResultado.setText("Caja de ahorro creada!");
					} else {
					//Llamar al constructor de cuenta corriente
						labelResultado.setText("Cuenta corriente creada!");
					}
					textDNI_CUIT.setText("");
					textNombre_razonSocial.setText("");
					VistaAltaCuenta.getInstancia().setVisible(false);
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("No se pudo guardar el registro de cuenta");
				}
			}
			
		});		
	}
}
