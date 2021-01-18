package com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Timesheet;
import com.AntoineTrem.NurseryManager.Metier.Mapper.Mapper;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallTimesheetDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallTimesheetMapper implements Mapper<SmallTimesheetDTO, Timesheet> {
    @Override
    public SmallTimesheetDTO toDTO(Timesheet timesheet) {
        if(timesheet == null) return null;

        SmallTimesheetDTO smallTimesheetDTO = new SmallTimesheetDTO();

        smallTimesheetDTO.setId(timesheet.getId());
        smallTimesheetDTO.setBabyId(timesheet.getBaby().getId());
        smallTimesheetDTO.setTimesheetDate(timesheet.getTimesheetDate());
        smallTimesheetDTO.setArrivalTime(timesheet.getArrivalTime());
        smallTimesheetDTO.setLeaveTime(timesheet.getLeaveTime());

        return smallTimesheetDTO;
    }

    @Override
    public Timesheet toEntity(SmallTimesheetDTO smallTimesheetDTO) {
        return null;
    }
}
