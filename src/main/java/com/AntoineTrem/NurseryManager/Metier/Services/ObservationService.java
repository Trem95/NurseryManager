package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Observation;
import com.AntoineTrem.NurseryManager.DAL.Repositories.ObservationRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ObservationAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ObservationNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.ObservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservationService implements CrudService<ObservationDTO, Integer>{

    @Autowired
    private ObservationMapper mapper;

    @Autowired
    private ObservationRepository repo;

    @Override
    public void create(ObservationDTO toCreate) throws ElementAlreadyExistException {
        if (repo.existsById(toCreate.getId()))
            throw new ObservationAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public ObservationDTO getOne(Integer id) throws ElementNotFoundException {
        Observation entity = repo.findById(id)
                .orElseThrow(() -> new ObservationNotFoundException(id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<ObservationDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ObservationDTO> getAllByBaby(int babyId)
    {
        return repo.findAllByBabyId(babyId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ObservationDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new ObservationNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if(!repo.existsById(toDelete))
            throw new ObservationNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }

    @Transactional
    public List<ObservationDTO> getAllByDate(Date date) throws ElementNotFoundException
    {
        List<Observation> observations = repo.findAllByObservationDate(date);
        return observations.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<ObservationDTO> getAllByDateAndBabyId(Date date, int babyId) throws ElementNotFoundException
    {
        List<Observation> observations = repo.findAllByObservationDateAndBaby_Id(date,babyId);
        return observations.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
