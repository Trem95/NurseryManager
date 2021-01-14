package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Paednurse;
import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;
import org.springframework.stereotype.Component;

@Component
public class PaednurseMapper implements Mapper<PaednurseDTO, Paednurse>{
    @Override
    public PaednurseDTO toDTO(Paednurse paednurse) {
        if(paednurse == null) return null;

        PaednurseDTO paednurseDTO = new PaednurseDTO();

        paednurseDTO.setId(paednurse.getId());
        paednurseDTO.setName(paednurse.getName());
        paednurseDTO.setLogin(paednurse.getLogin());
        paednurseDTO.setPwd(paednurse.getPwd());

        return paednurseDTO;
    }

    @Override
    public Paednurse toEntity(PaednurseDTO paednurseDTO) {
        if(paednurseDTO == null) return null;

        Paednurse paednurse = new Paednurse();

        paednurse.setId(paednurseDTO.getId());
        paednurse.setName(paednurseDTO.getName());
        paednurse.setLogin(paednurseDTO.getLogin());
        paednurse.setPwd(paednurseDTO.getPwd());

        return paednurse;
    }
}
