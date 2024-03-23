package com.core.library.builder.pdfbuilderlibrary;

import com.core.library.builder.pdfbuilderlibrary.constants.PageLayouts;
import com.core.library.builder.pdfbuilderlibrary.containers.DocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.SectionContainer;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IDocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.interfaces.IPageContainer;
import com.core.library.builder.pdfbuilderlibrary.model.Document;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import com.core.library.builder.pdfbuilderlibrary.utils.PageUtility;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PdfBuilderLibraryApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PdfBuilderLibraryApplication.class, args);

		Document userDoccumentModel = new Document();
		userDoccumentModel.name = "demo.pdf";
		userDoccumentModel.totalPages = 1;
		DocumentContainer documentContainer = new DocumentContainer();
		documentContainer.createDocumentContainer(userDoccumentModel);

		Page page = new Page();
		page.pageNumber = 0;
		page.pageLayoutSize = PageUtility.getPageSize(PageLayouts.A4);
		PageContainer pageContainer = new PageContainer();
		pageContainer.createPage(page);
		documentContainer.addPageContainerToDocumentContainer(pageContainer);

		Section section = new Section();
		section.sectionNumber = 0;
		section.x = 1.0F;
		section.y = 500.0F;
		SectionContainer sectionContainer = new SectionContainer(documentContainer, pageContainer).createSection(section);

		Text textModel = new Text();
		textModel.text = "In this code, the splitTextIntoLines method is " +
				"introduced to break the text into lines that fit within the specified width. " +
				"Then, each line of text is drawn separately, adjusting the Y coordinate for each line to " +
				"position them correctly within the row. This should ensure that the text " +
				"is wrapped and displayed within the row boundaries.This should ensure that the text " +
				"is wrapped and displayed within the row boundaries. This should ensure that the text " +
				"is wrapped and displayed within the row boundaries.";
		//textModel.text = "Hello";
		textModel.fontSize = 8;
		textModel.fontType = Standard14Fonts.FontName.HELVETICA;

		sectionContainer.setTextInSection(textModel);

		documentContainer.saveDocument();
		documentContainer.closeDocument();
	}

}
