package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Observation;
import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper.SmallBabyMapper;
import com.AntoineTrem.NurseryManager.Toolbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ObservationMapper implements Mapper<ObservationDTO, Observation> {

    @Autowired
    private SmallBabyMapper babyMapper;

    @Override
    public ObservationDTO toDTO(Observation observation) {
        if (observation == null) return null;

        ObservationDTO obsDTO = new ObservationDTO();

        obsDTO.setId(observation.getId());
        obsDTO.setBaby(babyMapper.toDTO(observation.getBaby()));
        obsDTO.setObservation(observation.getObservation());
        obsDTO.setObsAuthor(observation.getObsAuthor());
        obsDTO.setObservationDate(observation.getObservationDate());

        return obsDTO;
    }

    @Override
    public Observation toEntity(ObservationDTO observationDTO) {
        if(observationDTO == null )return null;

        Observation obs = new Observation();

        obs.setId(observationDTO.getId());
        obs.setBaby(babyMapper.toEntity(observationDTO.getBaby()));
        obs.setObsAuthor(observationDTO.getObsAuthor());
        obs.setObservation(observationDTO.getObservation());
        obs.setObservationDate(observationDTO.getObservationDate());

        return obs;
    }
}
