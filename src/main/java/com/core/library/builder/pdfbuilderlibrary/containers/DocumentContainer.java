package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.exception.PDFBuilderLibraryException;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Document;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentContainer extends IDocumentContainer {

    private Document uDocumentModel;
    private List<PageContainer> uPageContainerList;

    @Override
    public  void createDocumentContainer(Document pDocument) {
        super.document = new PDDocument();
        this.uDocumentModel = pDocument;
        this.uPageContainerList = new ArrayList<>();

    }

    @Override
    public void addPageContainerToDocumentContainer(PageContainer pPageContainer, ContentStream contentStream) {
        if(uPageContainerList.size() >= uDocumentModel.totalPages) {
            throw new PDFBuilderLibraryException().documentLimitReachedException();
        }
        super.document.addPage(pPageContainer.page);
        uPageContainerList.add(pPageContainer);
        pPageContainer.setParentDocumentContainer(this);
        pPageContainer.setContentStream(contentStream);
    }

    @Override
    public void saveDocument() throws IOException {
        super.document.save(uDocumentModel.name);
    }

    @Override
    public DocumentContainer getUserDocument() {
        return this;
    }

    @Override
    public void closeDocument() throws IOException {
        super.document.close();
    }

    @Override
    public int getPageContainerCount() {
        return uPageContainerList.size();
    }

}
