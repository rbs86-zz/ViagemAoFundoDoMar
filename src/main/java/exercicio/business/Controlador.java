package exercicio.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exercicio.entity.Movement;
import exercicio.entity.Submarino;

public class Controlador {

	private Submarino submarino;
	private List<Movement> movementList;

	public Controlador(Submarino submarino) {
		this.movementList = new ArrayList<>();
		this.submarino = submarino;
	}

	public void executeMovements() {
		Movements movements = new Movements(movementList, submarino);
		while (!movements.isDone()) {
			movements.next();
		}
	}

	public void addMovements(String movs) {
		this.movementList.addAll(Arrays.stream(movs.split("")).map(Movement::valueOf).collect(Collectors.toList()));
	}

	public String recuperarCoordenadasSubmarino() {
		return submarino.getCoordenadas().toString() + " " + submarino.getDirecao();
	}

}
