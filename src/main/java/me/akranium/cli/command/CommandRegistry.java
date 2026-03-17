package me.akranium.cli.command;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.impl.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private final Map<String, Command> commands;

    public CommandRegistry(ApplicationService appService) {
        this.commands = new HashMap<>();
        commands.put("help", new HelpCommand(this));
        commands.put("exit", new ExitCommand());
        commands.put("sync", new SyncCommand(appService));
        commands.put("update", new UpdateCommand(appService));
        commands.put("findoverflow", new FindOverflowCommand(appService));
        commands.put("findvariable", new FindVariableCommand(appService));
    }

    public Command get(String name) {
        return commands.get(name);
    }

    public Map<String, Command> readOnlyAllCommands() {
        return Collections.unmodifiableMap(commands);
    }

}
