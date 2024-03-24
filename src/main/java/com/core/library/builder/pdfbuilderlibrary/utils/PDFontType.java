package com.core.library.builder.pdfbuilderlibrary.utils;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.HashMap;
import java.util.Map;

public class PDFontType {

    private final static Map<Standard14Fonts.FontName, PDType1Font> map = new HashMap<>();

    private PDFontType() {}

    public static synchronized  PDType1Font getInstanceOfPDType1Font(Standard14Fonts.FontName fontType) {
        if(map.get(fontType) != null) {
            return map.get(fontType);
        }
        PDType1Font type = new PDType1Font(fontType);
        map.put(fontType, type);
        return type;
    }
}
