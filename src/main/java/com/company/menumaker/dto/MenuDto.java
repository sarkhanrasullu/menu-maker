package com.company.menumaker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    private String title;
    private String images;
    private String videos;
    private String pdf;
    private String description;
    private Double price;
    private String size;
    private Integer parentId;
    private Integer pageId;
    private Integer state;
}
