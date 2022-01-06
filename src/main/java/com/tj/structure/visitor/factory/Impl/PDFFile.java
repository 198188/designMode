package com.tj.structure.visitor.factory.Impl;

import com.tj.structure.visitor.factory.ResourceFile;
import com.tj.structure.visitor.factory.constant.ResourceFileType;

public class PDFFile extends ResourceFile {

    public PDFFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }
}
