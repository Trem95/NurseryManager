package com.AntoineTrem.NurseryManager.DAL.Repositories;

import com.AntoineTrem.NurseryManager.DAL.Entities.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet,Integer> {

    public List<Timesheet> findAllByBabyId(int babyId);
}
