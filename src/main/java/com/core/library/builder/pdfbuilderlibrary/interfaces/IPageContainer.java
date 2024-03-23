package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.containers.SectionContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import org.apache.pdfbox.pdmodel.PDPage;

public abstract class IPageContainer extends PDPage{

    public PDPage uPageContainer;

    public abstract void createPage(Page pPage);

    public abstract IPageContainer getPageContainer();

    public abstract void addSectionContainerToPageContainer(SectionContainer pSectionContainer);
    
}
