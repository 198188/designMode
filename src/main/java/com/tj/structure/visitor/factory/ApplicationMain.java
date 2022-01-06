package com.tj.structure.visitor.factory;

import com.tj.structure.visitor.factory.Impl.PDFFile;
import com.tj.structure.visitor.factory.Impl.WordFile;
import com.tj.structure.visitor.factory.Impl.PPTFile;
import com.tj.structure.visitor.factory.constant.ResourceFileType;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {
    public static void main(String[] args) {
        String resourceDirectory = "";
        List<ResourceFile> resourceFiles = listAllResourceFiles(resourceDirectory);
        for (ResourceFile resourceFile : resourceFiles) {
            ResourceFileType type = resourceFile.getType();
            Extractor extractor = ExtractorFactory.getExtractor(type);
            extractor.extract2txt(resourceFile);


        }
    }
    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PDFFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }

}
