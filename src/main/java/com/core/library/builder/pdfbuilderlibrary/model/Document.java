package com.core.library.builder.pdfbuilderlibrary.model;

import com.core.library.builder.pdfbuilderlibrary.constants.DocumentType;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPageContainer;

import java.util.List;

public class Document {

    private Long documentId;
    public String name;
    public int totalPages;
    public DocumentType type;
}
