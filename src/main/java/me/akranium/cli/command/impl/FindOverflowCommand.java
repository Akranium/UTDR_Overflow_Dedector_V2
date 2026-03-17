package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;
import me.akranium.data.Dialogue;

import java.util.List;

public class FindOverflowCommand implements Command {
    private final ApplicationService appService;

    public FindOverflowCommand(ApplicationService appService) {
        this.appService = appService;
    }

    @Override
    public String name() {
        return "find overflow";
    }

    @Override
    public String description() {
        return "Finds overflowing texts and displays them.";
    }

    @Override
    public void execute(String[] args) {
        List<Dialogue> dialogues = appService.findOverflowDialogues();
        if(dialogues.isEmpty()) {
            System.out.println("No overflowing text found.");
            return;
        }
        System.out.println("Overflowing texts:");
        for(Dialogue dialogue : dialogues) {
            System.out.println("ID: " + dialogue.getStableKey() + ", Text: " + dialogue.getString());
        }
    }
}
