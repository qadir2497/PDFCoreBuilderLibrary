package com.core.library.builder.pdfbuilderlibrary.model;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class Text {

    public String text;
    private Float textWidth;
    private Float textHeight;
    public int fontSize;
    public Standard14Fonts.FontName fontType;

    public Float getTextWidth() {
        return textWidth;
    }

    public void setTextWidth(Float textWidth) {
        this.textWidth = textWidth;
    }

    public Float getTextHeight() {
        return textHeight;
    }

    public void setTextHeight(Float textHeight) {
        this.textHeight = textHeight;
    }
}
