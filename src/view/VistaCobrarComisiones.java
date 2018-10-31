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

public class VistaCobrarComisiones extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public VistaCobrarComisiones() {
		
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Cobro de comisiones");
		setBounds(100, 100, 450, 200);
		
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Presione el boton ejecutar para iniciar el proceso");
		lblMensaje.setBounds(87, 64, 337, 16);
		getContentPane().add(lblMensaje);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(24, 296, 161, 18);
		contentPane.add(labelResultado);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(171, 105, 117, 29);
		contentPane.add(btnEjecutar);
		
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					CuentaController.debitarMantenimiento();
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					labelResultado.setText("Error al debitar el mantenimiento en cuentas");
				}
			}
		});
		
	}
}