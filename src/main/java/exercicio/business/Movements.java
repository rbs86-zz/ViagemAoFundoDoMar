package exercicio.business;

import java.util.Iterator;
import java.util.List;

import exercicio.command.Command;
import exercicio.command.CommandReceiver;
import exercicio.command.Commands;
import exercicio.entity.Movement;
import exercicio.entity.Submarino;

public class Movements implements MovementsIterator {

	private Iterator<Movement> movements;
	private Submarino submarino;
	private CommandReceiver commandReceiver;

	public Movements(List<Movement> movementList, Submarino submarino) {
		this.movements = movementList.iterator();
		this.submarino = submarino;
		this.commandReceiver = new CommandReceiver(this.submarino);
	}

	@Override
	public void next() {
		Movement movement = movements.next();
		Command command = Commands.get(movement, this.commandReceiver);
		command.execute();
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
