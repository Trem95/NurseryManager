package com.AntoineTrem.NurseryManager;

import com.AntoineTrem.NurseryManager.DAL.Entities.Baby;
import com.AntoineTrem.NurseryManager.DAL.Entities.Meal;
import com.AntoineTrem.NurseryManager.DAL.Entities.Observation;
import com.AntoineTrem.NurseryManager.DAL.Repositories.BabyRepository;
import com.AntoineTrem.NurseryManager.DAL.Repositories.ObservationRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.BabyService;
import com.AntoineTrem.NurseryManager.Metier.Services.ObservationService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws ElementAlreadyExistException, ElementNotFoundException, NoSuchAlgorithmException {
        ApplicationContext ctx =  SpringApplication.run(NurseryManagerApplication.class, args);

//        BabyRepository babyRepo = ctx.getBean(BabyRepository.class);
//        BabyService babyService = ctx.getBean(BabyService.class);
//
       // ObservationRepository obsRepo = ctx.getBean(ObservationRepository.class);
       // ObservationService obsService = ctx.getBean(ObservationService.class);


    }
}
