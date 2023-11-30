package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.model.Section;

import java.io.IOException;

public interface ISection {
    void createRow(Section row) throws IOException;
    void setTextInRow(String text) throws IOException;
}
