package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IPageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.util.ArrayList;
import java.util.List;

public class PageContainer extends IPageContainer {

    public Page uPage;
    public List<SectionController> uSectionContainerList;

    public ContentStream contentStream;

    public DocumentContainer parentDocumentContainer;

    @Override
    public void createPage(Page pPage) {
        super.page = new PDPage(pPage.pageLayoutSize);
        this.uPage = pPage;
        this.uSectionContainerList = new ArrayList<>();
    }

    @Override
    public IPageContainer getPageContainer() {
        return this;
    }

    @Override
    public void addSectionContainerToPageContainer(SectionController pSectionContainer) {
        this.uSectionContainerList.add(pSectionContainer);
    }

    public void setParentDocumentContainer(DocumentContainer pDocContainer) {
        this.parentDocumentContainer = pDocContainer;
    }

    public void setContentStream(ContentStream pContentStream) {
        this.contentStream = pContentStream;
        this.contentStream.createContentStream(parentDocumentContainer.document, page);
    }
}
