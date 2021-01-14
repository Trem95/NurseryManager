package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.*;
import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallMealDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallNapDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallTimesheetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BabyMapper implements Mapper<BabyDTO, Baby>{

    @Autowired
    private Mapper<SmallMealDTO, Meal> mapperMeal;

    @Autowired
    private Mapper<SmallNapDTO, Nap> mapperNap;

    @Autowired
    private Mapper<SmallObservationDTO, Observation> mapperObservation;

    @Autowired
    private Mapper<SmallTimesheetDTO, Timesheet> mapperTimesheet;

    @Override
    public BabyDTO toDTO(Baby baby) {

        if (baby == null) return null;

        BabyDTO babyDTO = new BabyDTO();

        babyDTO.setId(baby.getId());
        babyDTO.setName(baby.getName());
        if (baby.getMeals() != null)
        {
            babyDTO.setMeals(baby.getMeals().stream()
            .map(mapperMeal::toDTO).collect(Collectors.toList()));
        }

        if (baby.getNaps() != null)
        {
            babyDTO.setNaps(baby.getNaps().stream()
                    .map(mapperNap::toDTO).collect(Collectors.toList()));
        }

        if (baby.getObservations() != null)
        {
            babyDTO.setObservations(baby.getObservations().stream()
                    .map(mapperObservation::toDTO).collect(Collectors.toList()));
        }

        if (baby.getTimesheets() != null)
        {
            babyDTO.setTimesheets(baby.getTimesheets().stream()
                    .map(mapperTimesheet::toDTO).collect(Collectors.toList()));
        }

        return babyDTO;
    }

    @Override
    public Baby toEntity(BabyDTO babyDTO) {

        if(babyDTO == null)return null;

        Baby baby = new Baby();

        baby.setId(babyDTO.getId());
        baby.setName(babyDTO.getName());

        if (babyDTO.getMeals() != null)
        {
            baby.setMeals(babyDTO.getMeals().stream()
            .map(mapperMeal::toEntity).collect(Collectors.toList()));
        }

        if (babyDTO.getNaps() != null )
        {
            baby.setNaps(babyDTO.getNaps().stream()
            .map(mapperNap::toEntity).collect(Collectors.toList()));
        }

        if (babyDTO.getObservations() != null)
        {
            baby.setObservations(babyDTO.getObservations().stream()
                    .map(mapperObservation::toEntity).collect(Collectors.toList()));
        }

        if (babyDTO.getTimesheets() != null)
        {
            baby.setTimesheets(babyDTO.getTimesheets().stream()
            .map(mapperTimesheet::toEntity).collect(Collectors.toList()));
        }

        return baby;
    }
}
