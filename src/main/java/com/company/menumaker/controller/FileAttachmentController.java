package com.company.menumaker.controller;

import com.company.menumaker.entity.FileAttachment;
import com.company.menumaker.exception.FileExtensionNotMatchException;
import com.company.menumaker.model.ResponseData;
import com.company.menumaker.service.FileAttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
public class FileAttachmentController {

    private final FileAttachmentService attachmentService;

    public FileAttachmentController(FileAttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping(value = "/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (!Objects.requireNonNull(file.getContentType()).endsWith("pdf")) {
            throw new FileExtensionNotMatchException("The file which you are trying to upload must be PDF format");
        }
        FileAttachment fileAttachment = attachmentService.saveFileAttachment(file);
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileAttachment.getId())
                .toUriString();

        return new ResponseData(fileAttachment.getFileName(), downloadUrl, file.getContentType(), file.getSize());

    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        FileAttachment fileAttachment = attachmentService.getFileAttachment(fileId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileAttachment.getFileName() + "\"")
                .body(new ByteArrayResource(fileAttachment.getData()));
    }
}
