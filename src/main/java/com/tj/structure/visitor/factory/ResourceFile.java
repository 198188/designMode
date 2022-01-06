package com.tj.structure.visitor.factory;

import com.tj.structure.visitor.factory.constant.ResourceFileType;

public abstract class ResourceFile {
    private String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract ResourceFileType getType();
}
