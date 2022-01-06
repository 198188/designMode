package com.tj.structure.visitor;

import com.tj.structure.visitor.Impl.PPTFile;
import com.tj.structure.visitor.Impl.PdfFile;
import com.tj.structure.visitor.Impl.WordFile;

public interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(PPTFile pdfFile);

    void visit(WordFile pdfFile);
}