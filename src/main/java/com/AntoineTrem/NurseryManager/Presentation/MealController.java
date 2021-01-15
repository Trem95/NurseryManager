package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.MealContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService service;

    public MealController(MealService service){this.service = service;}

    @PostMapping("/create")
    public void create(@RequestBody MealDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<MealContainer> getAll()
    {
        List<MealDTO> list = service.getAll();
        return ResponseEntity.ok(new MealContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/baby/{id}")
    public ResponseEntity<MealContainer> getAlLByBaby(@PathVariable int id) throws ElementNotFoundException
    {
        List<MealDTO> list = service.getAllByBaby(id);
        return ResponseEntity.ok( new MealContainer(list, list.size()));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody MealDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MealDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        MealDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
