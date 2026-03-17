package me.akranium.ruleapplier.rule.impl;

import me.akranium.data.Dialogue;
import me.akranium.data.DialogueCategory;
import me.akranium.ruleapplier.rule.Rule;

public class CategorizerRule implements Rule {
    @Override
    public void apply(Dialogue dialogue) {
        if(hasVariable(dialogue)) {
            dialogue.setCategory(DialogueCategory.VARIABLE);
        } else {
            dialogue.setCategory(DialogueCategory.NO_VARIABLE);
        }
    }

    public boolean hasVariable(Dialogue dialogue) {
        return java.util.regex.Pattern.compile("~[0-9]")
                .matcher(dialogue.getString())
                .find();
    }
}
