package com.company.menumaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;
}
