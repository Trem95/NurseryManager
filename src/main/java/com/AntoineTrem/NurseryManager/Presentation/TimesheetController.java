package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.TimesheetContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
@CrossOrigin("*")
public class TimesheetController {

    private TimesheetService service;

    public TimesheetController(TimesheetService service){this.service = service;}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TimesheetDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<TimesheetContainer> getAll()
    {
        List<TimesheetDTO> list = service.getAll();
        return ResponseEntity.ok(new TimesheetContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimesheetDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/baby/{id}")
    public ResponseEntity<TimesheetContainer> getAllByBaby(@PathVariable int id) throws ElementNotFoundException
    {
        List<TimesheetDTO> list = service.getAllByBaby(id);
        return ResponseEntity.ok(new TimesheetContainer(list,list.size()));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody TimesheetDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TimesheetDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        TimesheetDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
