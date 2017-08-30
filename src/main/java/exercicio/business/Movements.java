package exercicio.business;

import java.util.Iterator;
import java.util.List;

import exercicio.command.Command;
import exercicio.command.CommandReceiver;
import exercicio.command.Commands;
import exercicio.entity.Movement;
import exercicio.entity.Submarino;

public class Movements implements MovementsIterator {

	private Iterator<Movement> movementsIterator;
	private Submarino submarino;
	private CommandReceiver commandReceiver;

	public Movements(List<Movement> movementList, Submarino submarino) {
		this.movementsIterator = movementList.iterator();
		this.submarino = submarino;
		this.commandReceiver = new CommandReceiver(this.submarino);
	}

	@Override
	public void next() {
		Movement movement = movementsIterator.next();
		Command command = Commands.get(movement, this.commandReceiver);
		command.execute();
	}

	@Override
	public boolean isDone() {
		return !this.movementsIterator.hasNext();
	}

	public Submarino getSubmarino() {
		return submarino;
	}

	public void setSubmarino(Submarino submarino) {
		this.submarino = submarino;
	}

}
