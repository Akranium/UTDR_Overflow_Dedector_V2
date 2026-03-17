package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;
import me.akranium.util.exception.InvalidUserInputException;

public class UpdateCommand implements Command {

    private final ApplicationService appService;

    public UpdateCommand(ApplicationService appService) {
        this.appService = appService;
    }

    @Override
    public String name() {
        return "update";
    }

    @Override
    public String description() {
        return "Updates the maximum character and maximum line amount of a text. Usage:\n" +
                "update [ID] [max char] [max line]";
    }

    @Override
    public void execute(String[] args) throws Exception {
        try {
            appService.updateDialogueLimits(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } catch(NumberFormatException e) {
            throw new InvalidUserInputException("Arguments must be integers.");
        }
        System.out.println("Values successfully updated.");
    }
}
