package com.tj.structure.visitor;

import com.tj.structure.visitor.Impl.PPTFile;
import com.tj.structure.visitor.Impl.PdfFile;
import com.tj.structure.visitor.Impl.WordFile;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {
    public static void main(String[] args) {
        String resourceDirectory = "";
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles(resourceDirectory);
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }
        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}
