package com.AntoineTrem.NurseryManager.Metier.Services;


import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO, ID> {

    void create(DTO toCreate) throws ElementAlreadyExistException;
    DTO getOne(ID id) throws ElementNotFoundException;
    List<DTO> getAll();
    void update(DTO toUpdate) throws ElementNotFoundException;
    void delete(ID toDelete) throws ElementNotFoundException;
}
