package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IPageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import org.apache.pdfbox.pdmodel.PDPage;

import java.util.ArrayList;
import java.util.List;

public class PageContainer extends IPageContainer {

    public Page uPage;
    public List<SectionContainer> uSectionContainerList;

    @Override
    public void createPage(Page pPage) {
        super.uPageContainer = new PDPage(pPage.pageLayoutSize);
        this.uPage = pPage;
        this.uSectionContainerList = new ArrayList<>();
    }

    @Override
    public IPageContainer getPageContainer() {
        return this;
    }

    @Override
    public void addSectionContainerToPageContainer(SectionContainer pSectionContainer) {
        this.uSectionContainerList.add(pSectionContainer);
    }
}
