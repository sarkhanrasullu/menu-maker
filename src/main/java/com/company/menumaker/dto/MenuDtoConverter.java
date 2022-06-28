package com.company.menumaker.dto;

import com.company.menumaker.entities.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuDtoConverter {
    public MenuDto converter(Menu menu){
        return MenuDto.builder()
                .title(menu.getTitle())
                .images(menu.getImages())
                .videos(menu.getVideos())
                .pdf(menu.getPdf())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .size(menu.getSize())
                .parentId(menu.getParentId())
                .pageId(menu.getPageId())
                .state(menu.getState())
                .build();
    }
}
