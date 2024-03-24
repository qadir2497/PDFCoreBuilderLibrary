package com.core.library.builder.pdfbuilderlibrary.utils;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonUtility {

    public static String[] splitTextIntoLinesBasedOnContainerWidth(String text, PDType1Font font, int fontSize, float maxWidth) throws IOException {
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();
        List<String> lines = new ArrayList<>();
        float width = 0;
        float spaceWidth = font.getStringWidth(" ") / 1000f * fontSize;
        for (String word : words) {
            float wordWidth = font.getStringWidth(word) / 1000f * fontSize;
            if (width + wordWidth > maxWidth) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder();
                width = 0;
            }
            currentLine.append(word).append(" ");
            width = width + wordWidth + spaceWidth;
        }
        lines.add(currentLine.toString());
        return lines.toArray(new String[0]);
    }

}
