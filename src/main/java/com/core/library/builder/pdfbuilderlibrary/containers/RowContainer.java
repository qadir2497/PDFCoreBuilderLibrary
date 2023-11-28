package com.core.library.builder.pdfbuilderlibrary.containers;

import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocument;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IRow;
import com.core.library.builder.pdfbuilderlibrary.model.Row;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class RowContainer implements IRow {

    private Row row;
    private final PDPageContentStream contentStream;

    public RowContainer(IDocument document, IPage page) throws IOException {
        this.contentStream = new PDPageContentStream(document.document, page.page);
    }

    @Override
    public void createRow(Row row) throws IOException {
        this.row = row;
        this.contentStream.addRect(row.x, row.y, row.width, row.height);
        this.contentStream.stroke();
    }

    public void setTextInRow(String text) throws IOException {
        // Create font class separately
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 11);
        contentStream.beginText();
        contentStream.newLineAtOffset(row.x + 10, row.y + 5);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
    }
}
