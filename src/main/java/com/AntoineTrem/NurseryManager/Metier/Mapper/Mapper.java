package com.AntoineTrem.NurseryManager.Metier.Mapper;

public interface Mapper <DTO, ENTITY>{

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
