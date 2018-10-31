package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static private MenuPrincipal instancia;
	private JPanel contentPane;
	
	static public MenuPrincipal getInstancia(){
		if (instancia == null)
			instancia = new MenuPrincipal();
		return instancia;
	}
	
	private MenuPrincipal() {
		setTitle("Bienvenido a Yote Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltaCliente = new JMenuItem("Crear cliente");
		mntmAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAltaCliente vmu = new VistaAltaCliente();
				vmu.setVisible(true);
			}
		});
		mnClientes.add(mntmAltaCliente);
		
		JMenuItem mntmModificarCliente = new JMenuItem("Modificar cliente");
		mntmModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaModificarCliente vmu = new VistaModificarCliente();
				vmu.setVisible(true);
			}
		});
		mnClientes.add(mntmModificarCliente);
		
		JMenuItem mntmBajaCliente = new JMenuItem("Borrar cliente ");
		mntmBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaBajaCliente vmu = new VistaBajaCliente();
				vmu.setVisible(true);
			}
		});
		mnClientes.add(mntmBajaCliente);
				
		JMenu mnCuentas = new JMenu("Cuentas");
		menuBar.add(mnCuentas);
		
		JMenuItem mntmAltaCuenta = new JMenuItem("Crear cuenta");
		mnCuentas.add(mntmAltaCuenta);
		mntmAltaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAltaCuenta vmu = new VistaAltaCuenta();
				vmu.setVisible(true);
			}
		});
		mnCuentas.add(mntmAltaCuenta);
		
		JMenuItem mntmBajaCuenta = new JMenuItem("Borrar cuenta");
		mnCuentas.add(mntmBajaCuenta);
		mntmBajaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaBajaCuenta vmu = new VistaBajaCuenta();
				vmu.setVisible(true);
			}
		});
		mnCuentas.add(mntmBajaCuenta);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmConsultarSaldo = new JMenuItem("Consultar saldo");
		mntmConsultarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaConsultaSaldo vmu = new VistaConsultaSaldo();
				vmu.setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarSaldo);
		
		JMenuItem mntmConsultarCBU = new JMenuItem("Consultar CBU");
		mntmConsultarCBU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaConsultarCBU vmu = new VistaConsultarCBU();
				vmu.setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarCBU);
		
		JMenuItem mntmConsultarResumen = new JMenuItem("Consultar resumen");
		mntmConsultarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaConsultarResumen vmu = new VistaConsultarResumen();
				vmu.setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarResumen);
		
		JMenu mnMovimientos = new JMenu("Movimientos");
		menuBar.add(mnMovimientos);
		
		JMenuItem mntmDepositar = new JMenuItem("Depositar");
		mnMovimientos.add(mntmDepositar);
		mntmDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaDepositar vmu = new VistaDepositar();
				vmu.setVisible(true);
			}
		});
		mnMovimientos.add(mntmDepositar);
		
		JMenuItem mntmExtraer = new JMenuItem("Extraer");
		mnMovimientos.add(mntmExtraer);
		mntmExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaExtraer vmu = new VistaExtraer();
				vmu.setVisible(true);
			}
		});
		mnMovimientos.add(mntmExtraer);
		
		JMenuItem mntmCobrarComisiones = new JMenuItem("Cobrar comisiones");
		mnMovimientos.add(mntmCobrarComisiones);
		mntmCobrarComisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaCobrarComisiones vmu = new VistaCobrarComisiones();
				vmu.setVisible(true);
			}
		});
		mnMovimientos.add(mntmCobrarComisiones);
	}
	
}
