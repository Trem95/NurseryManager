package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.ObservationContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.ObservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/observation")
public class ObservationController {

    private ObservationService service;

    public ObservationController(ObservationService service) {this.service = service;}

    @PostMapping
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
    public ResponseEntity<ObservationContainer> getAllByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")Date date) throws ElementNotFoundException
    {
        //TODO EFFACER TEST
        List<ObservationDTO> list = service.getAllByDate(date);
        System.out.println("AAAAAAAAAAAAAAAAAAAA");
        for (ObservationDTO observationDTO :  list) {
            System.out.println(observationDTO.getObservationDate());
        }
        System.out.println("AAAAAAAAAAAAAAAAAAAA");

        return ResponseEntity.ok(new ObservationContainer(list,list.size()));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ObservationDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObservationDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        ObservationDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
