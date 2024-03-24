package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.constants.SectionConstants;
import com.core.library.builder.pdfbuilderlibrary.interfaces.ISectionController;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import com.core.library.builder.pdfbuilderlibrary.utils.CommonUtility;
import com.core.library.builder.pdfbuilderlibrary.utils.SectionUtility;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class SectionController implements ISectionController {

    private final DocumentContainer uDocumentContainer;
    private final PageContainer uPageContainer;
    private Section uSection;
    private final PDPageContentStream contentStream;

    public SectionController(DocumentContainer pDocumentContainer, PageContainer pPageContainer) throws IOException {
        this.uDocumentContainer = pDocumentContainer;
        this.uPageContainer = pPageContainer;
        this.contentStream = new PDPageContentStream(pDocumentContainer.getUserDocument().uDocumentContainer, pPageContainer.getPageContainer().uPageContainer);
    }

    @Override
    public SectionController createSectionContainerAndSetText(Section pSection, Text textModel) throws IOException {
        if(pSection.width == null) {
            pSection.width = SectionConstants.DEFAULT_WIDTH_A4;
        }
        if(pSection.height == null) {
            pSection.height = SectionConstants.DEFAULT_HEIGHT;
        }
        this.uPageContainer.addSectionContainerToPageContainer(this);
        this.uSection = pSection;
        textModel.setTextWidth(SectionUtility.getTextWidth(textModel));
        textModel.setTextHeight(SectionUtility.getTextHeight(textModel.fontType, textModel.fontSize));
        float startX = this.uSection.x;
        float startY = this.uSection.y;
        this.uSection.height = (textModel.getTextHeight()) * SectionUtility.getPredictedNumberOfLinesInSection(textModel, uSection);
        this.contentStream.addRect(uSection.x, uSection.y, uSection.width, uSection.height);
        this.contentStream.stroke();
        this.contentStream.setFont(SectionUtility.getFontFromType(textModel.fontType), textModel.fontSize);
        drawSectionAndWriteTextInsideSection(textModel, startX, startY);

        return this;
    }


    private void drawSectionAndWriteTextInsideSection(Text textModel, Float startX, Float startY) throws IOException {
        PDType1Font currentFont = SectionUtility.getFontFromType(textModel.fontType);
        drawSection(currentFont, textModel.fontSize);
        String[] lines = CommonUtility.splitTextIntoLinesBasedOnContainerWidth(textModel.text, currentFont, textModel.fontSize, this.uSection.width);
        for (int i = 0; i < lines.length; i++) {
            float lineHeight = SectionUtility.getTextHeight(textModel.fontType, textModel.fontSize);
            float textX = startX + SectionConstants.PADDING_1F;
            float startHeight = (lineHeight) * (i+1);
            float textY = (startY + this.uSection.height) - startHeight;
            this.contentStream.beginText();
            this.contentStream.newLineAtOffset(textX, textY);
            this.contentStream.showText(lines[i]);
            this.contentStream.endText();
        }
    }

    private void drawSection(PDType1Font currentFont, int fontSize) throws IOException {
        this.contentStream.addRect(uSection.x, uSection.y, uSection.width, uSection.height);
        this.contentStream.stroke();
        this.contentStream.setFont(currentFont, fontSize);
    }

    public void closeDrawingStream() throws IOException{
        this.contentStream.close();
    }

    public DocumentContainer getDocumentContainer() {
        return this.uDocumentContainer;
    }

    public PageContainer getPageContainer() {
        return this.uPageContainer;
    }

    public SectionController getSectionContainer() {
        return this;
    }
}
