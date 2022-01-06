package com.tj.structure.visitor.Impl;

import com.tj.structure.visitor.ResourceFile;
import com.tj.structure.visitor.Visitor;

public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //...
}