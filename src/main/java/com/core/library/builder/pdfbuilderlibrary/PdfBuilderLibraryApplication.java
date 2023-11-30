package com.core.library.builder.pdfbuilderlibrary;

import com.core.library.builder.pdfbuilderlibrary.containers.DocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.SectionContainer;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocument;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPage;
import com.core.library.builder.pdfbuilderlibrary.interfaces.ISection;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
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
		//add page to doc. There can be multiple pages inside a doc.
		dc.addPageToDocument(pc);
		Section row = new Section();
		row.x = 20.0F;
		row.y = 50.0F;
		row.height = 400.0F;
		row.width = 500.0F;
		SectionContainer rc = new SectionContainer(dc, pc);
		rc.createRow(row);
		rc.setTextInRow("Hello Abdul Qadir. How are you!!, I am good.How about you. I know you " +
				"may be missing me");
		dc.saveDocument("demo.pdf");
		dc.closeDocument();
	}

}
