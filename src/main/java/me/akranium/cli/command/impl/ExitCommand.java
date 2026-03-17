package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;

public class ExitCommand implements Command {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String description() {
        return "Exits the program";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Closing the program...");
        System.exit(0);
    }
}
