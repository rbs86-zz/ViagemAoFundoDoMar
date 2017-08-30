package exercicio.command;

public class TurnRightCommand implements Command{
	
	private CommandReceiver commandReceiver;
	
	public TurnRightCommand(CommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	@Override
	public void execute() {
		this.commandReceiver.turnRight();
	}

}
