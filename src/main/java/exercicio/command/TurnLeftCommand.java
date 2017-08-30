package exercicio.command;

public class TurnLeftCommand implements Command{
	
	private CommandReceiver commandReceiver;
	
	public TurnLeftCommand(CommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	@Override
	public void execute() {
		this.commandReceiver.turnLeft();
	}

}
