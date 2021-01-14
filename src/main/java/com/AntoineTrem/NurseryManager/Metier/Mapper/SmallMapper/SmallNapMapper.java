package com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Nap;
import com.AntoineTrem.NurseryManager.Metier.Mapper.Mapper;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallNapDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallNapMapper implements Mapper<SmallNapDTO, Nap> {
    @Override
    public SmallNapDTO toDTO(Nap nap) {
        if (nap == null) return null;

        SmallNapDTO smallNapDTO = new SmallNapDTO();

        smallNapDTO.setId(nap.getId());
        smallNapDTO.setBabyId(nap.getBaby().getId());
        smallNapDTO.setNapObs(nap.getNapObs());
        smallNapDTO.setNapTimeBegin(nap.getNapTimeBegin());
        smallNapDTO.setNapTimeEnd(nap.getNapTimeEnd());

        return smallNapDTO;
    }

    @Override
    public Nap toEntity(SmallNapDTO smallNapDTO) {
       return null;
    }
}
