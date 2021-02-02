package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Nap;
import com.AntoineTrem.NurseryManager.DAL.Repositories.NapRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.NapAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.NapNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.NapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NapService implements CrudService<NapDTO, Integer>{

    @Autowired
    private NapMapper mapper;

    @Autowired
    private NapRepository repo;

    @Override
    public void create(NapDTO toCreate) throws ElementAlreadyExistException {
        if(repo.existsById(toCreate.getId()))
            throw new NapAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public NapDTO getOne(Integer id) throws ElementNotFoundException {
        Nap entity = repo.findById(id)
            .orElseThrow(() -> new NapNotFoundException(id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<NapDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<NapDTO> getAllByBaby(int babyId)
    {
        return repo.findAllByBabyId(babyId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(NapDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new NapNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new NapNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
