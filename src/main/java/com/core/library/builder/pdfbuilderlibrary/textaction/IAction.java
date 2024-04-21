package com.core.library.builder.pdfbuilderlibrary.textaction;

import com.core.library.builder.pdfbuilderlibrary.model.Text;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

public interface IAction {

    String setClick(Text text, PDAnnotationLink txtLink);

}
