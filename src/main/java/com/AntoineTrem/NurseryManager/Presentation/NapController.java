package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.NapContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.NapService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nap")
public class NapController {

    private NapService service;

    public NapController(NapService service){this.service = service;}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody NapDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<NapContainer> getAll()
    {
        List<NapDTO> list = service.getAll();
        return ResponseEntity.ok(new NapContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NapDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/baby/{id}")
    public ResponseEntity<NapContainer> getAllByBaby(@PathVariable int id) throws ElementNotFoundException
    {
        List<NapDTO> list = service.getAllByBaby(id);
        return ResponseEntity.ok(new NapContainer(list, list.size()));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody NapDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NapDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        NapDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
