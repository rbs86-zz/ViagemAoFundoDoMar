package exercicio.command;

import exercicio.entity.Movement;
import exercicio.exception.IllegalMovement;

public class Commands {
	
	private Commands(){
		
	}

	public static Command get(Movement movement, CommandReceiver commandReceiver) {
		switch (movement) {
		case M:
			return new MoveCommand(commandReceiver);
		case L:
			return new TurnLeftCommand(commandReceiver);
		case R:
			return new TurnRightCommand(commandReceiver);
		case D:
			return new DownCommand(commandReceiver);
		case U:
			return new UpCommand(commandReceiver);
		default:
			throw new IllegalMovement("Movimento não permitido.");
		}
	}

}
