package me.akranium.json;

import me.akranium.data.Dialogue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonService {

    private final Path appRoot;
    private final Path rawPath;
    private final Path metadataPath;

    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private DataSyncer dataSyncer;


    public JsonService() {
        this.appRoot = Paths.get("").toAbsolutePath();
        this.rawPath = appRoot.resolve("raw").resolve("raw.json");
        this.metadataPath = appRoot.resolve(".internal")
                .resolve("dialogue-metadata.json");

        this.jsonReader = new JsonReader();
        this.jsonWriter = new JsonWriter();
        this.dataSyncer = new DataSyncer();
    }

    public void initializeFiles() throws IOException {
        Files.createDirectories(rawPath.getParent());
        Files.createDirectories(metadataPath.getParent());

        createFileIfMissing(rawPath, "{\n\n}");
        createFileIfMissing(metadataPath, "[\n\n]");
    }

    private List<Dialogue> loadRawDialogues() throws Exception {
        return jsonReader.readRawJson(rawPath);
    }

    private List<Dialogue> loadMetadataDialogues() throws Exception {
        return jsonReader.readMetadataJson(metadataPath);
    }

    public void saveMetadataDialogues(List<Dialogue> dialogues) throws Exception {
        jsonWriter.writeDialogueJson(metadataPath, dialogues);
    }

    public List<Dialogue> processJsons() throws Exception {
        List<Dialogue> raw = loadRawDialogues();
        List<Dialogue> metadata = loadMetadataDialogues();

        List<Dialogue> synced = dataSyncer.generateSyncedDialogueList(raw, metadata);

        saveMetadataDialogues(synced);

        return synced;
    }

    private void createFileIfMissing(Path path, String defaultContent) throws IOException {
        if (Files.notExists(path)) {
            Files.writeString(path, defaultContent);
        }
    }

}

