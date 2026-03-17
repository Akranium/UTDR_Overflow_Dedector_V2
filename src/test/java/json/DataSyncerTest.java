package json;

import me.akranium.data.Dialogue;
import me.akranium.json.DataSyncer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataSyncerTest {
    DataSyncer dataSyncer;
    List<Dialogue> dialogues;

    @BeforeEach
    void beforeEach() {
        dataSyncer = new DataSyncer();
        dialogues = new ArrayList<>();
    }

    @Test
    void generatingStableKeysWork() {
        dialogues = new ArrayList<>();
        Dialogue dialogueA0 = new Dialogue("A","",10,2);
        Dialogue dialogueA1 = new Dialogue("A","",10,2);
        Dialogue dialogueA2 = new Dialogue("A","",10,2);
        Dialogue dialogueB0 = new Dialogue("B","",10,2);
        Dialogue dialogueB1 = new Dialogue("B","",10,2);
        Dialogue dialogueB2 = new Dialogue("B","",10,2);
        Dialogue dialogueC0 = new Dialogue("C","",10,2);
        Dialogue dialogueD0 = new Dialogue("D","",10,2);
        Dialogue dialogueE0 = new Dialogue("E","",10,2);

        dialogues.add(dialogueA0);
        dialogues.add(dialogueC0);
        dialogues.add(dialogueB0);
        dialogues.add(dialogueB1);
        dialogues.add(dialogueD0);
        dialogues.add(dialogueA1);
        dialogues.add(dialogueE0);
        dialogues.add(dialogueA2);
        dialogues.add(dialogueB2);

        dataSyncer.generateStableKeys(dialogues);

        assertEquals("A#0",dialogueA0.getStableKey());
        assertEquals("A#1",dialogueA1.getStableKey());
        assertEquals("A#2",dialogueA2.getStableKey());
        assertEquals("B#0",dialogueB0.getStableKey());
        assertEquals("B#1",dialogueB1.getStableKey());
        assertEquals("B#2",dialogueB2.getStableKey());
        assertEquals("C#0",dialogueC0.getStableKey());
        assertEquals("D#0",dialogueD0.getStableKey());
        assertEquals("E#0",dialogueE0.getStableKey());
    }

    @Test
    void generatingStableKeysWithEmptyDialogue() {
        dataSyncer.generateStableKeys(dialogues);
    }

    @Test
    void generatingSyncedDialogueListWorks() {
        List<Dialogue> rawDialogue = new ArrayList<>();
        List<Dialogue> existingDialogue = new ArrayList<>();

        Dialogue newDialogue1 = new Dialogue("new1","New Dialogue 1",10,2);
        Dialogue newDialogue2 = new Dialogue("new2","New Dialogue 2",10,2);
        Dialogue newDialogue3 = new Dialogue("new3","New Dialogue 3",10,2);

        Dialogue updateDialogueNew1 = new Dialogue("update1","Update Dialogue New 1",24,3);
        Dialogue updateDialogueOld1 = new Dialogue("update1","Update Dialogue Old 1",10,2);
        Dialogue updateDialogueNew2 = new Dialogue("update2","Update Dialogue New 2",24,3);
        Dialogue updateDialogueOld2 = new Dialogue("update2","Update Dialogue Old 2",10,2);
        Dialogue updateDialogueNew3 = new Dialogue("update3","Update Dialogue New 3",24,3);
        Dialogue updateDialogueOld3 = new Dialogue("update3","Update Dialogue Old 3",10,2);

        Dialogue orphan1 = new Dialogue("orphan1","Orphan Dialogue 1",10,2);
        Dialogue orphan2 = new Dialogue("orphan2","Orphan Dialogue 2",10,2);
        Dialogue orphan3 = new Dialogue("orphan3","Orphan Dialogue 3",10,2);

        rawDialogue.add(newDialogue1);
        rawDialogue.add(newDialogue2);
        rawDialogue.add(newDialogue3);
        rawDialogue.add(updateDialogueNew1);
        rawDialogue.add(updateDialogueNew2);
        rawDialogue.add(updateDialogueNew3);

        existingDialogue.add(updateDialogueOld1);
        existingDialogue.add(orphan1);
        existingDialogue.add(updateDialogueOld2);
        existingDialogue.add(orphan2);
        existingDialogue.add(updateDialogueOld3);
        existingDialogue.add(orphan3);

        dataSyncer.generateStableKeys(rawDialogue);
        dataSyncer.generateStableKeys(existingDialogue);

        List<Dialogue> syncedDialogue = dataSyncer.generateSyncedDialogueList(rawDialogue,existingDialogue);

        List<Dialogue> expectedDialogue = new ArrayList<>();

        expectedDialogue.add(new Dialogue("update1","update1#0","Update Dialogue New 1",10,2));
        expectedDialogue.add(new Dialogue(orphan1));
        expectedDialogue.add(new Dialogue("update2","update2#0","Update Dialogue New 2",10,2));
        expectedDialogue.add(new Dialogue(orphan2));
        expectedDialogue.add(new Dialogue("update3","update3#0","Update Dialogue New 3",10,2));
        expectedDialogue.add(new Dialogue(orphan3));
        expectedDialogue.add(new Dialogue(newDialogue1));
        expectedDialogue.add(new Dialogue(newDialogue2));
        expectedDialogue.add(new Dialogue(newDialogue3));

        assertIterableEquals(syncedDialogue,expectedDialogue);
    }
}
