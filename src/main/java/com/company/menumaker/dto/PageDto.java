package com.company.menumaker.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto{

    private Integer menuId;
    private Integer pageNumber;
    private String coverPhoto;
    private String coverVideo;
    private Integer state;

}
