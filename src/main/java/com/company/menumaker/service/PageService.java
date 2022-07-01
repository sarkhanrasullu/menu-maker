package com.company.menumaker.service;

import com.company.menumaker.dto.*;

import com.company.menumaker.entity.Page;
import com.company.menumaker.mapper.PageMapper;
import com.company.menumaker.repository.PageRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PageService {

    private final PageRepository pageRepository;

    private final PageMapper pageMapper;

    public PageService(PageRepository pageRepository, PageMapper pageMapper) {
        this.pageRepository = pageRepository;
        this.pageMapper = pageMapper;
    }

    public PageDto createPage(CreateRequestPage createRequestPage) {
        Page page = new Page();
        page.setMenuId(createRequestPage.getMenuId());
        page.setPageNumber(createRequestPage.getPageNumber());
        page.setCoverPhoto(createRequestPage.getCoverPhoto());
        page.setCoverVideo(createRequestPage.getCoverVideo());
        page.setState(createRequestPage.getState());
        pageRepository.save(page);
        return pageMapper.pageEntityToPageDto(page);
    }

    public List<PageDto> getAllPages() {
        List<Page> pageList = pageRepository.findAll();
        return pageMapper.toDtoList(pageList);
    }

    public PageDto updatePage(Integer id, UpdateRequestPage updateRequestPage) {
        Optional<Page> pageOptional = pageRepository.findById(id);
        pageOptional.ifPresent(page -> {
            page.setMenuId(page.getMenuId());
            page.setPageNumber(updateRequestPage.getPageNumber());
            page.setCoverPhoto(updateRequestPage.getCoverPhoto());
            page.setCoverVideo(updateRequestPage.getCoverVideo());
            page.setState(updateRequestPage.getState());
        });
        return pageOptional.map(pageMapper::pageEntityToPageDto).orElse(new PageDto());

    }

    public PageDto getPageDtoId(Integer id) {
        Optional<Page> pageOptional = pageRepository.findById(id);
        return pageOptional.map(pageMapper::pageEntityToPageDto).orElse(new PageDto());

    }


    public void deletePageById(Integer id) {
        pageRepository.deleteById(id);
    }

    protected Page getPageId(Integer id) {
        return pageRepository.findById(id).orElse(new Page());
    }
}
