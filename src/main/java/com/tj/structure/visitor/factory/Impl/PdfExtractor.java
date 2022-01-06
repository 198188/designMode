package com.tj.structure.visitor.factory.Impl;

import com.tj.structure.visitor.factory.Extractor;
import com.tj.structure.visitor.factory.ResourceFile;

public class PdfExtractor implements Extractor {
    @Override
    public void extract2txt(ResourceFile resourceFile) {
        System.out.println("Extractor PDF");
    }
}
