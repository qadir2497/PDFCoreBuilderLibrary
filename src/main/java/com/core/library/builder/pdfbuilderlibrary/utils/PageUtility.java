package com.core.library.builder.pdfbuilderlibrary.utils;

import com.core.library.builder.pdfbuilderlibrary.constants.PageLayouts;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PageUtility {

    public static PDRectangle getPageSize(PageLayouts size) {
        return switch (size) {
            case A0 -> PDRectangle.A0;
            case A1 -> PDRectangle.A1;
            case A2 -> PDRectangle.A2;
            case A3 -> PDRectangle.A3;
            case A4 -> PDRectangle.A4;
            case A5 -> PDRectangle.A5;
            case A6 -> PDRectangle.A6;
        };
    }

    public static Float getWidthOfPageLayout(PageLayouts size) {
        PDRectangle layout = null;
        switch (size) {
            case A0 -> layout = PDRectangle.A0;
            case A1 -> layout = PDRectangle.A1;
            case A2 -> layout = PDRectangle.A2;
            case A3 -> layout = PDRectangle.A3;
            case A4 -> layout = PDRectangle.A4;
            case A5 -> layout = PDRectangle.A5;
            case A6 -> layout = PDRectangle.A6;
        };
        return layout.getWidth();
    }

    public static Float getHeightOfPageLayout(PageLayouts size) {
        PDRectangle layout = null;
        switch (size) {
            case A0 -> layout = PDRectangle.A0;
            case A1 -> layout = PDRectangle.A1;
            case A2 -> layout = PDRectangle.A2;
            case A3 -> layout = PDRectangle.A3;
            case A4 -> layout = PDRectangle.A4;
            case A5 -> layout = PDRectangle.A5;
            case A6 -> layout = PDRectangle.A6;
        };
        return layout.getHeight();
    }

}
