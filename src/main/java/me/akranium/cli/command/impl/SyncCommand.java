package me.akranium.cli.command.impl;

import me.akranium.app.ApplicationService;
import me.akranium.cli.command.Command;

public class SyncCommand implements Command {

    private final ApplicationService appService;

    public SyncCommand(ApplicationService appService) {
        this.appService = appService;
    }

    @Override
    public String name() {
        return "sync";
    }

    @Override
    public String description() {
        return "Updates metadata JSON so that every new element in the raw JSON is added and every update to the existing strings are reflected";
    }

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Syncing...");
        appService.sync();
        System.out.println("Syncing complete.");
    }
}

