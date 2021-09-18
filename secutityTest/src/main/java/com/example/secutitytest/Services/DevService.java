package com.example.secutitytest.Services;


import com.example.secutitytest.Entity.Developer;
import com.example.secutitytest.Repositories.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DevService{



    public List<Developer> getAll();

    public Developer getById(Long id);

    public void save(Developer developer);

    public void delete(Long id);

    public void update(Developer developer, Long id);



}
