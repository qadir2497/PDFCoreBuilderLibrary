package com.core.library.builder.pdfbuilderlibrary.exception;

public class PDFBuilderLibraryException extends RuntimeException{

    public PDFBuilderLibraryException documentLimitReachedException() {
        throw new RuntimeException("Cannot add anymore PageContainer. Increase size of DocumentContainer!");
    }
}
