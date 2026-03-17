package me.akranium.ruleapplier;

import me.akranium.data.Dialogue;
import me.akranium.ruleapplier.rule.Rule;
import me.akranium.ruleapplier.rule.impl.*;

import java.util.ArrayList;
import java.util.List;

public class RuleApplier {
    private List<Rule> rules;
    public RuleApplier() {
        rules = new ArrayList<>();
        rules.add(new CategorizerRule());
        rules.add(new TextDelayRule());
        rules.add(new StarterAsteriskRule());
        rules.add(new OneCharFormatsRule());
        rules.add(new BackslashAndNextTwoCharsRule());
        rules.add(new TabsRule());
        rules.add(new TildeRule());
        rules.add(new NewlineAmpersandRule());

    }

    public void applyRules(Dialogue dialogue) {
        for(Rule rule : rules) {
            rule.apply(dialogue);
        }
    }
}


