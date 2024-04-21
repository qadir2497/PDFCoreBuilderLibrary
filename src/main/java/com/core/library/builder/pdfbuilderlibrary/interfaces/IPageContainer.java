package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.containers.SectionController;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import org.apache.pdfbox.pdmodel.PDPage;

public abstract class IPageContainer extends PDPage{

    public PDPage page;

    public abstract void createPage(Page pPage);

    public abstract IPageContainer getPageContainer();

    public abstract void addSectionContainerToPageContainer(SectionController pSectionContainer);
    
}
