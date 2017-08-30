package exercicio.business;

import java.util.Iterator;
import java.util.List;

import exercicio.command.Command;
import exercicio.command.CommandReceiver;
import exercicio.command.DownCommand;
import exercicio.command.MoveCommand;
import exercicio.command.TurnLeftCommand;
import exercicio.command.TurnRightCommand;
import exercicio.command.UpCommand;
import exercicio.entity.Direcao;
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
		switch (movement) {
		case M:
			Command moveCommand = new MoveCommand(commandReceiver);
			moveCommand.execute();
			break;
		case L:
			Command leftCommand = new TurnLeftCommand(commandReceiver);
			leftCommand.execute();
			break;
		case R:
			Command rightCommand = new TurnRightCommand(commandReceiver);
			rightCommand.execute();
			break;
		case D:
			Command downCommand = new DownCommand(commandReceiver);
			downCommand.execute();
			break;
		case U:
			Command upCommand = new UpCommand(commandReceiver);
			upCommand.execute();
			break;
		default:
			break;
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
