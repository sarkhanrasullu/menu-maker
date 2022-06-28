package com.company.menumaker.controller;

import com.company.menumaker.dto.*;
import com.company.menumaker.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menumarker/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<MenuDto>> getAllMenus(){

        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDto> getMenuById(@PathVariable Integer id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @PostMapping
    public ResponseEntity<MenuDto> createMenu(@RequestBody CreateRequestMenu createRequestMenu){
        return ResponseEntity.ok(menuService.createMenu(createRequestMenu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable Integer id,
                                              @RequestBody UpdateRequestMenu updateRequestMenu) {
        return ResponseEntity.ok(menuService.updateMenu(id, updateRequestMenu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuId(@PathVariable Integer id) {
        menuService.deleteMenuById(id);
        return ResponseEntity.ok().build();
    }
}
