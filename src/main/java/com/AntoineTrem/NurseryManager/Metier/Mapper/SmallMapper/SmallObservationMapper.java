package com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Observation;
import com.AntoineTrem.NurseryManager.Metier.Mapper.Mapper;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallObservationDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallObservationMapper implements Mapper<SmallObservationDTO, Observation> {
    @Override
    public SmallObservationDTO toDTO(Observation observation) {
        if(observation == null) return null;

        SmallObservationDTO smallObservationDTO = new SmallObservationDTO();

        smallObservationDTO.setId(observation.getId());
        smallObservationDTO.setBabyId(observation.getBaby().getId());
        smallObservationDTO.setObservation(observation.getObservation());
        smallObservationDTO.setObsAuthor(observation.getObsAuthor());
        smallObservationDTO.setObservationDate(observation.getObservationDate());
        smallObservationDTO.setObservationTime(observation.getObservationTime());

        return smallObservationDTO;
    }

    @Override
    public Observation toEntity(SmallObservationDTO smallObservationDTO) {
       return null;

    }
}
