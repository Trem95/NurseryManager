package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.*;
import com.AntoineTrem.NurseryManager.Metier.DTO.PresBabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallMealDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PresBabyMapper implements Mapper<PresBabyDTO, Baby>{
    @Override
    public PresBabyDTO toDTO(Baby baby) {
        if(baby == null )return null;

        PresBabyDTO presBabyDTO = new PresBabyDTO();

        presBabyDTO.setId(baby.getId());
        presBabyDTO.setName(baby.getName());
        if (baby.getMeals() != null)
        {
            presBabyDTO.setMealsId(baby.getMeals().stream()
            .map(Meal::getId)
            .collect(Collectors.toList()));
        }
        if (baby.getNaps() != null)
        {
            presBabyDTO.setNapsId(baby.getNaps().stream()
            .map(Nap::getId)
            .collect(Collectors.toList()));
        }
        if (baby.getObservations() != null)
        {
            presBabyDTO.setObservationsId(baby.getObservations().stream()
            .map(Observation::getId)
            .collect(Collectors.toList()));
        }
        if (baby.getTimesheets() != null)
        {
            presBabyDTO.setTimesheetId(baby.getTimesheets().stream()
            .map(Timesheet::getId)
            .collect(Collectors.toList()));
        }

        return presBabyDTO;
    }

    @Override
    public Baby toEntity(PresBabyDTO presBabyDTO) {
        return null;
    }
}
