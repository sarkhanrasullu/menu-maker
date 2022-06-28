package com.company.menumaker.dto;

import com.company.menumaker.entities.Page;

import org.springframework.stereotype.Component;

@Component
public class PageDtoConverter {
    public PageDto converter(Page page){
      return PageDto.builder()
              .pageNumber(page.getPageNumber())
              .coverPhoto(page.getCoverPhoto())
              .coverVideo(page.getCoverVideo())
              .menuId(page.getMenuId())
              .state(page.getState())
              .build();
    }
}
