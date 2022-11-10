package com.company.menumaker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "FileAttachment")
@Table(name = "file_attachment")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class FileAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "file_name")
    private @NonNull String fileName;

    @Column(name = "file_type")
    private @NonNull String fileType;

    @Column(name = "data")
    @Lob
    private @NonNull byte[] data;
}
