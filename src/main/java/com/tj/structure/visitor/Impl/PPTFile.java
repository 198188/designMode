package com.tj.structure.visitor.Impl;

import com.tj.structure.visitor.ResourceFile;
import com.tj.structure.visitor.Visitor;

public class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //...
}