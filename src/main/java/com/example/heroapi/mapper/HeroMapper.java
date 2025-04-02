package com.example.heroapi.mapper;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.model.Hero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {
    HeroDTO toDto(Hero hero);
    Hero toEntity(HeroDTO heroDTO);
    List<HeroDTO> toDtoList(List<Hero> heroes);
}
