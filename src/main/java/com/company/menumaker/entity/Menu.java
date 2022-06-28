package com.company.menumaker.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "images")
    private String images;

    @Column(name = "videos")
    private String videos;

    @Column(name = "description")
    private String description ;

    @Column(name = "price")
    private Double price;

    @Column(name = "size")
    private String size;

    @Column(name = "pdf")
    private String pdf;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "page_id")
    private Integer pageId;

    @Column(name = "state", nullable = false)
    private Integer state;

}
