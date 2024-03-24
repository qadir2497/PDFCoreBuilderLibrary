package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;

import java.io.IOException;

public interface ISectionController {

    ISectionController createSectionContainerAndSetText(Section pSection, Text textModel) throws IOException;
}
