package com.core.library.builder.pdfbuilderlibrary;

import com.core.library.builder.pdfbuilderlibrary.containers.DocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.RowContainer;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocument;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import com.core.library.builder.pdfbuilderlibrary.model.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PdfBuilderLibraryApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PdfBuilderLibraryApplication.class, args);

		IDocument dc = new DocumentContainer();
		dc.createContainer();
		IPage pc = new PageContainer();
		pc.createPage();
		dc.addPageToDocument(pc);
		Row row = new Row();
		row.x = 20.0F;
		row.y = 50.0F;
		row.height = 15.0F;
		row.width = 250.0F;
		RowContainer rc = new RowContainer(dc, pc);
		rc.createRow(row);
		rc.setTextInRow("Hello Abdul Qadir. How are you!!");

		dc.saveDocument("demo.pdf");
		dc.closeDocument();
	}

}
