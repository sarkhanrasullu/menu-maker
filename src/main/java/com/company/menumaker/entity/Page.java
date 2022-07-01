package com.company.menumaker.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "page")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "page_number")
    private Integer pageNumber;

    @Column(name = "cover_photo")
    private String coverPhoto;

    @Column(name = "cover_video")
    private String coverVideo;

    @Column(name = "state", nullable = false)
    private Integer state;

}
