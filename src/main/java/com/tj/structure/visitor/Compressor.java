package com.tj.structure.visitor;

import com.tj.structure.visitor.Impl.PPTFile;
import com.tj.structure.visitor.Impl.PdfFile;
import com.tj.structure.visitor.Impl.WordFile;

public class Compressor implements Visitor {
    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Compress PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Compress PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Compress WORD.");
    }
}
