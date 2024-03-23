package com.core.library.builder.pdfbuilderlibrary.model;

import com.core.library.builder.pdfbuilderlibrary.interfaces.ISectionContainer;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.util.List;

public class Page {

    private Long pageId;
    public int pageNumber;
    public PDRectangle pageLayoutSize;

}
