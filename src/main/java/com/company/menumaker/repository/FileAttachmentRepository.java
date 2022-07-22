package com.company.menumaker.repository;

import com.company.menumaker.entity.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileAttachmentRepository extends JpaRepository<FileAttachment, String> {
}
