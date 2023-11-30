package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocument;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import com.core.library.builder.pdfbuilderlibrary.interfaces.ISection;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class SectionContainer implements ISection {

    private Section section;
    private final PDPageContentStream contentStream;

    public SectionContainer(IDocument document, IPage page) throws IOException {
        this.contentStream = new PDPageContentStream(document.document, page.page);
    }

    @Override
    public void createRow(Section section) throws IOException {
        this.section = section;
        this.contentStream.addRect(section.x, section.y, section.width, section.height);
        this.contentStream.stroke();
    }

    public void setTextInRow(String text) throws IOException {
        // Create font class separately
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 11);
        contentStream.beginText();
        float fontSize = 12;
        float fontHeight = new PDType1Font(Standard14Fonts.FontName.HELVETICA).getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
        float xc = section.x + 10;
        float yc = section.y + section.height - fontHeight - 2;
        contentStream.newLineAtOffset(xc, yc);

        float availableWidth = section.width - 20;
        String[] words = text.split(" ");
        float currentLineWidth = 0;
        for (String word : words) {
            float wordWidth =
                    (new PDType1Font(Standard14Fonts.FontName.HELVETICA)
                            .getStringWidth(word) / 1000) * fontSize;

            if (currentLineWidth + wordWidth > availableWidth) {
                yc = yc - 3;
                contentStream.newLineAtOffset(xc, yc); // Move to the next line
                currentLineWidth = 0;
            }
            contentStream.showText(word + " ");
            currentLineWidth += wordWidth;
        }

        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
    }
}
