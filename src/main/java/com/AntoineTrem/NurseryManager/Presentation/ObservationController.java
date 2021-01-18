package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.ObservationContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.ObservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/observation")
public class ObservationController {

    private ObservationService service;

    public ObservationController(ObservationService service) {this.service = service;}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody ObservationDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<ObservationContainer> getAll()
    {
        List<ObservationDTO> list = service.getAll();
        return ResponseEntity.ok(new ObservationContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/baby/{id}")
    public ResponseEntity<ObservationContainer> getAllByBaby(@PathVariable int id) throws ElementNotFoundException
    {
        List<ObservationDTO> list = service.getAllByBaby(id);
        return ResponseEntity.ok(new ObservationContainer(list,list.size()));
    }

    @GetMapping("/date")
    public ResponseEntity<ObservationContainer> getAllByDate(@RequestParam("date")  String date) throws ElementNotFoundException, ParseException {
        Date dateOk = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        System.out.println(dateOk);
        List<ObservationDTO> list = service.getAllByDate(dateOk);
        return ResponseEntity.ok(new ObservationContainer(list,list.size()));
    }

    @GetMapping("/date&baby/{babyId}")
    public ResponseEntity<ObservationContainer> getAllByDateAndBabyId(@RequestParam("date") String date,@PathVariable int babyId) throws ElementNotFoundException, ParseException {
        Date dateOk = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<ObservationDTO> list = service.getAllByDateAndBabyId(dateOk,babyId);
        return ResponseEntity.ok(new ObservationContainer(list,list.size()));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ObservationDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ObservationDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        ObservationDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
