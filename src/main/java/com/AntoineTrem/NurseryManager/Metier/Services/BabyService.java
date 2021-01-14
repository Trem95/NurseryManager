package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Baby;
import com.AntoineTrem.NurseryManager.DAL.Repositories.BabyRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.BabyAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.BabyNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.PresBabyDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.BabyMapper;
import com.AntoineTrem.NurseryManager.Metier.Mapper.PresBabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabyService implements CrudService<BabyDTO, Integer>{

    @Autowired
    private BabyMapper mapper;

    @Autowired
    private PresBabyMapper presMapper;

    @Autowired
    private BabyRepository repo;

    @Override
    public void create( BabyDTO toCreate) throws ElementAlreadyExistException {
        if (repo.existsById(toCreate.getId()))
            throw new BabyAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public BabyDTO getOne(Integer id) throws ElementNotFoundException {
        return null;
    }

    @Transactional
    public PresBabyDTO getOnePres(Integer id) throws ElementNotFoundException
    {
        Baby entity = repo.findById(id)
                .orElseThrow(() -> new BabyNotFoundException(id));
        return presMapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<BabyDTO> getAll() {
        return null;
    }

    @Transactional
    public List<PresBabyDTO> getAllPres()
    {
        return repo.findAll()
                .stream()
                .map(presMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(BabyDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new BabyNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new BabyNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
