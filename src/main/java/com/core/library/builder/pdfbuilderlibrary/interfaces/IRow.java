package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.model.Row;

import java.io.IOException;

public interface IRow {
    void createRow(Row row) throws IOException;
    void setTextInRow(String text) throws IOException;
}
