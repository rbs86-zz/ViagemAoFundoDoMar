package exercicio;

import java.util.Scanner;

import exercicio.business.Controlador;
import exercicio.entity.Submarino;

public class OceanTrip {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String movimentos = in.nextLine();

		Controlador controlador = new Controlador(new Submarino());
		controlador.addMovements(movimentos);
		controlador.executeMovements();
		System.out.println(controlador.recuperarCoordenadasSubmarino());
	}

}
