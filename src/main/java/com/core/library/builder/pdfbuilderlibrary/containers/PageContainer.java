package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PageContainer extends IPage {

    @Override
    public void createPage() {
        page = new PDPage(PDRectangle.A4);
    }
}
