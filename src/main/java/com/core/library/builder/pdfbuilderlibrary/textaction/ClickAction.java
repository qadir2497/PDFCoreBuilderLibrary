package com.core.library.builder.pdfbuilderlibrary.textaction;

import com.core.library.builder.pdfbuilderlibrary.model.Text;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionLaunch;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

import static com.core.library.builder.pdfbuilderlibrary.enums.TextType.*;

public class ClickAction implements IAction {

    private ClickAction() {}
    private static ClickAction instance = null;

    public static ClickAction getInstance() {
        if(instance == null) {
            instance = new ClickAction();
        }
        return instance;
    }

    @Override
    public String setClick(Text pText, PDAnnotationLink txtLink) {
        //PDAnnotationLink txtLink = new PDAnnotationLink();
//        PDAction action = createAction(pText);
//        txtLink.setAction(action);
        //page.getAnnotations().add(txtLink);
        //return pText.text;
        return null;
    }

//    private PDAction createAction(Text pText) {
//        COSDictionary actionDict = new COSDictionary();
//        actionDict.setName(COSName.TYPE, "Action");
//        actionDict.setName(COSName.S, "URI");
//        switch (pText.types) {
//            case EMAIL: {
//                actionDict.setString(COSName.URI, "mailto:" + pText.linkValue);
//            }
//            case LINK: {
//                actionDict.setString(COSName.URI, pText.linkValue);
//            }
//        }
//        return new PDActionLaunch(actionDict);
//    }

}
