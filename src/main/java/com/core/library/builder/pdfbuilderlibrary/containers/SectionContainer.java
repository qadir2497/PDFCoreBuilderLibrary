package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.constants.SectionConstants;
import com.core.library.builder.pdfbuilderlibrary.interfaces.ISectionContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SectionContainer implements ISectionContainer {

    private DocumentContainer uDocumentContainer;
    private PageContainer uPageContainer;
    private Section uSection;
    private final PDPageContentStream contentStream;

    public SectionContainer(DocumentContainer pDocumentContainer, PageContainer pPageContainer) throws IOException {
        this.uDocumentContainer = pDocumentContainer;
        this.uPageContainer = pPageContainer;
        this.contentStream = new PDPageContentStream(pDocumentContainer.getUserDocument().uDocumentContainer, pPageContainer.getPageContainer().uPageContainer);
    }

    @Override
    public SectionContainer createSection(Section pSection) throws IOException {
        if(pSection.width == null) {
            pSection.width = SectionConstants.DEFAULT_WIDTH_A4 / 1.1F;
        }
        if(pSection.height == null) {
            pSection.height = SectionConstants.DEFAULT_HEIGHT;
        }
//        this.contentStream.addRect(pSection.x, pSection.y, pSection.width, pSection.height);
//        this.contentStream.stroke();
        this.uPageContainer.addSectionContainerToPageContainer(this);

        this.uSection = pSection;
        return this;
    }

    // TODO: +2 at line 53? find a pattern to keep num of line consistent
    // TODO: Test this thoroughly, after success move it to section utility
    @Override
    public void setTextInSection(Text textModel) throws IOException {
        textModel.setTextWidth(new PDType1Font(textModel.fontType).getStringWidth(textModel.text) / 1000f * textModel.fontSize);
        textModel.setTextHeight(new PDType1Font(textModel.fontType).getFontDescriptor().getFontBoundingBox().getHeight() / 1000f * textModel.fontSize);

        float startX = this.uSection.x;
        float startY = this.uSection.y;

        if (textModel.getTextWidth() > this.uSection.width) {
            int numLines = (int) Math.ceil(textModel.getTextWidth() / this.uSection.width) + 2;
            this.uSection.height = ((textModel.getTextHeight()) * numLines);
        } else{
            this.uSection.height = textModel.getTextHeight();
        }
        this.contentStream.addRect(uSection.x, uSection.y, uSection.width, uSection.height);
        this.contentStream.stroke();
        contentStream.setFont(new PDType1Font(textModel.fontType), textModel.fontSize);


        String[] lines = splitTextIntoLines(textModel.text, new PDType1Font(Standard14Fonts.FontName.HELVETICA), textModel.fontSize, this.uSection.width);

        // Draw each line of text
        for (int i = 0; i < lines.length; i++) {
            float lineHeight = new PDType1Font(Standard14Fonts.FontName.HELVETICA).getFontDescriptor().getFontBoundingBox().getHeight() / 1000f * 12;
            float textX = startX + SectionConstants.PADDING_2F;
            float startHeight = (lineHeight) * (i+1);
            float textY = (startY + this.uSection.height) - startHeight;
            contentStream.beginText();
            contentStream.newLineAtOffset(textX, textY);
            contentStream.showText(lines[i]);
            contentStream.endText();
        }
        contentStream.close();
    }


    private static String[] splitTextIntoLines(String text, PDType1Font font, int fontSize, float maxWidth) throws IOException {
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();
        List<String> lines = new ArrayList<>();
        float width = 0;
        float spaceWidth = font.getStringWidth(" ") / 1000f * fontSize;
        for (String word : words) {
            float wordWidth = font.getStringWidth(word) / 1000f * fontSize;
            if (width + wordWidth + 1 > maxWidth) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder();
                width = 0;
            }
            currentLine.append(word).append(" ");
            width = width + wordWidth + spaceWidth + SectionConstants.PADDING_1F;
        }
        lines.add(currentLine.toString());
        return lines.toArray(new String[0]);
    }

    public DocumentContainer getDocumentContainer() {
        return this.uDocumentContainer;
    }

    public PageContainer getPageContainer() {
        return this.uPageContainer;
    }

    public SectionContainer getSectionContainer() {
        return this;
    }
}
