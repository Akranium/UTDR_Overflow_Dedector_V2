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
            String stableKey = args[0];
            int maxChars = Integer.parseInt(args[1]);
            int maxLines = Integer.parseInt(args[2]);
            appService.updateDialogueLimits(stableKey, maxChars, maxLines);
        } catch(NumberFormatException e) {
            throw new InvalidUserInputException("Arguments must be integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidUserInputException("Insufficient number of arguments.");
        }
        System.out.println("Values successfully updated.");
    }
}
