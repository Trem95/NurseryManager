package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.PaednurseContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.PaednurseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paednurse")
public class PaednurseController {

    private PaednurseService service;

    public PaednurseController(PaednurseService service){this.service = service;}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PaednurseDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<PaednurseContainer> getAll()
    {
        List<PaednurseDTO> list = service.getAll();
        return ResponseEntity.ok(new PaednurseContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaednurseDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody PaednurseDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaednurseDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        PaednurseDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
