package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;
import me.akranium.util.Constants;
import me.akranium.util.exception.InvalidUserInputException;

public class CheckLineCommand implements Command {

    private final ApplicationService appService;

    public CheckLineCommand(ApplicationService appService) {
        this.appService = appService;
    }

    @Override
    public String name() {
        return "check line";
    }

    @Override
    public String description() {
        return "Checks if a single line overflows. \n" +
                "Usage: checkline [text] [max char] [max line] \n" +
                "NOTE: Place (/\") at the beginning and the end of your text to mark it as the text " +
                "instead of the arguments of the command.";
    }

    @Override
    public void execute(String[] args) throws Exception {
        try {
            String line = args[0];
            int maxChars;
            int maxLines;

            if(args.length < 3) {
                maxLines = Constants.DEFAULT_MAX_LINES;
            } else {
                maxLines = Integer.parseInt(args[2]);
            }

            if(args.length < 2) {
                maxChars = Constants.DEFAULT_MAX_CHARS;
            } else {
                maxChars = Integer.parseInt(args[1]);
            }
            if(appService.checkLine(line, maxChars, maxLines)) {
                System.out.println("This line overflows.");
            } else {
                System.out.println("This line does not overflow.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException("Arguments must be integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidUserInputException("Insufficient number of arguments.");
        }
    }
}
