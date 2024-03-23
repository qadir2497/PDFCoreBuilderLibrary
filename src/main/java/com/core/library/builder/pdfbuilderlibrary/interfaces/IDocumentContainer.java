package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Document;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public abstract class IDocumentContainer extends PDDocument{
    public PDDocument uDocumentContainer;
    public abstract void createDocumentContainer(Document pDocument);
    public abstract void addPageContainerToDocumentContainer(PageContainer pPageContainer);
    public abstract void saveDocument() throws IOException;
    public abstract IDocumentContainer getUserDocument();
    public abstract void closeDocument() throws IOException;
    public abstract int getPageContainerCount();

}
