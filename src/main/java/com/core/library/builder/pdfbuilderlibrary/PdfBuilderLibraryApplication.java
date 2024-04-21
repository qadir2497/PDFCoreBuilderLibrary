package com.core.library.builder.pdfbuilderlibrary;

import com.core.library.builder.pdfbuilderlibrary.constants.PageLayouts;
import com.core.library.builder.pdfbuilderlibrary.containers.ContentStream;
import com.core.library.builder.pdfbuilderlibrary.containers.DocumentContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.PageContainer;
import com.core.library.builder.pdfbuilderlibrary.containers.SectionController;
import com.core.library.builder.pdfbuilderlibrary.enums.TextType;
import com.core.library.builder.pdfbuilderlibrary.model.Document;
import com.core.library.builder.pdfbuilderlibrary.model.Page;
import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;
import com.core.library.builder.pdfbuilderlibrary.utils.PDFontType;
import com.core.library.builder.pdfbuilderlibrary.utils.PageUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.HELVETICA;

@SpringBootApplication
public class PdfBuilderLibraryApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PdfBuilderLibraryApplication.class, args);

		Document userDocumentModel = new Document();
		userDocumentModel.name = "demo.pdf";
		userDocumentModel.totalPages = 1;
		DocumentContainer documentContainer = new DocumentContainer();
		documentContainer.createDocumentContainer(userDocumentModel);

		Page page = new Page();
		page.pageNumber = 0;
		page.pageLayoutSize = PageUtility.getPageSize(PageLayouts.A4);
		ContentStream contentStream = new ContentStream();
		PageContainer pageContainer = new PageContainer();
		pageContainer.createPage(page);
		documentContainer.addPageContainerToDocumentContainer(pageContainer, contentStream);


		SectionController sectionController = new SectionController(documentContainer, pageContainer, contentStream);

		Section section = new Section();
		section.x = 33.0F;
		section.y = 800.0F;
		section.numberOfLines = 1;
		section.sectionNumber = 1;
		Text textModel = new Text();
		textModel.text = "o DETAILS o";
		textModel.fontSize = 8;
		textModel.fontType = Standard14Fonts.FontName.HELVETICA_BOLD;
		sectionController.createSectionContainerAndSetText(section, textModel);

		Section section2 = new Section();
		section2.x = 12.0F;
		section2.y = 790.0F;
		section2.numberOfLines = 1;
		section2.sectionNumber = 2;
		Text textModel2 = new Text();
		textModel2.text = "Suite 104, 110, Douglas Street";
		textModel2.fontSize = 8;
		textModel2.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section2, textModel2);

		Section section3 = new Section();
		section3.x = 35.0F;
		section3.y = 780.0F;
		section3.numberOfLines = 1;
		section3.sectionNumber = 3;
		Text textModel3 = new Text();
		textModel3.text = "Victoria";
		textModel3.fontSize = 8;
		textModel3.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section3, textModel3);

		Section section4 = new Section();
		section4.x = 35.0F;
		section4.y = 770.0F;
		section4.numberOfLines = 1;
		section4.sectionNumber = 4;
		Text textModel4 = new Text();
		textModel4.text = "Canada";
		textModel4.fontSize = 8;
		textModel4.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section4, textModel4);

		Section section5 = new Section();
		section5.x = 23.0F;
		section5.y = 760.0F;
		section5.numberOfLines = 1;
		section5.sectionNumber = 4;
		Text textModel5 = new Text();
		textModel5.text = "+1 (778) 725-0152";
		textModel5.fontSize = 8;
		textModel5.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section5, textModel5);

		Section section6 = new Section();
		section6.x = 18.0F;
		section6.y = 750.0F;
		section6.numberOfLines = 1;
		section6.sectionNumber = 4;
		Text textModel6 = new Text();
		textModel6.isClickable = true;
		textModel6.text = "qadir.portal@gmail.com";
		textModel6.linkValue = "qadir.portal@gmail.com";
		textModel6.types = new ArrayList<>();
		textModel6.types.add(TextType.EMAIL);
		textModel6.fontSize = 8;
		textModel6.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section6, textModel6);

		Section section7 = new Section();
		section7.x = 35.0F;
		section7.y = 740.0F;
		section7.numberOfLines = 1;
		section7.sectionNumber = 5;
		Text textModel7 = new Text();
		textModel7.isClickable = true;
		textModel7.text = "LinkedIn";
		textModel7.types = new ArrayList<>();
		textModel7.types.add(TextType.LINK);
		textModel7.types.add(TextType.LINE);
		textModel7.linkValue = "https://www.linkedin.com/in/abdul-qadir-25b233b7/";
		textModel7.fontSize = 8;
		textModel7.fontType = Standard14Fonts.FontName.HELVETICA;
		sectionController.createSectionContainerAndSetText(section7, textModel7);

//		Section section8 = new Section();
//		section8.x = 35.0F;
//		section8.y = 739.0F;
//		section8.numberOfLines = 1;
//		section8.sectionNumber = 6;
//		Text textModel8 = new Text();
//		textModel8.type = TextType.LINE;
//		textModel8.text = "LinkedIn";
//		textModel8.fontSize = 6;
//		textModel8.fontType = Standard14Fonts.FontName.HELVETICA;
//		sectionController.createSectionContainerAndSetText(section8, textModel8);

//		Text textModelP1 = new Text();
//		textModelP1.text = "In this code, the splitTextIntoLines method is " +
//				"introduced to break the text into lines that fit within the specified width.";
//		textModelP1.fontSize = 6;
//		textModelP1.fontType = Standard14Fonts.FontName.COURIER_BOLD;
//		textModelP1.text = "x";
//		Section sectionP1 = new Section();
//		sectionP1.sectionNumber = 1;
//		sectionP1.width = 1F;
//		sectionP1.height = 100F;
//		sectionP1.x = 400.0F;
//		sectionP1.y = 40.0F;
//		sectionController.createSectionContainerAndSetText(sectionP1, textModelP1);

		//sectionController.closeDrawingStream();



		//---------------------------------------------------------

//		Page page2 = new Page();
//		page2.pageNumber = 0;
//		page2.pageLayoutSize = PageUtility.getPageSize(PageLayouts.A4);
//		PageContainer pageContainer2 = new PageContainer();
//		pageContainer2.createPage(page2);
//		documentContainer.addPageContainerToDocumentContainer(pageContainer2);
//
//
//		SectionController sectionController2 = new SectionController(documentContainer, pageContainer2);
//		Text textModel2 = new Text();
//		textModel2.text = "In another page, the splitTextIntoLines method is " +
//				"introduced to break the text into lines that fit within the specified width. " +
//				"Then, each line of text is drawn separately, adjusting the Y coordinate for each line to " +
//				"position them correctly within the row. This should ensure that the text " +
//				"is wrapped and displayed within the row boundaries.This should ensure that the text " +
//				"is wrapped and displayed within the row boundaries. This should ensure that the text " +
//				"is wrapped and displayed within the row boundaries.";
//		//textModel.text = "Hello";
//		textModel2.fontSize = 8;
//		textModel2.fontType = Standard14Fonts.FontName.TIMES_ROMAN;
//
//		Section section2 = new Section();
//		section2.sectionNumber = 0;
//		section2.width = 300F;
//		section2.x = 100.0F;
//		section2.y = 300.0F;
//		sectionController2.createSectionContainerAndSetText(section2, textModel2);
//
//
//		Text textModel01 = new Text();
//		textModel01.text = "In another section2222222. In this code, the splitTextIntoLines method is " +
//				"introduced to break the text into lines that fit within the specified width. " +
//				"Then, each line of text is drawn separately, adjusting the Y coordinate for each line to " +
//				"position them correctly within the row.";
//		textModel01.fontSize = 8;
//		textModel01.fontType = Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE;
//
//		Section section01 = new Section();
//		section01.sectionNumber = 1;
//		section01.width = 300F;
//		section01.x = 4.0F;
//		section01.y = 40.0F;
//		sectionController2.createSectionContainerAndSetText(section01, textModel01);
//		sectionController2.closeDrawingStream();

		//-----------------------------------------------------------------


		contentStream.closeContentStream(contentStream.getCurrentContentStream());
		documentContainer.saveDocument();
		documentContainer.closeDocument();


	}

}
