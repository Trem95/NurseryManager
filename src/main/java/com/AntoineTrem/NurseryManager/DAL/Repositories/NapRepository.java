package com.AntoineTrem.NurseryManager.DAL.Repositories;

import com.AntoineTrem.NurseryManager.DAL.Entities.Nap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NapRepository extends JpaRepository<Nap,Integer> {

    public List<Nap> findAllByBabyId(int babyId);


}
