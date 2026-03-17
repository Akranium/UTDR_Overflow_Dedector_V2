package me.akranium.data;

import java.util.Objects;

public class Dialogue {
    private String rawKey;
    private String stableKey;
    private String string;
    private int maxChars;
    private int maxLines;
    private DialogueCategory category;

    public Dialogue(String rawKey, String string, int maxChars, int maxLines) {
        this(rawKey,"",string,maxChars,maxLines,DialogueCategory.UNCATEGORIZED);
    }

    public Dialogue(String rawKey, String stableKey, String string, int maxChars, int maxLines) {
        this(rawKey,stableKey,string,maxChars,maxLines,DialogueCategory.UNCATEGORIZED);
    }

    public Dialogue(String rawKey, String stableKey, String string, int maxChars, int maxLines, DialogueCategory category) {
        this.rawKey = rawKey;
        this.stableKey = stableKey;
        this.string = string;
        this.maxChars = maxChars;
        this.maxLines = maxLines;
        this.category = category;
    }

    public Dialogue(Dialogue other) {
        //All fields are immutable, so deep copy
        this.rawKey    = other.rawKey;
        this.stableKey = other.stableKey;
        this.string    = other.string;
        this.maxChars  = other.maxChars;
        this.maxLines  = other.maxLines;
        this.category  = other.category;
    }

    // Getters & Setters
    public String getString() { return string; }

    public void setString(String text) { this.string = text; }

    public int getMaxChars() { return maxChars; }

    public void setMaxChars(int maxChars) { this.maxChars = maxChars; }

    public int getMaxLines() { return maxLines; }

    public void setMaxLines(int maxLines) { this.maxLines = maxLines; }

    public DialogueCategory getCategory() {
        return category;
    }

    public void setCategory(DialogueCategory dialogueCategory) {
        this.category = dialogueCategory;
    }

    public String getRawKey() {
        return rawKey;
    }

    public void setRawKey(String rawKey) {
        this.rawKey = rawKey;
    }

    public String getStableKey() {
        return stableKey;
    }

    public void setStableKey(String stableKey) {
        this.stableKey = stableKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dialogue)) return false;
        Dialogue d = (Dialogue) o;
        return rawKey.equals(d.rawKey) &&
                stableKey.equals(d.stableKey) &&
                string.equals(d.string) &&
                maxChars == d.maxChars &&
                maxLines == d.maxLines &&
                category.equals(d.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stableKey, string, maxChars, maxLines, category);
    }


}

