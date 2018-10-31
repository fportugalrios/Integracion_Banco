package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Cuenta;
import bean.Movimiento;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class VistaDepositar extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDNI_CUIT;
	private JPanel contentPane;
	private JTextField textFieldMonto;
	
	public VistaDepositar() {
		
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Consultar movimientos");
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
		
		JLabel lblSaldosDeCuenta = new JLabel("Seleccione una cuenta:");
		lblSaldosDeCuenta.setBounds(24, 67, 161, 16);
		getContentPane().add(lblSaldosDeCuenta);
		lblSaldosDeCuenta.setVisible(false);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(24, 296, 161, 18);
		contentPane.add(labelResultado);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxCuentas = new JComboBox();
		comboBoxCuentas.setBounds(24, 95, 130, 27);
		contentPane.add(comboBoxCuentas);
		comboBoxCuentas.setVisible(false);
		
		JLabel lblIngreseElMonto = new JLabel("Ingrese el monto a depositar:");
		lblIngreseElMonto.setBounds(24, 170, 235, 16);
		contentPane.add(lblIngreseElMonto);
		lblIngreseElMonto.setVisible(false);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setBounds(24, 215, 130, 26);
		contentPane.add(textFieldMonto);
		textFieldMonto.setColumns(10);
		textFieldMonto.setVisible(false);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(198, 215, 117, 29);
		contentPane.add(btnDepositar);
		btnDepositar.setVisible(false);
		
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(comboBoxCuentas.getItemCount()!=0 && textFieldMonto.equals("")) {
						textFieldMonto.setVisible(true);
						//VER!!!
						depositar(comboBoxCuentas.getSelectedItem().toString(),textFieldMonto.getText());
						labelResultado.setText("Deposito oK");
					} else {
						labelResultado.setText("Error en listado de cuentas o monto");
					}
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("Error al depositar");
				}
			}
		});
		
		
        btnBuscar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				try{
					Cliente c = buscarCliente(textFieldDNI_CUIT.getText());
					if (c!=null) {
						lblSaldosDeCuenta.setVisible(true);
						lblIngreseElMonto.setVisible(true);
						comboBoxCuentas.setVisible(true);
						btnDepositar.setVisible(true);
						ArrayList<Cuenta> cuentasAux = c.getCuentas();
						for (int i=0; i<cuentasAux.size(); i++) {
							Cuenta cta = cuentasAux.get(i);
							comboBoxCuentas.addItem(cta.getNumero());
						}
						labelResultado.setText("Cliente encontrado");
					} else {
						labelResultado.setText("El cliente no existe");
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
