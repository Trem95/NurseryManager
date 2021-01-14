package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Nap;
import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper.SmallBabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class NapMapper implements Mapper<NapDTO, Nap> {

    @Autowired
    private SmallBabyMapper babyMapper;

    @Override
    public NapDTO toDTO(Nap nap) {
        if (nap == null ) return null;

        NapDTO napDTO = new NapDTO();

        napDTO.setId(nap.getId());
        napDTO.setBaby(babyMapper.toDTO(nap.getBaby()));
        napDTO.setNapTimeBegin(nap.getNapTimeBegin());
        napDTO.setNapTimeEnd(nap.getNapTimeEnd());
        napDTO.setNapObs(nap.getNapObs());

        return napDTO;
    }

    @Override
    public Nap toEntity(NapDTO napDTO)
    {
        if (napDTO == null )return null;

        Nap nap = new Nap();

        nap.setId(napDTO.getId());
        nap.setBaby(babyMapper.toEntity(napDTO.getBaby()));
        nap.setNapTimeEnd((Date) napDTO.getNapTimeEnd());
        nap.setNapTimeEnd((Date) napDTO.getNapTimeBegin());
        nap.setNapObs(napDTO.getNapObs());

        return nap;
    }
}
