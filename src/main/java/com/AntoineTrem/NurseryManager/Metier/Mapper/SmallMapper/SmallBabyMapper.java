package com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Baby;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SmallBabyMapper implements Mapper<SmallBabyDTO, Baby> {
    @Override
    public SmallBabyDTO toDTO(Baby baby) {
        if(baby == null )return null;

        SmallBabyDTO smallBabyDTO = new SmallBabyDTO();

        smallBabyDTO.setId(baby.getId());
        smallBabyDTO.setName(baby.getName());

        return smallBabyDTO;
    }

    @Override
    public Baby toEntity(SmallBabyDTO smallBabyDTO) {
        if(smallBabyDTO == null) return null;

        Baby baby = new Baby();

        baby.setId(smallBabyDTO.getId());
        baby.setName(smallBabyDTO.getName());

        return baby;
    }
}
