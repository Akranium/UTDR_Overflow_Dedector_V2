package me.akranium.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import me.akranium.data.Dialogue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class JsonWriter {
    public void writeDialogueJson(Path path, List<Dialogue> dialogues) throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(path.toFile(), JsonEncoding.UTF8);
        generator.useDefaultPrettyPrinter();

        generator.writeStartArray();
        for(Dialogue dialogue : dialogues) {
            generator.writeStartObject();

            generator.writeStringField("rawKey",dialogue.getRawKey());
            generator.writeStringField("stableKey",dialogue.getStableKey());
            generator.writeStringField("string",dialogue.getString());
            generator.writeNumberField("maxChars",dialogue.getMaxChars());
            generator.writeNumberField("maxLines",dialogue.getMaxLines());

            generator.writeEndObject();
        }
        generator.writeEndArray();
        generator.close();
    }
}
