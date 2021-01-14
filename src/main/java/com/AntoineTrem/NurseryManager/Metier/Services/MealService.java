package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Meal;
import com.AntoineTrem.NurseryManager.DAL.Repositories.MealRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.MealAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.MealNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService implements CrudService<MealDTO, Integer>{

    @Autowired
    private MealMapper mapper;

    @Autowired
    private MealRepository repo;

    @Override
    public void create(MealDTO toCreate) throws ElementAlreadyExistException {
        if (repo.existsById(toCreate.getId()))
            throw new MealAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public MealDTO getOne(Integer id) throws ElementNotFoundException {
        Meal entity = repo.findById(id)
                .orElseThrow(() -> new MealNotFoundException(id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<MealDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MealDTO> getAllByBaby(int babyId)
    {
        List<Meal> meals = repo.findAllByBabyId(babyId);
        return meals.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(MealDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new MealNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new MealNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
