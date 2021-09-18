package com.example.secutitytest.Services;

import com.example.secutitytest.Entity.Developer;
import com.example.secutitytest.Exceptions.DevNotFoundException;
import com.example.secutitytest.Repositories.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DevServiceImpl implements DevService{


    @Autowired
    DevRepository repository;

    @Override
    public List<Developer> getAll() {
        return (List<Developer>) repository.findAll();
    }

    @Override
    public Developer getById(Long id) {

       return repository.findById(id).
                orElseThrow(()->new DevNotFoundException("User with id"+id +"not found!"));

    }

    @Override
    public void save(Developer developer) {
        repository.save(developer);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Developer developer, Long id) {

    }
}
