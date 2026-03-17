package me.akranium.json;

import me.akranium.util.Methods;
import me.akranium.data.Dialogue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSyncer {

    @VisibleForTesting
    public void generateStableKeys(@NotNull List<Dialogue> dialogues) {
        //NOTE: Identical key's orders shouldn't change relative to each other in order for this method to work.

        Map<String,Integer> keyCounters = new HashMap<>();
        for(Dialogue dialogue : dialogues) {
            String key = dialogue.getRawKey();

            int index = keyCounters.getOrDefault(key, 0);
            keyCounters.put(key, index + 1);

            String stableKey = key + "#" + index;
            dialogue.setStableKey(stableKey);
        }
    }

    public @NotNull List<Dialogue> generateSyncedDialogueList(@NotNull List<Dialogue> rawDialogues,@Nullable List<Dialogue> existingDialogues) {
        List<Dialogue> rawWorkingDialogues = Methods.deepCopy(rawDialogues);

        generateStableKeys(rawWorkingDialogues);

        if (existingDialogues == null || existingDialogues.isEmpty()) {
            return rawWorkingDialogues;
        }

        List<Dialogue> syncedDialogues = Methods.deepCopy(existingDialogues);

        Map<String,Dialogue> rawKeyMap = new HashMap<>();
        Set<String> seenRawKeys = new HashSet<>();

        for(Dialogue rawDialogue : rawWorkingDialogues) {
            rawKeyMap.put(rawDialogue.getStableKey(), rawDialogue);
        }

        for(Dialogue unsyncedDialogue : syncedDialogues) {
            String key = unsyncedDialogue.getStableKey();
            Dialogue rawDialogue = rawKeyMap.get(key);
            if(rawDialogue != null) {
                seenRawKeys.add(key);
                unsyncedDialogue.setString(rawDialogue.getString());
            }
        }

        for(Dialogue rawDialogue : rawWorkingDialogues) {
            String key = rawDialogue.getStableKey();
            if(!seenRawKeys.contains(key)) {
                syncedDialogues.add(new Dialogue(rawDialogue));
            }
        }

        return syncedDialogues;
    }
}
