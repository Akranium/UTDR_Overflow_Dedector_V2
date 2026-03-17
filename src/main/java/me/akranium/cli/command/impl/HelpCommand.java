package me.akranium.cli.command.impl;

import me.akranium.cli.command.Command;
import me.akranium.cli.command.CommandRegistry;

import java.util.Map;

public class HelpCommand implements Command {
    private final CommandRegistry registry;

    public HelpCommand(CommandRegistry registry) {
        this.registry = registry;
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String description() {
        return "Shows all the available commands along with their descriptions.";
    }

    @Override
    public void execute(String[] args) {
        Map<String,Command> commandMap = registry.readOnlyAllCommands();
        commandMap.forEach((string,command) -> {
            System.out.println(string + ": " + command.description());
        });
    }
}
