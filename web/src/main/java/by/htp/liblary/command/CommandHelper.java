package by.htp.liblary.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.liblary.command.impl.*;

public final class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandHelper() {
		commands.put(CommandName.LOGIN, new LoginCommand());
		commands.put(CommandName.REGISTER_USER, new RegisterUserCommand());
		commands.put(CommandName.ADD_BOOK, new AddBookCommand());
		commands.put(CommandName.SHOW_CATALOG, new ShowCatalogCommand());
		commands.put(CommandName.CONFIGURATION, new TakeLocalizationPage());
		commands.put(CommandName.EN, new ChangeLocalization());
		commands.put(CommandName.RU, new ChangeLocalization());
		commands.put(CommandName.EXIT, new Exit());
		commands.put(CommandName.CREATE_USER, new TakeRegisterPage());
		commands.put(CommandName.BACK, new BackCommand());
		commands.put(CommandName.SHOW_USERS, new ShowUsersInformation());
		commands.put(CommandName.CHANGE_INTERVAL,new ChangeInterval());
		commands.put(CommandName.ADD_POSITION,new AddPosition());
		commands.put(CommandName.BACK_POSITION,new BackPosition());

	}

	public Command getCommand(String commandName) {
		Command command = null;
		CommandName key = null;

		commandName = commandName.replace('-', '_').toUpperCase();
		key = CommandName.valueOf(commandName);

		command = commands.get(key);

		if (command == null) {
			command = new UnknownCommand();
		}

		return command;
	}

}
