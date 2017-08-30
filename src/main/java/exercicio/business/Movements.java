package exercicio.business;

import java.util.Iterator;
import java.util.List;

import exercicio.entity.Direcao;
import exercicio.entity.Movement;
import exercicio.entity.Submarino;

public class Movements implements MovementsIterator {

	private Iterator<Movement> movements;
	private Submarino submarino;

	public Movements(List<Movement> movementList, Submarino submarino) {
		this.movements = movementList.iterator();
		this.setSubmarino(submarino);
	}

	@Override
	public void next() {
		Movement movement = movements.next();
		switch (movement) {
		case M:
			move();
			break;
		case L:
			turnLeft();
			break;
		case R:
			turnRight();
			break;
		case D:
			down();
			break;
		case U:
			up();
			break;
		default:
			break;
		}
	}

	private void up() {
		getSubmarino().getCoordenadas().setZ(getSubmarino().getCoordenadas().getZ() + 1);
	}

	private void down() {
		getSubmarino().getCoordenadas().setZ(getSubmarino().getCoordenadas().getZ() - 1);
	}

	private void turnLeft() {
		if (Direcao.NORTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.OESTE);
		} else if (Direcao.LESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.NORTE);
		} else if (Direcao.SUL.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.LESTE);
		} else if (Direcao.OESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.SUL);
		}
	}

	private void turnRight() {
		if (Direcao.NORTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.LESTE);
		} else if (Direcao.LESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.SUL);
		} else if (Direcao.SUL.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.OESTE);
		} else if (Direcao.OESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().setDirecao(Direcao.NORTE);
		}
	}

	private void move() {
		if (Direcao.NORTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().getCoordenadas().setY(getSubmarino().getCoordenadas().getY() + 1);
		} else if (Direcao.LESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().getCoordenadas().setX(getSubmarino().getCoordenadas().getX() + 1);
		} else if (Direcao.SUL.equals(getSubmarino().getDirecao())) {
			getSubmarino().getCoordenadas().setY(getSubmarino().getCoordenadas().getY() - 1);
		} else if (Direcao.OESTE.equals(getSubmarino().getDirecao())) {
			getSubmarino().getCoordenadas().setX(getSubmarino().getCoordenadas().getX() - 1);
		}
	}

	@Override
	public boolean isDone() {
		return !this.movements.hasNext();
	}

	public Submarino getSubmarino() {
		return submarino;
	}

	public void setSubmarino(Submarino submarino) {
		this.submarino = submarino;
	}

}
