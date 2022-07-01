package com.company.menumaker.mapper;

import com.company.menumaker.dto.PageDto;
import com.company.menumaker.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PageMapper {
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);

    PageDto pageEntityToPageDto(Page page);

    Page pageDtoToPageEntity(PageDto pageDto);

    List<PageDto> toDtoList(List<Page> pages);
}
