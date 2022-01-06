package com.tj.structure.visitor;

import com.tj.structure.visitor.Impl.PPTFile;
import com.tj.structure.visitor.Impl.PdfFile;
import com.tj.structure.visitor.Impl.WordFile;

public class Extractor implements Visitor {
    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Extract PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract WORD.");
    }
}