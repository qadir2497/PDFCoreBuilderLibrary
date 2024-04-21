package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.containers.ContentStream;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Document;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public abstract class IDocumentContainer extends PDDocument{
    public PDDocument document;
    public abstract void createDocumentContainer(Document document);
    public abstract void addPageContainerToDocumentContainer(PageContainer pageContainer, ContentStream contentStream);
    public abstract void saveDocument() throws IOException;
    public abstract IDocumentContainer getUserDocument();
    public abstract void closeDocument() throws IOException;
    public abstract int getPageContainerCount();

}
