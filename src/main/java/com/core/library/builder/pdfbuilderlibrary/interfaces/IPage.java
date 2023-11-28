package com.core.library.builder.pdfbuilderlibrary.interfaces;

import org.apache.pdfbox.pdmodel.PDPage;

public abstract class IPage extends PDPage{
    public PDPage page;

    public abstract void createPage();
    
}
