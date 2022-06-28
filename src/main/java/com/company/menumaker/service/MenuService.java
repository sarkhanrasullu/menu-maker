package com.company.menumaker.service;

import com.company.menumaker.dto.*;
import com.company.menumaker.entities.Menu;


import com.company.menumaker.exception.MenuNotFoundException;

import com.company.menumaker.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuDtoConverter menuDtoConverter;

    public MenuService(MenuRepository menuRepository, MenuDtoConverter menuDtoConverter) {
        this.menuRepository = menuRepository;
        this.menuDtoConverter = menuDtoConverter;
    }

    public MenuDto createMenu(CreateRequestMenu createRequestMenu){
        Menu menu= Menu.builder()
                .title(createRequestMenu.getTitle())
                .images(createRequestMenu.getImages())
                .videos(createRequestMenu.getVideos())
                .parentId(createRequestMenu.getParentId())
                .pdf(createRequestMenu.getPdf())
                .description(createRequestMenu.getDescription())
                .price(createRequestMenu.getPrice())
                .size(createRequestMenu.getSize())
                .pageId(createRequestMenu.getPageId())
                .state(createRequestMenu.getState())
                .build();

    return menuDtoConverter.converter(menuRepository.save(menu));

    }

    public MenuDto updateMenu(Integer id, UpdateRequestMenu updateRequestMenu){
        Optional<Menu> optionalMenu=menuRepository.findById(id);
        optionalMenu.ifPresent(menu -> {
           menu.setTitle(updateRequestMenu.getTitle());
           menu.setImages(updateRequestMenu.getImages());
           menu.setVideos(updateRequestMenu.getVideos());
           menu.setPdf(updateRequestMenu.getPdf());
           menu.setDescription(updateRequestMenu.getDescription());
           menu.setPrice(updateRequestMenu.getPrice());
           menu.setSize(updateRequestMenu.getSize());
           menu.setParentId(updateRequestMenu.getParentId());
           menu.setPageId(menu.getPageId());
           menu.setState(updateRequestMenu.getState());
           menuRepository.save(menu);
        });
        return optionalMenu.map(menuDtoConverter::converter).orElse(new MenuDto());

    }


    public MenuDto getByMenuDtoTitle(String  title) {
        Menu menu=findByTitle(title);
        return menuDtoConverter.converter(menu);
    }


    public MenuDto getByMenuDtoPrice(Double  price) {
        Menu menu=findByPrice(price);
        return menuDtoConverter.converter(menu);
    }


    public List<MenuDto> getAllMenus(){
        List<Menu>  restaurantList= menuRepository.findAll();
        return restaurantList.stream().map(menuDtoConverter::converter).collect(Collectors.toList());
    }

    public MenuDto getMenuById(Integer id){
        return menuRepository.findById(id).map(menuDtoConverter::converter).orElse(new MenuDto());

    }

    public void deleteMenuById(Integer id){
        menuRepository.deleteById(id);
    }

    private Menu findByTitle(String title){
        return menuRepository.findByTitle(title)
                .orElseThrow(()-> new MenuNotFoundException("Menu not found"));
    }

    private Menu findByPrice(Double price){
        return menuRepository.findByPrice(price)
                .orElseThrow(()-> new MenuNotFoundException("Menu not found"));
    }




}
