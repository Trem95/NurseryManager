package com.AntoineTrem.NurseryManager.DAL.Repositories;

import com.AntoineTrem.NurseryManager.DAL.Entities.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRepository extends JpaRepository<Baby, Integer> {

}
