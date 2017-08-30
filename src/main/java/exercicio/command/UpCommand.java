package exercicio.command;

public class UpCommand implements Command{
	
	private CommandReceiver commandReceiver;
	
	public UpCommand(CommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	@Override
	public void execute() {
		this.commandReceiver.up();
	}

}
