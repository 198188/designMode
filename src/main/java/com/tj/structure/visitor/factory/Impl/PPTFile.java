package com.tj.structure.visitor.factory.Impl;

import com.tj.structure.visitor.factory.ResourceFile;
import com.tj.structure.visitor.factory.constant.ResourceFileType;

public class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PPT;
    }
}

