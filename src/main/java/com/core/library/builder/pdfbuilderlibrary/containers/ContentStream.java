package com.core.library.builder.pdfbuilderlibrary.containers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;

public class ContentStream {

    private PDPageContentStream contentStream;

    public  PDPageContentStream createContentStream(PDDocument pDocument, PDPage pPage) {
        try {
            if(contentStream == null) {
            contentStream =  new PDPageContentStream(pDocument,
                    pPage, PDPageContentStream.AppendMode.APPEND, true, true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contentStream;
    }

    public PDPageContentStream getCurrentContentStream() {
        return this.contentStream;
    }

    public void closeContentStream(PDPageContentStream pContentStream) {
        try {
            pContentStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
