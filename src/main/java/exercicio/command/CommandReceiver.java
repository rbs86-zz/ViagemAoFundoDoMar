package exercicio.command;

import exercicio.entity.Direcao;
import exercicio.entity.Submarino;

public class CommandReceiver {

	private Submarino submarino;

	public CommandReceiver(Submarino submarino) {
		this.submarino = submarino;
	}

	void up() {
		submarino.getCoordenadas().setZ(submarino.getCoordenadas().getZ() + 1);
	}

	void down() {
		submarino.getCoordenadas().setZ(submarino.getCoordenadas().getZ() - 1);
	}

	void turnLeft() {
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

	void turnRight() {
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

	void move() {
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

}
