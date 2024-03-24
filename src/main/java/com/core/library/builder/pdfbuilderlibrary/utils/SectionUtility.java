package com.core.library.builder.pdfbuilderlibrary.utils;

import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class SectionUtility {

    public static Float getTextWidth(Text textModel) {
        float width = 0.0F;
        try {
            width = PDFontType.getInstanceOfPDType1Font(textModel.fontType).getStringWidth(textModel.text) / 1000f * textModel.fontSize;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return width;
    }

    public static Float getTextHeight(Standard14Fonts.FontName fontType, int fontSize) {
        float height = 0.0F;
        try {
            height = PDFontType.getInstanceOfPDType1Font(fontType).getFontDescriptor().getFontBoundingBox().getHeight() / 1000f * fontSize;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return height;
    }

    public static int getPredictedNumberOfLinesInSection(Text textModel, Section section) {
        int numLines = 1;
        if (textModel.getTextWidth() > section.width) {
            numLines = (int) Math.ceil(textModel.getTextWidth() / section.width) + 1;
        }
        return numLines;
    }

    public static PDType1Font getFontFromType(Standard14Fonts.FontName fontName) {
        return PDFontType.getInstanceOfPDType1Font(fontName);
    }
}
