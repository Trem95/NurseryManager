package com.AntoineTrem.NurseryManager.Metier.Services;

import com.AntoineTrem.NurseryManager.DAL.Entities.Timesheet;
import com.AntoineTrem.NurseryManager.DAL.Repositories.TimesheetRepository;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.ElementAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.AlreadyExistException.TimesheetAlreadyExistException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.ElementNotFoundException;
import com.AntoineTrem.NurseryManager.Exception.NotFoundException.TimesheetNotFoundException;
import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.TimesheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimesheetService implements CrudService<TimesheetDTO, Integer>{

    @Autowired
    private TimesheetMapper mapper;

    @Autowired
    private TimesheetRepository repo;

    @Override
    public void create(TimesheetDTO toCreate) throws ElementAlreadyExistException {
        if (repo.existsById(toCreate.getId()))
            throw new TimesheetAlreadyExistException(toCreate.getId());
        repo.save(mapper.toEntity(toCreate));
    }

    @Override
    @Transactional
    public TimesheetDTO getOne(Integer id) throws ElementNotFoundException {
        Timesheet entity = repo.findById(id)
                .orElseThrow(() -> new TimesheetNotFoundException(id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<TimesheetDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TimesheetDTO> getAllByBaby(int babyId)
    {
        List<Timesheet> timesheets = repo.findAllByBabyId(babyId);
        return timesheets.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(TimesheetDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new TimesheetNotFoundException(toUpdate.getId());
        repo.save(mapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new TimesheetNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
