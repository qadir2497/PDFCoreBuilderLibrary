package com.core.library.builder.pdfbuilderlibrary.records;

import java.util.List;

public record DocumentRecords(Long id,
                              String name,
                              String numberOfPages,
                              int version,
                              String type,
                              Long size,
                              List<PageRecords> pages) { }
