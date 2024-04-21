package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.constants.SectionConstants;
import com.core.library.builder.pdfbuilderlibrary.enums.TextType;
import com.core.library.builder.pdfbuilderlibrary.interfaces.ISectionController;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import com.core.library.builder.pdfbuilderlibrary.utils.CommonUtility;
import com.core.library.builder.pdfbuilderlibrary.utils.SectionUtility;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

import java.io.IOException;

public class SectionController implements ISectionController {

    private final DocumentContainer uDocumentContainer;
    private final PageContainer uPageContainer;
    private Section uSection;
    private final ContentStream contentStream;

    public SectionController(DocumentContainer pDocumentContainer, PageContainer pPageContainer, ContentStream contentStream) throws IOException {
        this.uDocumentContainer = pDocumentContainer;
        this.uPageContainer = pPageContainer;
        this.contentStream = contentStream;
    }

    @Override
    public SectionController createSectionContainerAndSetText(Section pSection, Text textModel) throws IOException {
        if(pSection.width == null) {
            pSection.width = SectionConstants.DEFAULT_WIDTH_A4;
        }
        if(pSection.height == null) {
            pSection.height = SectionConstants.DEFAULT_HEIGHT;
        }
        Float textWidth = SectionUtility.getTextWidth(textModel);
        Float textHeight = SectionUtility.getTextHeight(textModel.fontType, textModel.fontSize);
        textModel.setTextWidth(textWidth);
        textModel.setTextHeight(textHeight);
        if(textModel.isClickable && textModel.types.contains(TextType.EMAIL)) {
            createLinkWithLabel(pSection, textModel);
            return this;
        }
        this.uPageContainer.addSectionContainerToPageContainer(this);
        this.uSection = pSection;
        float startX = this.uSection.x;
        float startY = this.uSection.y;
        if(pSection.numberOfLines == 1) {
            this.uSection.width = textWidth;
        }
        this.uSection.height = (textModel.getTextHeight()) * SectionUtility.getPredictedNumberOfLinesInSection(textModel, uSection);
        this.contentStream.getCurrentContentStream().addRect(uSection.x, uSection.y, uSection.width, uSection.height);
        this.contentStream.getCurrentContentStream().setFont(SectionUtility.getFontFromType(textModel.fontType), textModel.fontSize);
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
            this.contentStream.getCurrentContentStream().beginText();
            this.contentStream.getCurrentContentStream().newLineAtOffset(textX, textY);
            this.contentStream.getCurrentContentStream().showText(lines[i]);
            this.contentStream.getCurrentContentStream().endText();
        }
//        if(textModel.types != null && textModel.types.contains(TextType.LINE)) {
//            this.contentStream.getCurrentContentStream().saveGraphicsState();
//
//            float textWidth = this.uSection.width;
//            this.contentStream.getCurrentContentStream().addRect(this.uSection.x , this.uSection.y - 2, textWidth, 1);
//            this.contentStream.getCurrentContentStream().fill();
//
//            this.contentStream.getCurrentContentStream().restoreGraphicsState();
//        }

    }

    private void drawSection(PDType1Font currentFont, int fontSize) throws IOException {
        this.contentStream.getCurrentContentStream().addRect(uSection.x, uSection.y, uSection.width, uSection.height);
        if(uSection.isStrokeRequired) {
            this.contentStream.getCurrentContentStream().stroke();
        }
        this.contentStream.getCurrentContentStream().setFont(currentFont, fontSize);
    }

    private void createLinkWithLabel(Section pSection, Text pTextModel) throws IOException {
        PDAnnotationLink link = getPdAnnotationLink(pSection, pTextModel);

        this.uPageContainer.page.getAnnotations().add(link);
        PDType1Font currentFont = SectionUtility.getFontFromType(pTextModel.fontType);

        contentStream.getCurrentContentStream().beginText();
        contentStream.getCurrentContentStream().setFont(currentFont, pTextModel.fontSize);
        contentStream.getCurrentContentStream().newLineAtOffset(pSection.x, pSection.y);
        contentStream.getCurrentContentStream().showText(pTextModel.text);
        contentStream.getCurrentContentStream().endText();

    }

    private PDAnnotationLink getPdAnnotationLink(Section pSection, Text pTextModel) {
        PDRectangle rect = new PDRectangle(pSection.x, pSection.y, pTextModel.getTextWidth(), pTextModel.getTextHeight());

        PDAnnotationLink link = new PDAnnotationLink();
        link.setRectangle(rect);

        PDBorderStyleDictionary borderULine = new PDBorderStyleDictionary();
        borderULine.setStyle(PDBorderStyleDictionary.STYLE_UNDERLINE);
        borderULine.setWidth(0);
        link.setBorderStyle(borderULine);

        PDActionURI action = new PDActionURI();
        action.setURI(pTextModel.linkValue);
        link.setAction(action);
        return link;
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
