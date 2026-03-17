package me.akranium.cli;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;
import me.akranium.cli.command.CommandRegistry;
import me.akranium.util.exception.InvalidUserInputException;

import java.util.Arrays;
import java.util.Scanner;

public class CommandLineInterface {

    private final Scanner scanner;
    private final CommandRegistry registry;
    private final ApplicationService appService;

    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
        this.appService = new ApplicationService();
        this.registry = new CommandRegistry(appService);

    }

    public void start() {
        try {
            appService.initialize();
        } catch (Exception e) {
            handleErrors(e);
        }

        while (true) {
            try {
                System.out.print("> ");
                String input = scanner.nextLine();
                runCommands(input);
            } catch (Exception e) {
                handleErrors(e);
            }
        }
    }

    private void runCommands(String input) throws Exception {
        if (input.isBlank()) return;
        String[] parts = input.trim().split("\\s+");

        String commandName = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command command = registry.get(commandName);

        if (command == null) {
            System.out.println("Unknown command. Type 'help'.");
            return;
        }
        command.execute(args);
    }

    private void handleErrors(Exception e) {
        if(e instanceof InvalidUserInputException) {
            System.out.println(e.getMessage());
        } else {
            System.err.println("=================================");
            System.err.println("FATAL ERROR");
            System.err.println(e.getMessage());
            System.err.println("=================================");
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}

