package me.akranium.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import me.akranium.util.Constants;
import me.akranium.data.Dialogue;
import me.akranium.data.DialogueCategory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public @NotNull List<Dialogue> readRawJson(Path path) throws IOException {
        List<Dialogue> dialogues = new ArrayList<>();

        try(JsonParser parser = new JsonFactory().createParser(path.toFile());) {
            if (parser.nextToken() != JsonToken.START_OBJECT) {
                throw new IllegalStateException("Expected JSON object");
            }

            while (parser.nextToken() != JsonToken.END_OBJECT) {
                if (parser.currentToken() == JsonToken.FIELD_NAME) {
                    String key = parser.currentName();
                    parser.nextToken(); // move to value
                    String value = parser.getValueAsString();
                    dialogues.add(new Dialogue(key,value, Constants.DEFAULT_MAX_CHARS,Constants.DEFAULT_MAX_LINES));
                }
            }
        }
        return dialogues;
    }

    public @NotNull List<Dialogue> readMetadataJson(Path path) throws Exception {
        List<Dialogue> dialogues = new ArrayList<>();
        try (JsonParser parser = new JsonFactory().createParser(path.toFile())) {
            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected JSON array");
            }
            while(parser.nextToken() == JsonToken.START_OBJECT) {
                String rawKey = null;
                String stableKey = null;
                String string = null;
                int maxChars = 0;
                int maxLines = 0;

                while (parser.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = parser.currentName();
                    parser.nextToken();   // move to field value

                    switch (fieldName) {
                        case "rawKey": rawKey = parser.getValueAsString(); break;
                        case "stableKey": stableKey = parser.getValueAsString(); break;
                        case "string": string = parser.getValueAsString(); break;
                        case "maxChars": maxChars = parser.getValueAsInt(); break;
                        case "maxLines": maxLines = parser.getValueAsInt(); break;
                        default: parser.skipChildren(); break;
                    }
                }
                Dialogue dialogue = new Dialogue(rawKey,stableKey,string,maxChars,maxLines);
                dialogues.add(dialogue);
            }
        }
        return dialogues;
    }
}
