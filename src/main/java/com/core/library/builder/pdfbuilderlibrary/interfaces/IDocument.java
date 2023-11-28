package com.core.library.builder.pdfbuilderlibrary.interfaces;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public abstract class IDocument extends PDDocument{
    public PDDocument document;
    public abstract void createContainer();
    public abstract void addPageToDocument(IPage page);
    public abstract void saveDocument(String documentName) throws IOException;
    public abstract void closeDocument() throws IOException;

}
