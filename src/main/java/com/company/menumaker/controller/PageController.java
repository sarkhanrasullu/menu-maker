package com.company.menumaker.controller;

import com.company.menumaker.dto.*;
import com.company.menumaker.service.PageService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/menumarker/pages")
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ResponseEntity<List<PageDto>> getAllPages(){

        return ResponseEntity.ok(pageService.getAllPages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageDto> getPageById(@PathVariable Integer id) {
        return ResponseEntity.ok(pageService.getPageDtoId(id));
    }

    @PostMapping
    public ResponseEntity<PageDto> createPage(@RequestBody CreateRequestPage createRequestPage){
        return ResponseEntity.ok(pageService.createPage(createRequestPage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageDto> updatePage(@PathVariable Integer id,
                                                          @RequestBody UpdateRequestPage updateRequestPage) {
        return ResponseEntity.ok(pageService.updatePage(id, updateRequestPage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePageId(@PathVariable Integer id) {
        pageService.deletePageById(id);
        return ResponseEntity.ok().build();
    }
}
