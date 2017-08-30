package exercicio.command;

import org.apache.commons.lang3.ArrayUtils;

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
		Direcao[] direcoes = Direcao.values();
		int direcaoCorrente = ArrayUtils.indexOf(direcoes, submarino.getDirecao());
		Direcao novaDirecao = direcoes[(direcaoCorrente + direcoes.length - 1) % direcoes.length];
		submarino.setDirecao(novaDirecao);
	}

	void turnRight() {
		Direcao[] direcoes = Direcao.values();
		int direcaoCorrente = ArrayUtils.indexOf(direcoes, submarino.getDirecao());
		Direcao novaDirecao = direcoes[(direcaoCorrente + direcoes.length + 1) % direcoes.length];
		submarino.setDirecao(novaDirecao);
	}

	void move() {
		int x = submarino.getCoordenadas().getX();
		int y = submarino.getCoordenadas().getY();

		if (Direcao.NORTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setY(++y);
		} else if (Direcao.LESTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setX(++x);
		} else if (Direcao.SUL.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setY(--y);
		} else if (Direcao.OESTE.equals(submarino.getDirecao())) {
			submarino.getCoordenadas().setX(--x);
		}
	}

}
