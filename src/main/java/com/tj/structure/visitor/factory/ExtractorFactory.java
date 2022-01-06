package com.tj.structure.visitor.factory;

import com.tj.structure.visitor.factory.Impl.PPTExtractor;
import com.tj.structure.visitor.factory.Impl.PdfExtractor;
import com.tj.structure.visitor.factory.Impl.WordExtractor;
import com.tj.structure.visitor.factory.constant.ResourceFileType;

import java.util.HashMap;
import java.util.Map;

public class ExtractorFactory {
    private static final Map<ResourceFileType, Extractor> extractors = new HashMap<>();

    static {
        extractors.put(ResourceFileType.PDF, new PdfExtractor());
        extractors.put(ResourceFileType.Word, new WordExtractor());
        extractors.put(ResourceFileType.PPT, new PPTExtractor());
    }

    public static Extractor getExtractor(ResourceFileType resourceFileType) {
        return extractors.get(resourceFileType);
    }
}
