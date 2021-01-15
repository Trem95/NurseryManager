package com.AntoineTrem.NurseryManager.Presentation;

import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.Container.BabyContainer;
import com.AntoineTrem.NurseryManager.Metier.DTO.PresBabyDTO;
import com.AntoineTrem.NurseryManager.Metier.Services.BabyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baby")
public class BabyController {

    private BabyService service;

    public BabyController(BabyService service) {this.service = service;}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BabyDTO toCreate) throws ElementAlreadyExistException
    {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<BabyContainer> getAll()
    {
        List<PresBabyDTO> list = service.getAllPres();
        return ResponseEntity.ok(new BabyContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresBabyDTO> getOne(@PathVariable int id) throws ElementNotFoundException
    {
        return ResponseEntity.ok(service.getOnePres(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody BabyDTO toUpdate) throws ElementNotFoundException
    {
        service.update(toUpdate);
        return ResponseEntity.ok("Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BabyDTO> delete(@PathVariable int id) throws ElementNotFoundException
    {
        BabyDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }

}
