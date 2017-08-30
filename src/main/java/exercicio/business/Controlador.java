package exercicio.business;

import exercicio.entity.Direcao;
import exercicio.entity.Submarino;

public class Controlador {

	private Submarino submarino;

	public Controlador(Submarino submarino) {
		this.setSubmarino(submarino);
	}

	public void executeMovements(String movement) {
		switch (movement) {
		case "M":
			move();
			break;
		case "L":
			turnLeft();
			break;
		case "R":
			turnRight();
			break;
		case "D":
			down();
			break;
		case "U":
			up();
			break;
		default:
			break;
		}
	}

	private void up() {
		submarino.getCoordenadas().setZ(submarino.getCoordenadas().getZ() + 1);
	}

	private void down() {
		submarino.getCoordenadas().setZ(submarino.getCoordenadas().getZ() - 1);
	}

	private void turnLeft() {
		if (Direcao.NORTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.OESTE);
		} else if (Direcao.LESTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.NORTE);
		} else if (Direcao.SUL.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.LESTE);
		} else if (Direcao.OESTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.SUL);
		}
	}

	private void turnRight() {
		if (Direcao.NORTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.LESTE);
		} else if (Direcao.LESTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.SUL);
		} else if (Direcao.SUL.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.OESTE);
		} else if (Direcao.OESTE.equals(submarino.getDirecao())) {
			submarino.setDirecao(Direcao.NORTE);
		}
	}

	private void move() {
		if (Direcao.NORTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setY(submarino.getCoordenadas().getY() + 1);
		} else if (Direcao.LESTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setX(submarino.getCoordenadas().getX() + 1);
		} else if (Direcao.SUL.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setY(submarino.getCoordenadas().getY() - 1);
		} else if (Direcao.OESTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setX(submarino.getCoordenadas().getX() - 1);
		}
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
