package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;
import me.akranium.data.Dialogue;

import java.util.List;

public class FindVariableCommand implements Command {

    private final ApplicationService appService;

    public FindVariableCommand(ApplicationService appService) {
        this.appService = appService;
    }

    @Override
    public String name() {
        return "find variable";
    }

    @Override
    public String description() {
        return "Finds texts with variable and displays them.";
    }

    @Override
    public void execute(String[] args) {
        List<Dialogue> dialogues = appService.findVariableDialogues();

        if(dialogues.isEmpty()) {
            System.out.println("No text with variables found.");
            return;
        }
        System.out.println("Texts that have variables:");
        for(Dialogue dialogue : dialogues) {
            System.out.println("ID: " + dialogue.getStableKey() + ", Text: " + dialogue.getString());
        }
    }
}
