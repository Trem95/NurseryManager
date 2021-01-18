package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Timesheet;
import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper.SmallBabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class TimesheetMapper implements Mapper<TimesheetDTO, Timesheet> {

    @Autowired
    private SmallBabyMapper babyMapper;

    @Override
    public TimesheetDTO toDTO(Timesheet timesheet) {
        if( timesheet == null) return null;

        TimesheetDTO timesheetDTO = new TimesheetDTO();

        timesheetDTO.setId(timesheet.getId());
        timesheetDTO.setBaby(babyMapper.toDTO(timesheet.getBaby()));
        timesheetDTO.setTimesheetDate(timesheet.getTimesheetDate());
        timesheetDTO.setArrivalTime(timesheet.getArrivalTime());
        timesheetDTO.setLeaveTime(timesheet.getLeaveTime());

        return timesheetDTO;
    }

    @Override
    public Timesheet toEntity(TimesheetDTO timesheetDTO) {
        if (timesheetDTO == null) return null;

        Timesheet timesheet = new Timesheet();

        timesheet.setId(timesheetDTO.getId());
        timesheet.setBaby(babyMapper.toEntity(timesheetDTO.getBaby()));
        timesheet.setTimesheetDate(timesheetDTO.getTimesheetDate());
        timesheet.setArrivalTime(timesheetDTO.getArrivalTime());
        timesheet.setLeaveTime(timesheetDTO.getLeaveTime());

        return timesheet;
    }
}
