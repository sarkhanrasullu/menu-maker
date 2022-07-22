package com.company.menumaker.service;

import com.company.menumaker.entity.FileAttachment;
import com.company.menumaker.model.ResponseData;
import com.company.menumaker.repository.FileAttachmentRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class FileAttachmentService {

    private final FileAttachmentRepository attachmentRepository;


    public FileAttachmentService(FileAttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    public FileAttachment saveFileAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains is invalid characters");
            }
            FileAttachment attachment = new FileAttachment(fileName, Objects.requireNonNull(file.getContentType()), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save the file: " + fileName);
        }
    }

    public FileAttachment getFileAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId).orElseThrow(() -> new Exception("File not found with id: "+ fileId));
    }
}
