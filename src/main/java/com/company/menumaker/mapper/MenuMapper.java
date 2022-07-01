package com.company.menumaker.mapper;

import com.company.menumaker.dto.MenuDto;
import com.company.menumaker.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    MenuDto menuEntityToMenuDto(Menu menu);

    Menu menuDtoToMenuEntity(MenuDto menuDto);

    List<MenuDto> toDtoList(List<Menu> menus);
}
