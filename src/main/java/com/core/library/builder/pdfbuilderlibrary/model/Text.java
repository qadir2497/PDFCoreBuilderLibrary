package com.core.library.builder.pdfbuilderlibrary.model;

import com.core.library.builder.pdfbuilderlibrary.enums.TextType;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.List;

public class Text {

    public String text;
    private Float textWidth;
    private Float textHeight;
    public int fontSize;
    public boolean isClickable;
    public List<TextType> types;
    public String linkValue;

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
