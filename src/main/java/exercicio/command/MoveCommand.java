package exercicio.command;

public class MoveCommand implements Command{
	
	private CommandReceiver commandReceiver;
	
	public MoveCommand(CommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	@Override
	public void execute() {
		this.commandReceiver.move();
	}

}
