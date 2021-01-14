package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Paednurse;
import com.AntoineTrem.NurseryManager.DAL.Repositories.PaednurseRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.PaednurseAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.PaednurseNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.PaednurseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaednurseService implements CrudService<PaednurseDTO, Integer>{

    @Autowired
    private PaednurseMapper mapper;

    @Autowired
    private PaednurseRepository repo;

    @Override
    public void create(PaednurseDTO toCreate) throws ElementAlreadyExistException {
        if (repo.existsById(toCreate.getId()))
            throw new PaednurseAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public PaednurseDTO getOne(Integer id) throws ElementNotFoundException {
        Paednurse entity = repo.findById(id)
                .orElseThrow(() -> new PaednurseNotFoundException(id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<PaednurseDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(PaednurseDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new PaednurseNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new PaednurseNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
