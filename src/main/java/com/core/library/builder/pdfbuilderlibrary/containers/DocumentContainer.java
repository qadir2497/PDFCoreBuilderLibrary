package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocument;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class DocumentContainer extends IDocument {

    public  void createContainer() {
        document = new PDDocument();
    }

    public void addPageToDocument(IPage page) {
        PageContainer pContainer = (PageContainer)page;
        document.addPage(pContainer.page);
    }

    @Override
    public void saveDocument(String documentName) throws IOException {
        document.save(documentName);
    }

    @Override
    public void closeDocument() throws IOException {
        document.close();
    }

}
