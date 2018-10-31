package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Cuenta;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class VistaConsultarCBU extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDNI_CUIT;
	private JPanel contentPane;
	
	public VistaConsultarCBU() {
		
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Consultar CBU");
		setBounds(100, 100, 450, 350);
		
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDnicuit = new JLabel("DNI/CUIT");
		lblDnicuit.setBounds(24, 21, 61, 16);
		getContentPane().add(lblDnicuit);
		
		textFieldDNI_CUIT = new JTextField();
		textFieldDNI_CUIT.setBounds(129, 16, 130, 26);
		getContentPane().add(textFieldDNI_CUIT);
		textFieldDNI_CUIT.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(286, 16, 117, 29);
		getContentPane().add(btnBuscar);
		
		JLabel lblSaldosDeCuenta = new JLabel("CBU");
		lblSaldosDeCuenta.setBounds(24, 67, 130, 16);
		getContentPane().add(lblSaldosDeCuenta);
		
		JTextArea textAreaCBU = new JTextArea();
		textAreaCBU.setBounds(24, 95, 406, 157);
		getContentPane().add(textAreaCBU);
		textAreaCBU.setEnabled(false);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(24, 277, 161, 18);
		contentPane.add(labelResultado);
		
        btnBuscar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				try{
					Cliente c = buscarCliente(textFieldDNI_CUIT.getText());
					if (c!=null) {
						ArrayList<Cuenta> cuentasAux = c.getCuentas();
						for (int i=0; i<cuentasAux.size(); i++) {
							Cuenta cta = cuentasAux.get(i);
							String cadenaCBU = "Cuenta nro: " + cta.getNumero() + " - " + "Saldo: " + cta.getCBU();
							textAreaCBU.setText(cadenaCBU);
							textAreaCBU.setText("\n");
						}
					} else {
						labelResultado.setText("El client no existe");
					}
					
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("Error al buscar el cliente");
				}
			}
			
		});
	}

}
