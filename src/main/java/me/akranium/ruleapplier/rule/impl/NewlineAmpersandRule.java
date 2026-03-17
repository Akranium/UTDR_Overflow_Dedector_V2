package me.akranium.ruleapplier.rule.impl;

import me.akranium.data.Dialogue;
import me.akranium.ruleapplier.rule.Rule;

import java.util.regex.Pattern;

public class NewlineAmpersandRule implements Rule {
    private static final Pattern PATTERN =
            Pattern.compile("\\n");
    @Override
    public void apply(Dialogue dialogue) {
        String oldString = dialogue.getString();
        String newString = PATTERN.matcher(oldString).replaceAll("&");
        dialogue.setString(newString);
    }
}
