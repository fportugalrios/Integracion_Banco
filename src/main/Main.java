package main;
import server.Server;

public class Main {

	public static void main(String[] args) {
		Server.getInstancia();
		
		/*System.out.println("Ganadores\n");*/
		/*List<ResultadoView> ganadores = Controlador.getInstancia().ganadores();
		for(ResultadoView rv : ganadores)
			System.out.println(rv.toString());
			*/
		
		/*System.out.println("Misma Marca\n");
		List<AutoView> mismaMarca = Controlador.getInstancia().mismaMarca();
		for(AutoView av : mismaMarca)
			System.out.println(av.toString());
		
		System.out.println("Posiciones por Auto\n");
		List<String[]> posicionesAutos = Controlador.getInstancia().posicionesAutos();
		for(String[] pa : posicionesAutos)
			System.out.println(pa[0] + " escuderia: " + pa[1] + " : " + pa[2]);
		
		System.out.println("Posiciones por escuderia\n");
		List<String[]> posicionesEscuderias = Controlador.getInstancia().posicionesEscuderias();
		for(String[] pe : posicionesEscuderias)
			System.out.println(pe[0] + " - " + pe[1]);
			*/
	}

}
