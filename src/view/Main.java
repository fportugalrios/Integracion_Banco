package view;

import javax.swing.JFrame;

public class Main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
			Main inst = new Main();
			inst.setVisible(true);
	}
		
	public Main(){
		initGUI();
	}
		
	private void initGUI(){
		try{
			MenuPrincipal.getInstancia().setVisible(true);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}