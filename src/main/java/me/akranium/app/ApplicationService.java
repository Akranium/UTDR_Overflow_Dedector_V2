package me.akranium.app;

import me.akranium.util.Methods;
import me.akranium.data.Dialogue;
import me.akranium.data.DialogueCategory;
import me.akranium.json.JsonService;
import me.akranium.overflowchecker.OverflowChecker;
import me.akranium.ruleapplier.RuleApplier;
import me.akranium.util.exception.InvalidUserInputException;

import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    private List<Dialogue> dialogueState;

    private final JsonService jsonService;
    private final RuleApplier ruleApplier;
    private final OverflowChecker overflowChecker;

    public ApplicationService() {
        this.jsonService = new JsonService();
        this.ruleApplier = new RuleApplier();
        this.overflowChecker = new OverflowChecker();
        this.dialogueState = new ArrayList<>();
    }

    public void initialize() throws Exception {
        jsonService.initializeFiles();
        dialogueState = jsonService.processJsons();
    }

    public void sync() throws Exception {
        dialogueState = jsonService.processJsons();
    }

    public List<Dialogue> findOverflowDialogues() {
        List<Dialogue> overflowDialogues = new ArrayList<>();

        List<Dialogue> cleanedDialogueState = getCleanedDialogueState();

        for(Dialogue dialogue : cleanedDialogueState) {
            if(overflowChecker.hasOverflow(dialogue)) {
                overflowDialogues.add(dialogue);
            }
        }
        return overflowDialogues;
    }

    public List<Dialogue> findVariableDialogues() {
        List<Dialogue> variableDialogues = new ArrayList<>();

        List<Dialogue> cleanedDialogueState = getCleanedDialogueState();

        for(Dialogue dialogue : cleanedDialogueState) {
            if(dialogue.getCategory() == DialogueCategory.VARIABLE) {
                variableDialogues.add(dialogue);
            }
        }
        return variableDialogues;
    }

    public void updateDialogueLimits(String stableKey, int maxChars, int maxLines) throws Exception {
        if(maxChars < 0 || maxLines < 0) {
            throw new InvalidUserInputException("Max char and max line values must be bigger than 0.");
        }
        for(Dialogue dialogue : dialogueState) {
            if(dialogue.getStableKey().equals(stableKey)) {
                dialogue.setMaxChars(maxChars);
                dialogue.setMaxLines(maxLines);
                jsonService.saveMetadataDialogues(dialogueState);
                return;
            }
        }
        throw new InvalidUserInputException("No dialogue with this stable key exist.");
    }

    private List<Dialogue> getCleanedDialogueState() {
        List<Dialogue> ruleAppliedDialogues = Methods.deepCopy(dialogueState);
        for(Dialogue dialogue : ruleAppliedDialogues) {
            ruleApplier.applyRules(dialogue);
        }
        return ruleAppliedDialogues;
    }
}

