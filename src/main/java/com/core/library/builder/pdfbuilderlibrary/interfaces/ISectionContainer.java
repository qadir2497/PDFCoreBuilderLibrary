package com.core.library.builder.pdfbuilderlibrary.interfaces;

import com.core.library.builder.pdfbuilderlibrary.model.Section;
import com.core.library.builder.pdfbuilderlibrary.model.Text;

import java.io.IOException;

public interface ISectionContainer {

    ISectionContainer createSection(Section pSection) throws IOException;
    void setTextInSection(Text pText) throws IOException;
}
