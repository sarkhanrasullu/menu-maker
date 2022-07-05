package com.company.menumaker.controller;

import com.company.menumaker.dto.CreateRequestMenu;
import com.company.menumaker.dto.MenuDto;
import com.company.menumaker.dto.UpdateRequestMenu;
import com.company.menumaker.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/menus")
public class MenuController {




    private final MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }



    @GetMapping()
    public String getMenu(Model model) {
        model.addAttribute("list", menuService.getAllMenus());
        return "/list";


    }

    @GetMapping("/new")
    public String getMenus(Model model) {
        model.addAttribute("menu",new CreateRequestMenu());
        return "add-menu";


    }

    @PostMapping("/save")
    public String saveMenu(Model model, @ModelAttribute CreateRequestMenu createRequestMenu) {
        menuService.createMenu(createRequestMenu);
        return "redirect:/menus";
    }


    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        Optional<MenuDto> optionalMenuDto = Optional.ofNullable(menuService.getMenuById(id));
        if (optionalMenuDto.isEmpty())

        model.addAttribute("edited", optionalMenuDto.get());
        return "continent/continent-edit";
    }

    @PostMapping("/edit/{id}")
    public String editDepartment(@PathVariable Integer id, UpdateRequestMenu updateRequestMenu ) {
        menuService.updateMenu(id, updateRequestMenu);
        return "redirect:/list";
    }







}
