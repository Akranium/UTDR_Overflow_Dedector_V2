package me.akranium.overflowchecker;

import me.akranium.data.Dialogue;

public class OverflowChecker {
    public boolean hasOverflow(Dialogue dialogue) {
        String text = dialogue.getString();
        int maxChars = dialogue.getMaxChars();
        int maxLines = dialogue.getMaxLines();
        if (text == null || text.isEmpty()) {
            return false;
        }
        if (maxLines <= 0 || maxChars <= 0) {
            return true;
        }
        String[] logicalLines = text.split("&", -1);
        int totalLineCount = 0;
        for (String logicalLine : logicalLines) {
            int lineLength = 0;
            int i = 0;
            while (i < logicalLine.length()) {
                int wordStart = i;
                while (i < logicalLine.length() && logicalLine.charAt(i) != ' ') {
                    i++;
                }
                int wordLength = i - wordStart;
                if (i < logicalLine.length() && logicalLine.charAt(i) == ' ') {
                    i++;
                }
                if (wordLength > maxChars) {
                    return true;
                }
                if (lineLength + wordLength > maxChars && lineLength > 0) {
                    totalLineCount++;
                    lineLength = 0;
                }
                lineLength += wordLength;
            }
            if (lineLength > 0) {
                totalLineCount++;
            }
        }
        return totalLineCount > maxLines;
    }

}
