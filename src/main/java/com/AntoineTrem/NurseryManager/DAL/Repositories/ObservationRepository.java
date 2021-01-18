package com.AntoineTrem.NurseryManager.DAL.Repositories;

import com.AntoineTrem.NurseryManager.DAL.Entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation,Integer> {

     List<Observation> findAllByBabyId(int babyId);

     List<Observation> findAllByObservationDate(Date date);

     List<Observation> findAllByObservationDateAndBaby_Id(Date date, int babyId);

}
