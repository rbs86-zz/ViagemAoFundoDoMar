package exercicio.business;

import java.util.ArrayList;
import java.util.List;

import exercicio.entity.Movement;
import exercicio.entity.Submarino;

public class Controlador {

	private Submarino submarino;
	private List<Movement> movementList;

	public Controlador(Submarino submarino) {
		this.movementList = new ArrayList<>();
		this.setSubmarino(submarino);
	}

	public void executeMovements() {
		Movements movements = new Movements(movementList, submarino);
		while (!movements.isDone()) {
			movements.next();
		}
	}

	public void addMovements(List<Movement> movements) {
		this.movementList.addAll(movements);
	}

	public String recuperarCoordenadasSubmarino() {
		return submarino.getCoordenadas().toString() + " " + submarino.getDirecao();
	}

	public Submarino getSubmarino() {
		return submarino;
	}

	public void setSubmarino(Submarino submarino) {
		this.submarino = submarino;
	}

}
