package com.core.library.builder.pdfbuilderlibrary;

import com.core.library.builder.pdfbuilderlibrary.constants.PageLayouts;
import com.core.library.builder.pdfbuilderlibrary.containers.DocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.SectionController;
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

		Document userDocumentModel = new Document();
		userDocumentModel.name = "demo.pdf";
		userDocumentModel.totalPages = 2;
		DocumentContainer documentContainer = new DocumentContainer();
		documentContainer.createDocumentContainer(userDocumentModel);

		Page page = new Page();
		page.pageNumber = 0;
		page.pageLayoutSize = PageUtility.getPageSize(PageLayouts.A4);
		PageContainer pageContainer = new PageContainer();
		pageContainer.createPage(page);
		documentContainer.addPageContainerToDocumentContainer(pageContainer);

		SectionController sectionController = new SectionController(documentContainer, pageContainer);
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
		textModel.fontType = Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE;
		Section section = new Section();
		section.sectionNumber = 0;
		section.width = 300F;
		section.x = 10.0F;
		section.y = 600.0F;
		sectionController.createSectionContainerAndSetText(section, textModel);

		Text textModelP1 = new Text();
		textModelP1.text = "In this code, the splitTextIntoLines method is " +
				"introduced to break the text into lines that fit within the specified width.";
		textModelP1.fontSize = 6;
		textModelP1.fontType = Standard14Fonts.FontName.COURIER_BOLD;
		Section sectionP1 = new Section();
		sectionP1.sectionNumber = 1;
		sectionP1.width = 100F;
		sectionP1.x = 100.0F;
		sectionP1.y = 200.0F;
		sectionController.createSectionContainerAndSetText(sectionP1, textModelP1);

		sectionController.closeDrawingStream();



		//---------------------------------------------------------

		Page page2 = new Page();
		page2.pageNumber = 0;
		page2.pageLayoutSize = PageUtility.getPageSize(PageLayouts.A4);
		PageContainer pageContainer2 = new PageContainer();
		pageContainer2.createPage(page2);
		documentContainer.addPageContainerToDocumentContainer(pageContainer2);


		SectionController sectionController2 = new SectionController(documentContainer, pageContainer2);
		Text textModel2 = new Text();
		textModel2.text = "In another page, the splitTextIntoLines method is " +
				"introduced to break the text into lines that fit within the specified width. " +
				"Then, each line of text is drawn separately, adjusting the Y coordinate for each line to " +
				"position them correctly within the row. This should ensure that the text " +
				"is wrapped and displayed within the row boundaries.This should ensure that the text " +
				"is wrapped and displayed within the row boundaries. This should ensure that the text " +
				"is wrapped and displayed within the row boundaries.";
		//textModel.text = "Hello";
		textModel2.fontSize = 8;
		textModel2.fontType = Standard14Fonts.FontName.TIMES_ROMAN;

		Section section2 = new Section();
		section2.sectionNumber = 0;
		section2.width = 300F;
		section2.x = 100.0F;
		section2.y = 300.0F;
		sectionController2.createSectionContainerAndSetText(section2, textModel2);


		Text textModel01 = new Text();
		textModel01.text = "In another section2222222. In this code, the splitTextIntoLines method is " +
				"introduced to break the text into lines that fit within the specified width. " +
				"Then, each line of text is drawn separately, adjusting the Y coordinate for each line to " +
				"position them correctly within the row.";
		textModel01.fontSize = 8;
		textModel01.fontType = Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE;

		Section section01 = new Section();
		section01.sectionNumber = 1;
		section01.width = 300F;
		section01.x = 4.0F;
		section01.y = 40.0F;
		sectionController2.createSectionContainerAndSetText(section01, textModel01);
		sectionController2.closeDrawingStream();

		//-----------------------------------------------------------------


		documentContainer.saveDocument();
		documentContainer.closeDocument();


	}

}
