package com.epam.jeka.jpacomplexrelations.services;

import com.epam.jeka.jpacomplexrelations.model.DatabaseInstance;
import com.epam.jeka.jpacomplexrelations.repo.DatabaseInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MainService {

    @Autowired
    DatabaseInstanceRepo repo;
    public void save(DatabaseInstance databaseInstance){
        repo.save(databaseInstance);
    }
}
