package com.company.menumaker.controller;

import com.company.menumaker.dto.CreateRequestPage;
import com.company.menumaker.dto.PageDto;
import com.company.menumaker.dto.UpdateRequestPage;
import com.company.menumaker.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/page")
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }


    @GetMapping()
    public String getPage(Model model) {
        model.addAttribute("list", pageService.getAllPages());
        return "/page";


    }

    @GetMapping("/new")
    public String getPageNew(Model model) {
        model.addAttribute("menu",new CreateRequestPage());
        return "add-page";


    }

    @PostMapping("/save")
    public String savePage(Model model, @ModelAttribute CreateRequestPage createRequestPage) {
       pageService.createPage(createRequestPage);
        return "redirect:/page";
    }


    @GetMapping("/edit/{id}")
    public String updatePage(@PathVariable Integer id, Model model) {
        Optional<PageDto> optionalPageDto = Optional.ofNullable(pageService.getPageDtoId(id));
        if (optionalPageDto.isEmpty())

            model.addAttribute("page", optionalPageDto.get());
        return "update-menu";
    }

    @PostMapping("/edit/{id}")
    public String updatePageId(@PathVariable Integer id, UpdateRequestPage updateRequestPage ) {
        pageService.updatePage(id,updateRequestPage);
        return "redirect:/page";
    }




}
