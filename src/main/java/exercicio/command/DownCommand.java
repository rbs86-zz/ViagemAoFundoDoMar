package exercicio.command;

public class DownCommand implements Command{
	
	private CommandReceiver commandReceiver;
	
	public DownCommand(CommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	@Override
	public void execute() {
		this.commandReceiver.down();
	}

}
