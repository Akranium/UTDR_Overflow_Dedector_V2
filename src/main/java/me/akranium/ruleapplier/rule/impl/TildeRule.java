package me.akranium.ruleapplier.rule.impl;

import me.akranium.data.Dialogue;
import me.akranium.data.DialogueCategory;
import me.akranium.ruleapplier.rule.Rule;

import java.util.regex.Pattern;

public class TildeRule implements Rule {
    private static final Pattern PATTERN =
            Pattern.compile("~");

    @Override
    public void apply(Dialogue dialogue) {
        if(dialogue.getCategory() != DialogueCategory.VARIABLE) {
            String oldString = dialogue.getString();
            String newString = PATTERN.matcher(oldString).replaceAll("");
            dialogue.setString(newString);
        }
    }
}
